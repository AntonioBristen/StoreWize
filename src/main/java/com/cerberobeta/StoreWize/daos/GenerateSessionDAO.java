package com.cerberobeta.StoreWize.daos;

import com.cerberobeta.StoreWize.beans.ProductsResponseDTO;
import com.cerberobeta.StoreWize.beans.SessionResponseDTO;
import com.cerberobeta.StoreWize.entities.products.ProductEntity;
import com.cerberobeta.StoreWize.entities.session.SessionEntity;
import com.cerberobeta.StoreWize.utils.ConstantsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class GenerateSessionDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateSessionDAO.class);
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    ConstantsUtil constantsUtil;

    public SessionEntity users(final String ius)
    {
        SessionEntity sessionEntity = new SessionEntity();
        try
        {
            sessionEntity = restTemplate.getForObject(constantsUtil.urlusers.concat(ius), SessionEntity.class);

        }catch (Exception ex)
        {
            LOGGER.info("Exception_Detail: " +  ex);
        }

        return  sessionEntity;
    }
}
