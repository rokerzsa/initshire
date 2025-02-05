package com.redyhire.application.instances.core;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperInstance {
    private static volatile ObjectMapper objectMapper;

    public static ObjectMapper getInstance() {
        if (objectMapper == null) {
            synchronized (ObjectMapperInstance.class) {
                // Double-checked locking to avoid unnecessary synchronization
                if (objectMapper == null) {
                    objectMapper = new ObjectMapper();
                }
            }
        }
        return objectMapper;
    }
}
