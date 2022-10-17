package com.oracle.jp.fn.country;

import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author shukawam
 */
public interface CountryRepository extends CrudRepository<Country, String> {

}
