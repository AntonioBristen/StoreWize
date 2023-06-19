package com.cerberobeta.StoreWize.controllers;

import com.cerberobeta.StoreWize.beans.GeneralResponseDTO;
import com.cerberobeta.StoreWize.utils.ConstantsUtil;
import com.cerberobeta.StoreWize.utils.ProcesUtil;
import com.cerberobeta.StoreWizeReflexion.ResultReflexionEntity;
import com.cerberobeta.StoreWizeReflexion.ServiceReflexion;
import com.cerberobeta.StoreWizeReflexion.ReadCategoriesService;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/v1/categorys/reflexion")
public class StoreWizeCategoryReflexionController {


    ServiceReflexion serviceReflexion = new ServiceReflexion();
    @GetMapping("/modul-category")
    public ResponseEntity<GeneralResponseDTO> getCategories (@RequestHeader(name = ConstantsUtil.HEADER_METHOD, required = true) final String met)
    {
        this.generateMDC();
        GeneralResponseDTO generalResponseDTO = new GeneralResponseDTO();
        ResultReflexionEntity resultReflexionEntity = new ResultReflexionEntity();
        ReadCategoriesService readCategoriesService = new ReadCategoriesService();

        resultReflexionEntity = serviceReflexion.processReflexion(readCategoriesService , met);

        generalResponseDTO.setResult(resultReflexionEntity);

        return new ResponseEntity(GeneralResponseDTO.builder().setResultado(generalResponseDTO.getResult()).build(), OK);
    }

    public void generateMDC()
    {
        String logId = ProcesUtil.generateRandomId();
        MDC.put(ConstantsUtil.TRACEID, logId);
        MDC.put(ConstantsUtil.SPANID, logId);
    }
}
