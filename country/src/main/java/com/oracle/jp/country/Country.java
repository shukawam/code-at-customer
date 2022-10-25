package com.oracle.jp.country;

import com.oracle.apm.agent.integration.helidon.ApmTracerProvider;
import javax.persistence.*;

/**
 * @author shukawam
 */
@Entity(name = "Country")
@Table(name = "COUNTRY")
@Access(AccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "getAllCountry", query = "SELECT c FROM Country c"),
        @NamedQuery(name = "getCountryById", query = "SELECT c FROM Country c WHERE c.countryId = :countryId")
})
public class Country {
    @Id
    @Column(name = "COUNTRY_ID")
    private String countryId;
    @Column(name = "COUNTRY_NAME")
    private String countryName;

    public String getCountryId() {
        return countryId;
    }

    public void setCode(String countryId) {
        this.countryId = countryId;
    }

    public String getContryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}
