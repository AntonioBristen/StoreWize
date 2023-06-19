package com.cerberobeta.StoreWize.controllers;

import com.cerberobeta.StoreWize.beans.GeneralResponseDTO;
import com.cerberobeta.StoreWize.services.ProductsService;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/v1/searches")
public class StoreWizeSearchesController {

    private ProductsService productsService;

    public StoreWizeSearchesController(ApplicationContext contextStore)
    {
        this.productsService = contextStore.getBean(ProductsService.class);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<GeneralResponseDTO> obtenerProductos ()
    {
        return productsService.obtenerProductos();
    }
}
