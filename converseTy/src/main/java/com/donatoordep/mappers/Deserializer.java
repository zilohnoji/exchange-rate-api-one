package com.donatoordep.mappers;


public interface Deserializer<T, L> {

    T deserialize(String data) throws Exception;

    L getMapperInstance();
}