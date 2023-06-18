package com.cerberobeta.StoreWize.controllers;


import com.cerberobeta.StoreWize.beans.GeneralResponseDTO;
import com.cerberobeta.StoreWize.entities.carts.StoreCartEntiry;
import com.cerberobeta.StoreWize.services.StoreCartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/read/store")
public class StoreWIzeStoreCartsController {

    @Autowired
    StoreCartsService storeCartsService;

    @GetMapping(value = "/carts")
    public ResponseEntity<GeneralResponseDTO> getCarts ()
    {
        return storeCartsService.getCarts();
    }
}
