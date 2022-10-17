package com.oracle.jp.fn.country;

import io.micronaut.http.annotation.*;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.MediaType;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Controller("/code-at-customer/country")
public class CountryFunctionController {

    @Inject
    private CountryRepository countryRepository;

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getAllCountry() {
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);
        return countryList;
    }

}
