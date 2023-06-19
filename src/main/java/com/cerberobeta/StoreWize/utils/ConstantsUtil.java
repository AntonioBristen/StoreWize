package com.cerberobeta.StoreWize.utils;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Value("${apireststore.url.carts}")
    public String urlcarts;

    @Value("${apireststore.timeout: 10000}")
    public int timeOut;

    public static final String TRACEID = "traceId";
    public static final String SPANID = "spanId";
    public static final String HEADER_IUS = "x-ius";

    public static final String USER = "wizeantonio";

    public static final String PASS = "{noop}nolapodranvulnerar";

    public static final String ROL_ACCES = "ADMIN";

    public static final String PATH_ACCES = "/acces";

    public ConstantsUtil() {
    }
}
