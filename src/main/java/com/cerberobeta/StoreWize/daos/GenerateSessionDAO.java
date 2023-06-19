package com.cerberobeta.StoreWize.daos;

import com.cerberobeta.StoreWize.entities.session.SessionEntity;
import com.cerberobeta.StoreWize.utils.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GenerateSessionDAO {
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    ConstantsUtil constantsUtil;

    public SessionEntity users(final String ius)
    {
            SessionEntity sessionEntity;
            sessionEntity = restTemplate.getForObject(constantsUtil.urlusers.concat(ius), SessionEntity.class);

        return  sessionEntity;
    }
}
