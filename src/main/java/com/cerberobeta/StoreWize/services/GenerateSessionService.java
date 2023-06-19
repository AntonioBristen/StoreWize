package com.cerberobeta.StoreWize.services;

import com.cerberobeta.StoreWize.beans.SessionResponseDTO;
import com.cerberobeta.StoreWize.daos.GenerateSessionDAO;
import com.cerberobeta.StoreWize.entities.session.SessionEntity;
import com.cerberobeta.StoreWize.exception.HandlerException;
import com.cerberobeta.StoreWize.parser.SessionParser;
import com.cerberobeta.StoreWize.beans.GeneralResponseDTO;
import com.cerberobeta.StoreWize.utils.ConstantsUtil;
import com.cerberobeta.StoreWize.utils.ProcesUtil;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.OK;

@Service
public class GenerateSessionService {

    @Autowired
    GenerateSessionDAO generateSessionDAO;

    @Autowired
    SessionParser sessionParser;
    @Autowired
    HandlerException handlerException;

    @Autowired
    ConstantsUtil constantsUtil;

    private String hash;

    public ResponseEntity<GeneralResponseDTO> users (final String ius, Integer hascode, String sessionId)
    {
        this.generateMDC();

        SessionResponseDTO sessionResponseDTO;

        SessionEntity sessionEntity = new SessionEntity();
        sessionEntity = generateSessionDAO.users(ius);
        sessionResponseDTO = sessionParser.sourceSession(hascode, sessionId, sessionEntity);

        return new ResponseEntity(GeneralResponseDTO.builder().setResultado(sessionResponseDTO.getResultado()).build(), OK);
    }

    public void generateMDC()
    {
        String logId = ProcesUtil.generateRandomId();
        MDC.put(constantsUtil.TRACEID, logId);
        MDC.put(constantsUtil.SPANID, logId);
    }

}
