/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.geohub.controller;

import com.example.geohub.model.*;
import com.example.geohub.service.CityJpaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.example.geohub.repository.*;

@RestController
public class CityController {

    @Autowired
    private CityJpaService cityService;

    @GetMapping("/countries/cities")
    public ArrayList<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/countries/cities/{cityId}")
    public City getCityById(@PathVariable("cityId") int cityId) {
        return cityService.getCityById(cityId);
    }

    @PostMapping("/countries/cities")
    public City addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }

    @PutMapping("/countries/cities/{cityId}")
    public City updateCity(@PathVariable("cityId") int cityId, @RequestBody City city) {
        return cityService.updateCity(cityId, city);
    }

    @DeleteMapping("/countries/cities/{cityId}")
    public void deleteCity(@PathVariable("cityId") int cityId) {
        cityService.deleteCity(cityId);
    }

    @GetMapping("/cities/{cityId}/country")
    public Country getCityCountry(@PathVariable("cityId") int cityId) {
        return cityService.getCityCountry(cityId);
    }

}
