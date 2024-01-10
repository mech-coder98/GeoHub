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

import java.util.*;

import com.example.geohub.service.*;
import com.example.geohub.model.Country;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CountryController {

    @Autowired
    private CountryJpaService countryService;

    @GetMapping("/countries")
    public ArrayList<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/countries/{countryId}")
    public Country getCountryById(@PathVariable("countryId") int countryId) {
        return countryService.getCountryById(countryId);
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping("/countries/{countryId}")
    public Country updateCountry(@PathVariable("countryId") int countryId, @RequestBody Country country) {
        return countryService.updateCountry(countryId, country);
    }

    @DeleteMapping("/countries/{countryId}")
    public void deleteCountry(@PathVariable("countryId") int countryId) {
        countryService.deleteCountry(countryId);
    }

}
