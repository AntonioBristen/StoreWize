package com.cerberobeta.StoreWize.utils;

import java.util.UUID;

public class ProcesUtil {

    public ProcesUtil(){ }
    public static String generateRandomId(){
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }
}