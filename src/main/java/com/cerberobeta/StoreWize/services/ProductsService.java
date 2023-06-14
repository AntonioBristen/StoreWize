package com.cerberobeta.StoreWize.services;

import com.cerberobeta.StoreWize.beans.ProductsResponseDTO;
import com.cerberobeta.StoreWize.daos.ProductDAO;
import com.cerberobeta.StoreWize.exception.RestResponseException;
import com.cerberobeta.StoreWize.utils.GeneralResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.OK;

@Service
public class ProductsService {

    @Autowired
    ProductDAO productDAO;
    public ResponseEntity<GeneralResponseDTO> obtenerProductos()
            throws RestResponseException
    {
        ProductsResponseDTO productsResponseDTO = new ProductsResponseDTO();
        productsResponseDTO = productDAO.obtenerProductos();
            return new ResponseEntity(GeneralResponseDTO.builder().setResultado(productsResponseDTO.getResultado()).build(), OK);
    }

}
