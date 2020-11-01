package ge.edu.btu.country.service;

import ge.edu.btu.country.City;

import java.util.List;

public interface CityService {

    void addCity(City city);

    List<City> getAllCity();
}
