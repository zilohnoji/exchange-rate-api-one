package com.donatoordep;

import com.donatoordep.entities.Address;
import com.donatoordep.mappers.Deserializer;
import com.donatoordep.mappers.impl.JacksonDeserializer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverseTyApplication {

    private static JacksonDeserializer<Address> mapper = JacksonDeserializer.createInstance(Address.class);

    public static void main(String[] args) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/20760580/json/"))
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder().build();

        HttpResponse<String> t = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        Address address = mapper.deserialize(t.body());
    }
}