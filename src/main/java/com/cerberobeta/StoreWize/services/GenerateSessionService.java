package com.cerberobeta.StoreWize.services;

import com.cerberobeta.StoreWize.beans.SessionResponseDTO;
import com.cerberobeta.StoreWize.daos.GenerateSessionDAO;
import com.cerberobeta.StoreWize.entities.session.SessionEntity;
import com.cerberobeta.StoreWize.exception.HandlerException;
import com.cerberobeta.StoreWize.parser.SessionParser;
import com.cerberobeta.StoreWize.beans.GeneralResponseDTO;
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

    private String hash;

    public ResponseEntity<GeneralResponseDTO> users (final String ius, Integer hascode, String sessionId) {
        SessionResponseDTO sessionResponseDTO;

        SessionEntity sessionEntity = new SessionEntity();
        sessionEntity = generateSessionDAO.users(ius);
        sessionResponseDTO = sessionParser.sourceSession(hascode, sessionId, sessionEntity);

        return new ResponseEntity(GeneralResponseDTO.builder().setResultado(sessionResponseDTO.getResultado()).build(), OK);
    }

}
