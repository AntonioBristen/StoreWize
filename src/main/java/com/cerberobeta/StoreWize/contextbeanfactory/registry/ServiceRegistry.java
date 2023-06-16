package com.cerberobeta.StoreWize.contextbeanfactory.registry;

import org.springframework.stereotype.Component;

@Component
public interface ServiceRegistry {
    public AdapterService getService(String serviceAlias);
}
