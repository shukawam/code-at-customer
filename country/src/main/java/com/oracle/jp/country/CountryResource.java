package com.oracle.jp.country;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

/**
 * @author shukawam
 */
@Path("country")
public class CountryResource {
    @PersistenceContext(unitName = "CountryPU")
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getAllCountry() {
        return em.createNamedQuery("getAllCountry", Country.class).getResultList();
    }

    @GET
    @Path("countryId/{countryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Country getCountryById(@PathParam("countryId") String countryId) {
        List<Country> countryList =  em.createNamedQuery("getCountryById", Country.class)
                .setParameter("countryId", countryId)
                .getResultList();
        if (countryList.isEmpty()) {
            throw new NotFoundException("Unable to fund country with id " + countryId);
        }
        return countryList.get(0);
    }
}
