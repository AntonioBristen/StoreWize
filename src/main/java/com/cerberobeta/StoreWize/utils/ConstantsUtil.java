package com.cerberobeta.StoreWize.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public final class ConstantsUtil {

    @Value("${apireststore.url.products}")
    public String urlobtenerProductos;

    @Value("${apireststore.url.users}")
    public String urlusers;

    @Value("${apireststore.url.categories}")
    public String urlcategories;

    @Value("${apireststore.timeout: 10000}")
    public int timeOut;

    public static final String TRACEID = "traceId";

    public static final String SPANID = "spanId";
    public static final String HEADER_IUS = "x-ius";

    public static final int COD_EXCEPCION = 1404;

    private ConstantsUtil() { }
}
