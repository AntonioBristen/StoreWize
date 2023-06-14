package com.cerberobeta.StoreWize.daos;

import static com.cerberobeta.StoreWize.utils.ExceptionUtils.validaHttpStatusResponse;
import static java.util.Arrays.asList;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.cerberobeta.StoreWize.exception.APIException;
import com.cerberobeta.StoreWize.exception.RestResponseException;
import com.cerberobeta.StoreWize.utils.ConstantsUtil;
import com.cerberobeta.StoreWize.beans.ProductsResponseDTO;
import com.cerberobeta.StoreWize.entities.products.ProductEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductDAO.class);
    RestTemplate restTemplate = new RestTemplate();
    private static final int COD_EXCEPCION = 1404;
    @Autowired
    ConstantsUtil constantsUtil;

    public ProductsResponseDTO obtenerProductos() throws RestResponseException {
        ProductsResponseDTO productsResponseDTO = new ProductsResponseDTO();
        List<ProductEntity> products;
        ProductEntity[] response = restTemplate.getForObject(constantsUtil.urlobtenerProductos, ProductEntity[].class);
        products = Arrays.asList(response);

        products = null;

        if (products.isEmpty())
        {
            throw new APIException(COD_EXCEPCION, asList("Resultado nulo o vacio."), NOT_FOUND);
        }

        productsResponseDTO.setResultado(products);

        return  productsResponseDTO;
    }
}
