package br.com.alura.pickupcep.models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Conexao {
    public EnderecosViaCEP buscaCEP (String busca) {
        String api = "https://viacep.com.br/ws/" + busca + "/json/";
        // exemplo: 01001000

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(api))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), EnderecosViaCEP.class);
        } catch (Exception e) {
            System.out.println("Não consegui obter o endereço apartir desse CEP:");
            throw new RuntimeException(e.getMessage());
        }
    }
}
