package com.oracle.jp.fn.country;

import io.micronaut.core.annotation.Introspected;

/**
 * @author shukawam
 */
@Introspected
public class Country {
    private String countryId;
    private String countryName;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
