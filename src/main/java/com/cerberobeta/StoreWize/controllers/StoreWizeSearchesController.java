package com.cerberobeta.StoreWize.controllers;

import com.cerberobeta.StoreWize.beans.GeneralResponseDTO;
import com.cerberobeta.StoreWize.services.ProductsService;
import com.cerberobeta.StoreWize.utils.ConstantsUtil;
import com.cerberobeta.StoreWize.utils.ProcesUtil;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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
