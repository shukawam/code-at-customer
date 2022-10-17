package com.oracle.jp.fn.country;

import io.micronaut.http.annotation.*;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.MediaType;
import jakarta.inject.Inject;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

@Controller("/country")
public class CountryFunctionController {
    @Inject
    private CountryRepository countryRepository;

    @Get(uri = "/health")
    @Produces(MediaType.TEXT_PLAIN)
    public String healthCheck() {
        return "ok";
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get
    public List<Country> getAllCountry() {
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);
        return countryList;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get(uri = "/code/{countryCode}")
    public Country getCountryByCountryCode(@PathVariable("countryCode") String countryCode) {
        var result = countryRepository.findById(countryCode);
        if (result.isEmpty()) {
            throw new NotFoundException();
        }
        return result.get();
    }
}
