package ge.edu.btu.country;

import ge.edu.btu.country.service.CityService;
import ge.edu.btu.country.service.CityServiceSerialization;

import java.util.List;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CityService cityService = new CityServiceSerialization();

        while (true) {
            System.out.println("1. ქალაქის დამატება");
            System.out.println("2. სრული მოსახლეობის ბეჭდვა");
            System.out.println("0. გასვლა");

            String option = scanner.nextLine();
            if (option.equals("0")) {
                break;
            }
            switch (option) {
                case "1" :
                    System.out.println("სახელი:");
                    String name = scanner.nextLine();
                    System.out.println("არის თუ არა დედაქალაქი(true/false)");
                    boolean capital = Boolean.parseBoolean(scanner.nextLine());
                    System.out.println("მოსახლეობის რაოდენობა");
                    long population = Long.parseLong(scanner.nextLine());
                    City city = new City(name, capital, population);
                    cityService.addCity(city);
                    break;
                case "2" :
                    List<City> cities = cityService.getAllCity();
                    long total = 0;
                    for (City c : cities) {
                        total = total + c.getPopulation();
                    }
                    System.out.println("სრული მოსახლეობაა: " + total);
                    break;
                default:
                    System.out.println("არასწორი ოპცია");
            }
        }
    }
}
