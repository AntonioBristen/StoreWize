package com.cerberobeta.StoreWize.services;

import com.cerberobeta.StoreWize.beans.ProductsResponseDTO;
import com.cerberobeta.StoreWize.beans.SessionResponseDTO;
import com.cerberobeta.StoreWize.daos.GenerateSessionDAO;
import com.cerberobeta.StoreWize.entities.session.DetailsSessionEntity;
import com.cerberobeta.StoreWize.entities.session.RequestSessionEntity;
import com.cerberobeta.StoreWize.entities.session.SessionEntity;
import com.cerberobeta.StoreWize.parser.SessionParser;
import com.cerberobeta.StoreWize.utils.GeneralResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@Service
public class GenerateSessionService {

    @Autowired
    GenerateSessionDAO generateSessionDAO;

    @Autowired
    SessionParser sessionParser;

    private String hash;

    public ResponseEntity<GeneralResponseDTO> users(final String ius, Integer hascode, String sessionId)
    {
        SessionResponseDTO sessionResponseDTO;

        SessionEntity sessionEntity = new SessionEntity();

        try {


            sessionEntity = generateSessionDAO.users(ius);

            if (sessionEntity == null || sessionEntity.getUsername() != null) {
                throw new Exception("Resultado nulo o vacio. No se encontraron datos");
            }
        }catch (Exception ex)
        {

        }

        sessionResponseDTO = sessionParser.sourceSession(hascode, sessionId, sessionEntity);

        return new ResponseEntity(GeneralResponseDTO.builder().setResultado(sessionResponseDTO.getResultado()).build(), OK);
    }

}
