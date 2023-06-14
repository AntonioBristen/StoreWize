package com.cerberobeta.StoreWize.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.TimeZone;

public class SerializerUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(SerializerUtils.class);
    private static final ObjectMapper mapper = new ObjectMapper();


    static {
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        mapper.setTimeZone(TimeZone.getTimeZone("Mexico/General"));
    }

    public static <T> T jsonAObjeto(String json, Class<T> clase) {
        Object object = null;
        try {
            object = mapper.readValue(json, clase);
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return clase.cast(object);
    }



}
