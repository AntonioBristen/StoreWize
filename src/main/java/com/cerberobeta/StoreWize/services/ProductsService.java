package com.cerberobeta.StoreWize.services;

import com.cerberobeta.StoreWize.beans.ProductsResponseDTO;
import com.cerberobeta.StoreWize.entities.products.Product;
import com.cerberobeta.StoreWize.utils.GeneralResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Component
public class ProductsService {

    public ResponseEntity<GeneralResponseDTO> obtenerProductos()
    {
        List<Product> productos = new ArrayList<Product>();
        ProductsResponseDTO productsResponseDTO = new ProductsResponseDTO();

            return new ResponseEntity(GeneralResponseDTO.builder().setResultado(productsResponseDTO).build(), OK);
    }

}
