package br.com.alura.pickupcep.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeEndereco {
    public void geradorDeEnderecoJSON (EnderecosViaCEP enderecos) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter escritor = new FileWriter(enderecos.cep() + ".json");
        escritor.write(gson.toJson(enderecos));
        escritor.close();
    }
}
