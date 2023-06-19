package com.cerberobeta.StoreWize.services;

import com.cerberobeta.StoreWize.beans.GeneralResponseDTO;
import com.cerberobeta.StoreWize.entities.carts.CartsEntity;
import com.cerberobeta.StoreWize.repository.CartsRepository;
import com.cerberobeta.StoreWize.utils.ConstantsUtil;
import com.cerberobeta.StoreWize.utils.ProcesUtil;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Service
public class CartsService {

    @Autowired
    public CartsRepository cartsRepository;

    @Autowired
    ConstantsUtil constantsUtil;

    @Transactional(readOnly = true)
    public ResponseEntity<GeneralResponseDTO> getCarts()
    {
        this.generateMDC();
        GeneralResponseDTO generalResponseDTO = new GeneralResponseDTO();
        List<CartsEntity> cartsEntity = new ArrayList<>();
        cartsEntity = cartsRepository.findAll();
        generalResponseDTO.setResult(cartsEntity);

        return new ResponseEntity(GeneralResponseDTO.builder().setResultado(generalResponseDTO.getResult()).build(), OK);
    }

    public ResponseEntity<GeneralResponseDTO> postCarts(CartsEntity carts)
    {
        this.generateMDC();
        cartsRepository.save(carts);
        return new ResponseEntity(GeneralResponseDTO.builder().setMensaje("Operaci\u00f3n Exitosa.").build(), CREATED);
    }

    @Transactional
    public ResponseEntity<GeneralResponseDTO> updateCarts(final CartsEntity carts)
    {
        this.generateMDC();
        GeneralResponseDTO generalResponseDTO = new GeneralResponseDTO();

        final CartsEntity cartsEntity = cartsRepository.findById(carts.getId()).orElseThrow(NullPointerException::new);

        cartsEntity.setDate(carts.getDate());
        cartsEntity.setQuantity(carts.getQuantity());
        cartsEntity.setProductId(carts.getProductId());
        cartsEntity.setUserId(carts.getUserId());

        return new ResponseEntity(GeneralResponseDTO.builder().setMensaje("Operaci\u00f3n Exitosa.").build(), OK);
    }

    public ResponseEntity<GeneralResponseDTO> postCartsReactivMono(CartsEntity carts)
    {
        this.generateMDC();
        Mono.just(cartsRepository.save(carts));
        return new ResponseEntity(GeneralResponseDTO.builder().setMensaje("Operaci\u00f3n Exitosa.").build(), CREATED);
    }

    public ResponseEntity<GeneralResponseDTO> postCartsReactivFlux(List<CartsEntity> carts)
    {
        this.generateMDC();
        Flux.fromIterable(carts).subscribe(c ->  cartsRepository.save(c));
        return new ResponseEntity(GeneralResponseDTO.builder().setMensaje("Operaci\u00f3n Exitosa.").build(), CREATED);
    }

    public void generateMDC()
    {
        String logId = ProcesUtil.generateRandomId();
        MDC.put(constantsUtil.TRACEID, logId);
        MDC.put(constantsUtil.SPANID, logId);
    }


}
