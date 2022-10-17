package com.oracle.jp.fn.country;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author shukawam
 */
@Entity
public class Country {
    @Id
    @Column(name = "COUNTRY_CODE")
    private String countryCode;
    @Column(name = "ENGLISH_NAME")
    private String englishName;
    @Column(name = "JAPANESE_NAME")
    private String japaneseName;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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
