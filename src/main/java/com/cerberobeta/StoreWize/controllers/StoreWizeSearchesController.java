package com.cerberobeta.StoreWize.controllers;

import com.cerberobeta.StoreWize.exception.RestResponseException;
import com.cerberobeta.StoreWize.utils.GeneralResponseDTO;
import com.cerberobeta.StoreWize.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/searches")
public class StoreWizeSearchesController {

    @Autowired
    private ProductsService productsService = new ProductsService();

    @GetMapping(value = "/products")
    public ResponseEntity<GeneralResponseDTO> obtenerProductos ()
            throws RestResponseException
    {
        return productsService.obtenerProductos();
    }
}
