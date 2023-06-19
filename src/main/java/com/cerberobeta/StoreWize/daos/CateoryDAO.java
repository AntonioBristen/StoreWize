package com.cerberobeta.StoreWize.daos;

import com.cerberobeta.StoreWize.utils.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CateoryDAO {
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    ConstantsUtil constantsUtil;

    public String[] getCategories()
    {
        String[] category = restTemplate.getForObject(constantsUtil.urlcategories, String[].class);
        return category;
    }
}
