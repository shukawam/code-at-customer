package com.oracle.jp.fn.country;

import com.google.gson.Gson;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@Controller("/code-at-customer")
public class CountryMnController {

    private final OrdsConfig ordsConfig;

    @Inject
    public CountryMnController(OrdsConfig ordsConfig) {
        this.ordsConfig = ordsConfig;

    }

    @Get("/country")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getAllCountry() throws InterruptedException, IOException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/country", ordsConfig.getEndpoint())))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
