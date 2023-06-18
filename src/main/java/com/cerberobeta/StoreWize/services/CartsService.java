package com.cerberobeta.StoreWize.services;

import com.cerberobeta.StoreWize.beans.GeneralResponseDTO;
import com.cerberobeta.StoreWize.entities.carts.CartsEntity;
import com.cerberobeta.StoreWize.repository.CartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Service
public class CartsService {

    @Autowired
    public CartsRepository cartsRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<GeneralResponseDTO> getCarts()
    {
        GeneralResponseDTO generalResponseDTO = new GeneralResponseDTO();
        List<CartsEntity> cartsEntity = new ArrayList<>();
        cartsEntity = cartsRepository.findAll();
        generalResponseDTO.setResult(cartsEntity);

        return new ResponseEntity(GeneralResponseDTO.builder().setResultado(generalResponseDTO.getResult()).build(), OK);
    }

    public ResponseEntity<GeneralResponseDTO> postCarts(CartsEntity carts)
    {
        cartsRepository.save(carts);
        return new ResponseEntity(GeneralResponseDTO.builder().setMensaje("Operaci\u00f3n Exitosa.").build(), CREATED);
    }

    @Transactional
    public ResponseEntity<GeneralResponseDTO> updateCarts(final CartsEntity carts)
    {
        GeneralResponseDTO generalResponseDTO = new GeneralResponseDTO();

        final CartsEntity cartsEntity = cartsRepository.findById(carts.getId()).orElseThrow(NullPointerException::new);

        cartsEntity.setDate(carts.getDate());
        cartsEntity.setQuantity(carts.getQuantity());
        cartsEntity.setProductId(carts.getProductId());
        cartsEntity.setUserId(carts.getUserId());

        return new ResponseEntity(GeneralResponseDTO.builder().setMensaje("Operaci\u00f3n Exitosa.").build(), OK);
    }



}
