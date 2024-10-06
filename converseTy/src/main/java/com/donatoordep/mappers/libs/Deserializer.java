package com.donatoordep.mappers.libs;


public interface Deserializer<T, L> {

    T deserialize(String data) throws Exception;

    L getMapperInstance();
}