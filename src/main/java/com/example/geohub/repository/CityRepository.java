/*
 *
 * You can use the following import statements
 * 
 * java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.geohub.repository;

import java.util.*;
import com.example.geohub.model.*;

public interface CityRepository {

    ArrayList<City> getAllCities();

    City getCityById(int cityId);

    City addCity(City city);

    City updateCity(int cityId, City city);

    void deleteCity(int cityId);

    Country getCityCountry(int cityId);

}