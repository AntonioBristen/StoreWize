package com.cerberobeta.StoreWize.daos;

import com.cerberobeta.StoreWize.beans.CartsResponseDTO;
import com.cerberobeta.StoreWize.beans.ProductsResponseDTO;
import com.cerberobeta.StoreWize.entities.carts.StoreCartEntiry;
import com.cerberobeta.StoreWize.entities.products.ProductEntity;
import com.cerberobeta.StoreWize.utils.ConstantsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CartsDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartsDAO.class);
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    ConstantsUtil constantsUtil;

    public List<StoreCartEntiry> getCarts()
    {
        List<StoreCartEntiry> carts = new ArrayList<StoreCartEntiry>();
        StoreCartEntiry[] response = restTemplate.getForObject(constantsUtil.urlcarts, StoreCartEntiry[].class);
        carts = Arrays.asList(response);

        return carts;
    }

}
