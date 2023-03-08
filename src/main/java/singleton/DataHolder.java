package singleton;

import builder.Car;

import java.util.ArrayList;

public class DataHolder {
    private ArrayList<Car> cars = new ArrayList<>();
    private static DataHolder instance = null;

    // Private constructor to prevent instantiation from outside the class
    private DataHolder() {
        //Builder
       cars.add(new Car.CarBuilder()
               .setBrand("Skoda")
               .setName("Fabia")
               .setAge(20)
               .setTopSpeed(120)
               .setCarType(Car.CarType.COMBI)
               .setColor("Red")
               .build());
        cars.add(new Car.CarBuilder()
                .setBrand("Skoda")
                .setName("Octavia")
                .setAge(12)
                .setCarType(Car.CarType.SEDAN)
                .setTopSpeed(110)
                .setColor("Blue")
                .build());
    }

    // Public static method to get the singleton instance
    public static DataHolder getInstance() {
        if (instance == null) {
            instance = new DataHolder();
        }
        return instance;
    }

    // Public instance method
    public ArrayList<Car> getList(){
        return cars;
    }


}