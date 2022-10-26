package com.oracle.jp.fn.country;

import io.micronaut.data.repository.CrudRepository;

/**
 * @author shukawam
 */
public interface CountryRepository extends CrudRepository<Country, String> {
}
