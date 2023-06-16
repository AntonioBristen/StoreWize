package com.cerberobeta.StoreWize.exception;

import com.cerberobeta.StoreWize.beans.GeneralResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class HandlerException {

    private static final Logger LOG = LoggerFactory.getLogger(HandlerException.class);
    private static final String TRACEID = "traceId";
    private static final String SPANID = "spanId";
    private static final String DETALLES = "Detail";
    private static final String EXCEPTION_DETALLES = "Exception_Detail";
    private static final String RESPONSE = "response";

    private static final String BAD_REQUEST_CODIGO_BASE =
            "400.CerberoBeta-StoreWize.400";
    private static final String BAD_REQUEST_MSJ =
            "Par\u00e1metros no v\u00e1lidos, por favor valide su informaci\u00f3n";
    private static final String BAD_REQUEST_INFO_BASE =
            "https://fakestoreapi.com/docs";

    private static final String INTERNAL_ERROR_CODIGO_BASE = "500.CerberoBeta-StoreWize.500";
    private static final String INTERNAL_ERROR_MSJ =
            "Problemas al procesar su solicitud, favor de contactar a su administrador.";
    private static final String INTERNAL_ERROR_INFO_BASE =
            "https://fakestoreapi.com/docs";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralResponseDTO> handlerException(Exception e) throws JsonProcessingException {
        LOG.error(e.getClass().getCanonicalName());
        GeneralResponseDTO response = new GeneralResponseDTO();
        response.setCode(INTERNAL_ERROR_CODIGO_BASE.concat("2"));
        response.setMessage(INTERNAL_ERROR_MSJ);
        response.setDetails(Arrays.asList("Internal Error"));
        response.setFolio(MDC.get(TRACEID) + "-" + MDC.get(SPANID));
        response.setInfo(INTERNAL_ERROR_INFO_BASE + "2");
        LOG.info(INTERNAL_SERVER_ERROR.toString());
        return new ResponseEntity<GeneralResponseDTO>(response, INTERNAL_SERVER_ERROR);
    }

}
