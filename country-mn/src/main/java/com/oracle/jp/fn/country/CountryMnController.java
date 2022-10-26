package com.oracle.jp.fn.country;

import io.micronaut.http.annotation.*;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.MediaType;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller("/code-at-customer/country")
public class CountryMnController {
    private static final Logger logger = Logger.getLogger(CountryMnController.class.getName());

    @Inject
    CountryRepository countryRepository;

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getAllCountry() {
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);
        return countryList;
    }

    @Get("/id/{countryId}")
    public Country getCountryByCountryId(String countryId) {
        Optional<Country> countryOptional = countryRepository.findById(countryId);
        if (countryOptional.isEmpty()) {
            logger.warning("Unable to found country by id: " + countryId);
            throw new NotFoundException();
        }
        return countryOptional.get();
    }

}
