package com.example.product2.deserializer;

import com.example.product2.entities.Categorie;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class CategoryDeserializer implements Deserializer<Categorie> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public Categorie deserialize(String topic, byte[] data) {
        ObjectMapper objectMapper = new ObjectMapper();
        Categorie categorie = null;
        try {
            categorie = objectMapper.readValue(data, Categorie.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categorie;
    }
    @Override
    public void close() {}


}
