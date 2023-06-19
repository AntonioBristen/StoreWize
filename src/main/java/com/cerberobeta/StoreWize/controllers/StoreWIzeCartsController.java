package com.cerberobeta.StoreWize.controllers;

import com.cerberobeta.StoreWize.beans.GeneralResponseDTO;
import com.cerberobeta.StoreWize.entities.carts.CartsEntity;
import com.cerberobeta.StoreWize.services.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/edition/")
public class StoreWIzeCartsController {

    @Autowired
    public CartsService cartsService;

    @GetMapping(value = "carts")
    public ResponseEntity<GeneralResponseDTO> getCarts()
    {
       return cartsService.getCarts();
    }

    @PostMapping(value = "carts")
    public ResponseEntity<GeneralResponseDTO> postCarts(@Valid @RequestBody CartsEntity carts)
    {
        return cartsService.postCarts(carts);
    }

    @PutMapping(value = "carts")
    public ResponseEntity<GeneralResponseDTO> putCarts(@Valid @RequestBody final CartsEntity carts)
    {
        return cartsService.updateCarts(carts);
    }

    @PostMapping(value = "/reactiv/carts-mono")
    public ResponseEntity<GeneralResponseDTO> postCartsReactivMono(@Valid @RequestBody CartsEntity carts)
    {
        return cartsService.postCartsReactivMono(carts);
    }

    @PostMapping(value = "/reactiv/carts-flux")
    public ResponseEntity<GeneralResponseDTO> postCartsReactivFlux(@Valid @RequestBody List<CartsEntity> carts)
    {
        return cartsService.postCartsReactivFlux(carts);
    }

}

