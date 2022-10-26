package com.oracle.jp.fn.country;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

/**
 * @author shukawam
 */
@Repository
public interface CountryRepository extends CrudRepository<Country, String> {
}
