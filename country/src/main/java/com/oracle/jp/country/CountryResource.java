package com.oracle.jp.country;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

/**
 * @author shukawam
 */
@Path("country")
public class CountryResource {
    @PersistenceContext(unitName = "CountryPU")
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getCountry() {
        return em.createNamedQuery("getAllCountry", Country.class).getResultList();
    }

    @GET
    @Path("id/{countryId}")
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
