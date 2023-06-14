package com.cerberobeta.StoreWize.parser;


import com.cerberobeta.StoreWize.beans.SessionResponseDTO;
import com.cerberobeta.StoreWize.entities.session.DetailsSessionEntity;
import com.cerberobeta.StoreWize.entities.session.RequestSessionEntity;
import com.cerberobeta.StoreWize.entities.session.SessionEntity;
import org.springframework.stereotype.Component;

@Component
public class SessionParser {

    public SessionResponseDTO sourceSession(Integer hascode, String sessionId, SessionEntity sessionEntity)
    {
        SessionResponseDTO sessionResponseDTO = new SessionResponseDTO();
        RequestSessionEntity requestSessionEntity = new RequestSessionEntity();

        DetailsSessionEntity detailsSessionEntity = new DetailsSessionEntity();
        detailsSessionEntity.setHashCode(hascode);
        detailsSessionEntity.setSessionId(sessionId);

        requestSessionEntity.setSession(sessionEntity);
        requestSessionEntity.setDetails(detailsSessionEntity);

        sessionResponseDTO.setResultado(requestSessionEntity);

        return  sessionResponseDTO;
    }
}
