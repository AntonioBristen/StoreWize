package com.cerberobeta.StoreWize.services;

import com.cerberobeta.StoreWize.beans.ProductsResponseDTO;
import com.cerberobeta.StoreWize.daos.ProductDAO;
import com.cerberobeta.StoreWize.beans.GeneralResponseDTO;
import com.cerberobeta.StoreWize.utils.ConstantsUtil;
import com.cerberobeta.StoreWize.utils.ProcesUtil;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.OK;

@Service
public class ProductsService {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ConstantsUtil constantsUtil;
    public ResponseEntity<GeneralResponseDTO> obtenerProductos()
    {
        String logId = ProcesUtil.generateRandomId();
        MDC.put(constantsUtil.TRACEID, logId);
        MDC.put(constantsUtil.SPANID, logId);
        ProductsResponseDTO productsResponseDTO = new ProductsResponseDTO();
        productsResponseDTO = productDAO.obtenerProductos();

            return new ResponseEntity(GeneralResponseDTO.builder().setResultado(productsResponseDTO.getResultado()).build(), OK);
    }

}
