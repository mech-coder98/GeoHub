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

import org.springframework.stereotype.Service;
import com.example.geohub.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.geohub.model.*;
import java.util.*;

@Service
public class CityJpaService implements CityRepository {

    @Autowired
    private CityJpaRepository cityRepository;

    @Autowired
    private CountryJpaService countryService;

    @Override
    public ArrayList<City> getAllCities() {

        List<City> cityList = cityRepository.findAll();
        ArrayList<City> cities = new ArrayList<>(cityList);
        return cities;
    }

    @Override
    public City getCityById(int cityId) {
        try{
            City city = cityRepository.findById(cityId).get();
            return city;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public City addCity(City city) {
        int countryId = city.getCountry().getCountryId();
        Country addcountry = countryService.getCountryById(countryId);
        city.setCountry(addcountry);

        cityRepository.save(city);
        return city;
        /*try{
            cityRepository.save(city);
            return city;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }*/
        
    }

    @Override
    public City updateCity(int cityId, City city) {

        try {
            City updatedCity = cityRepository.findById(cityId).get();
            if (city.getCountry() != null) {
                int countryId = city.getCountry().getCountryId();
                Country newCountry = countryService.getCountryById(countryId);
                updatedCity.setCountry(newCountry);
            }
            if (city.getCityName() != null) {
                updatedCity.setCityName(city.getCityName());
            }
            if (city.getPopulation() != 0) {
                updatedCity.setPopulation(city.getPopulation());
            }
            if (city.getLatitude() != null) {
                updatedCity.setLatitude(city.getLatitude());
            }
            if (city.getLongitude() != null) {
                updatedCity.setLongitude(city.getLongitude());
            }
            cityRepository.save(updatedCity);
            return updatedCity;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteCity(int cityId) {
        try {
            cityRepository.deleteById(cityId);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Country getCityCountry(int cityId) {
        try {
            City city = cityRepository.findById(cityId).get();
            Country country = city.getCountry();
            return country;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}