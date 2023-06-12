package com.cerberobeta.StoreWize.controllers;

import com.cerberobeta.StoreWize.utils.GeneralResponseDTO;
import com.cerberobeta.StoreWize.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class StoreWizeController {

    @Autowired
    private ProductsService productsService = new ProductsService();
    public StoreWizeController()
    {

    }

    @GetMapping(value = "/products")
    public ResponseEntity<GeneralResponseDTO> obtenerProductos ()
    {

        return productsService.obtenerProductos();
    }
}
