package com.cerberobeta.StoreWize.daos;

import com.cerberobeta.StoreWize.utils.ConstantsUtil;
import com.cerberobeta.StoreWize.beans.ProductsResponseDTO;
import com.cerberobeta.StoreWize.entities.products.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductDAO {
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    ConstantsUtil constantsUtil;

    public ProductsResponseDTO obtenerProductos(){
        ProductsResponseDTO productsResponseDTO = new ProductsResponseDTO();
        List<ProductEntity> products;
        ProductEntity[] response = restTemplate.getForObject(constantsUtil.urlobtenerProductos, ProductEntity[].class);
        products = Arrays.asList(response);

        productsResponseDTO.setResultado(products);

        return  productsResponseDTO;
    }
}
