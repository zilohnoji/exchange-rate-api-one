package com.donatoordep.mappers.impl;

import com.donatoordep.mappers.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JacksonDeserializer<T> implements Deserializer<T, ObjectMapper> {

    private final Class<T> CLASS_TYPE;
    private final ObjectMapper MAPPER = new ObjectMapper();

    private JacksonDeserializer(Class<T> tClass) {
        CLASS_TYPE = tClass;
    }

    public static <T> JacksonDeserializer<T> createInstance(Class<T> tClass) {
        return new JacksonDeserializer<>(tClass);
    }

    @Override
    public T deserialize(final String data) throws Exception {
        return MAPPER.readValue(data, CLASS_TYPE);
    }

    @Override
    public ObjectMapper getMapperInstance() {
        return MAPPER;
    }
}