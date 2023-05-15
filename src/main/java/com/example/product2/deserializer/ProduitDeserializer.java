package com.example.product2.deserializer;

import com.example.product2.entities.Produit;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.InputStream;
import java.util.Map;

public class ProduitDeserializer implements Deserializer<Produit> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public Produit deserialize(String topic, byte[] data) {
        ObjectMapper objectMapper = new ObjectMapper();
        Produit produit = null;
        try {
            produit = objectMapper.readValue(data, Produit.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produit;
    }



    @Override
    public void close() {}

}
