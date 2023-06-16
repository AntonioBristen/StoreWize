package com.cerberobeta.StoreWize.controllers;

import com.cerberobeta.StoreWize.beans.GeneralResponseDTO;
import com.cerberobeta.StoreWize.contextbeanfactory.registry.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/v1/categorys/")
public class StoreWizeReadCategoryController {

    @Autowired
    private ServiceRegistry serviceRegistry;

    @GetMapping("{category}")
    public ResponseEntity<GeneralResponseDTO> getCategories (@PathVariable String category)
    {
        GeneralResponseDTO generalResponseDTO = new GeneralResponseDTO();
        generalResponseDTO.setResult(serviceRegistry.getService(category).getCategories());
        return new ResponseEntity(GeneralResponseDTO.builder().setResultado(generalResponseDTO.getResult()).build(), OK);
    }
}
