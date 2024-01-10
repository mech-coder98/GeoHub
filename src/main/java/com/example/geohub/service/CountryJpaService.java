/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.geohub.service;

import org.springframework.web.server.ResponseStatusException;
import com.example.geohub.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.geohub.repository.*;
import java.util.*;
import com.example.geohub.model.Country;
import org.springframework.http.HttpStatus;

@Service
public class CountryJpaService implements CountryRepository {

    @Autowired
    private CountryJpaRepository countryRepository;

    @Override
    public ArrayList<Country> getAllCountries() {
        List<Country> countriesList = countryRepository.findAll();
        ArrayList<Country> countries = new ArrayList<>(countriesList);
        return countries;
    }

    @Override
    public Country getCountryById(int countryId) {
        try {
            Country country = countryRepository.findById(countryId).get();
            return country;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Country addCountry(Country country) {
        Country newCountry = countryRepository.save(country);
        return newCountry;
    }

    @Override
    public Country updateCountry(int countryId, Country country) {
        try {
            Country updateCountry = countryRepository.findById(countryId).get();
            if (country.getCountryName() != null) {
                updateCountry.setCountryName(country.getCountryName());
            }
            if (country.getCurrency() != null) {
                updateCountry.setCurrency(country.getCurrency());
            }
            if (country.getPopulation() != 0) {
                updateCountry.setPopulation(country.getPopulation());
            }
            if (country.getLatitude() != null) {
                updateCountry.setLatitude(country.getLatitude());
            }
            if (country.getLongitude() != null) {
                updateCountry.setLongitude(country.getLongitude());
            }
            countryRepository.save(updateCountry);
            return updateCountry;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCountry(int countryId) {
        try {
            countryRepository.deleteById(countryId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}
