package com.cerberobeta.StoreWize.controllers;


import com.cerberobeta.StoreWize.services.GenerateSessionService;
import com.cerberobeta.StoreWize.utils.ConstantsUtil;
import com.cerberobeta.StoreWize.beans.GeneralResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/v1/edition")
@Scope(value = "session")
public class StoreWizeEditionController {

    @Autowired
    private GenerateSessionService generateSessionService;

    private final Integer hash =  this.hashCode();
    HttpSession httpSession;
    @GetMapping(value = "/generate-sesion")
    public ResponseEntity<GeneralResponseDTO> generate(
            @RequestHeader(name = ConstantsUtil.HEADER_IUS, required = true) final String ius)
    {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        httpSession = servletRequestAttributes.getRequest().getSession();

        return generateSessionService.users(ius, hash, httpSession.getId().toString());
    }

}
