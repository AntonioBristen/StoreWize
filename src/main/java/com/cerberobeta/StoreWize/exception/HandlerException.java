package com.cerberobeta.StoreWize.exception;

import com.cerberobeta.StoreWize.utils.GeneralResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
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

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<GeneralResponseDTO> handlerMissingRequestHeader(MissingRequestHeaderException e) {
        LOG.debug(DETALLES);

        GeneralResponseDTO response = new GeneralResponseDTO();
        response.setCodigo(BAD_REQUEST_CODIGO_BASE.concat("4"));
        response.setMensaje(BAD_REQUEST_MSJ);
        LOG.info(String.format("Header '%s' requerido", e.getHeaderName()));
        response.setDetalles(Arrays.asList(BAD_REQUEST_MSJ));
        response.setFolio(MDC.get(TRACEID) + "-" + MDC.get(SPANID));
        response.setInfo(BAD_REQUEST_INFO_BASE + "4");
        LOG.info(BAD_REQUEST.toString());
        return new ResponseEntity<GeneralResponseDTO>(response, BAD_REQUEST);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GeneralResponseDTO> handlerNotFoundException(NotFoundException e)
            throws JsonProcessingException {
        GeneralResponseDTO response = new GeneralResponseDTO();
        LOG.info("Sin resultados");
        LOG.debug(DETALLES);
        response.setCodigo(BAD_REQUEST_CODIGO_BASE.concat("1"));
        response.setDetalles(Arrays.asList("La busqueda no arrojo ningun resultado"));
        response.setMensaje("Recurso no encontrado, favor de validar su informaci\u00f3n");
        response.setFolio(MDC.get(TRACEID) + "-" + MDC.get(SPANID));
        response.setInfo(BAD_REQUEST_INFO_BASE);
        LOG.info(NOT_FOUND.toString());
        return new ResponseEntity<GeneralResponseDTO>(response, NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralResponseDTO> handlerException(Exception e) throws JsonProcessingException {
        LOG.error(e.getClass().getCanonicalName());
        GeneralResponseDTO response = new GeneralResponseDTO();
        response.setCodigo(INTERNAL_ERROR_CODIGO_BASE.concat("2"));
        response.setMensaje(INTERNAL_ERROR_MSJ);
        response.setDetalles(Arrays.asList("Internal Error"));
        response.setFolio(MDC.get(TRACEID) + "-" + MDC.get(SPANID));
        response.setInfo(INTERNAL_ERROR_INFO_BASE + "2");
        LOG.info(INTERNAL_SERVER_ERROR.toString());
        return new ResponseEntity<GeneralResponseDTO>(response, INTERNAL_SERVER_ERROR);
    }

}
