package com.oracle.jp.country;

import jakarta.persistence.*;

/**
 * @author shukawam
 */
@Entity(name = "Country")
@Table(name = "COUNTRY")
@Access(AccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "getAllCountry", query = "SELECT c FROM Country c"),
        @NamedQuery(name = "getCountryByCountryCode", query = "SELECT c FROM Country c WHERE c.code = :code")
})
public class Country {
    @Id
    @Column(name = "COUNTRY_CODE")
    private String code;
    @Column(name = "ENGLISH_NAME")
    private String englishName;
    @Column(name = "JAPANESE_NAME")
    private String japaneseName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getJapaneseName() {
        return japaneseName;
    }

    public void setJapaneseName(String japaneseName) {
        this.japaneseName = japaneseName;
    }
}
