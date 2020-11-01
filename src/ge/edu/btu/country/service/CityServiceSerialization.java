package ge.edu.btu.country.service;

import ge.edu.btu.country.City;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CityServiceSerialization implements CityService {

    private static final String DIRECTORY_NAME = "db1";

    @Override
    public void addCity(City city) {
        String path = DIRECTORY_NAME + "/" + city.getName() + ".txt";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(city);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<City> getAllCity() {
        List<City> cities = new ArrayList<>();
        File directory = new File(DIRECTORY_NAME);
        for (File file : directory.listFiles()) {
            String path = DIRECTORY_NAME + "/" + file.getName();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
                City city = (City) in.readObject();
                cities.add(city);
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return cities;
    }
}
