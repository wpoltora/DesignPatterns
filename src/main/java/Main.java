import Template.AppAuthenticator;
import adapter.MovableAdapterImpl;
import builder.Car;
import observer.CarDealership;
import observer.DealershipWorker;
import observer.Subscriber;
import singleton.DataHolder;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean convertUnits = false;

        //Observer
        CarDealership carDealership = new CarDealership();
        Subscriber subscriber = new Subscriber();
        DealershipWorker dealershipWorker = new DealershipWorker();
        carDealership.registerObserver(subscriber);
        carDealership.registerObserver(dealershipWorker);


        /**(correct username and password is admin admin)*/
        //Template
        AppAuthenticator appAuthenticator = new AppAuthenticator();
        while (!appAuthenticator.isAuthenticated()){
            String username, password;
            System.out.println("Input username");
            username = scanner.nextLine();
            System.out.println("Input password");
            password = scanner.nextLine();
            appAuthenticator.authenticate(username, password);
        }

        while(true){
            String line;
            System.out.println("1.Show list of cars");
            System.out.println("2.Add car to list");
            System.out.println("3.Change displayed top speed unit (KPH/MPH)");
            System.out.println("0.Close");
            line = scanner.nextLine();
            switch (line){
                case("1"):
                    //Singleton
                    List<Car> cars = DataHolder.getInstance().getList();
                    if(!convertUnits) {
                        cars.stream().forEach(car -> System.out.println(car.getInfo()));
                    }
                    else{
                        cars.stream().forEach(car -> {
                            //Adapter
                            MovableAdapterImpl carAdapter = new MovableAdapterImpl(car);
                            System.out.println(carAdapter.getInfo());
                        });
                    }
                    break;
                case("2"):
                    System.out.println("Input brand");
                    String brand = scanner.nextLine();
                    System.out.println("Input name");
                    String name = scanner.nextLine();
                    System.out.println("Input age");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.println("Input top speed in MPH");
                    int topSpeed = Integer.parseInt(scanner.nextLine());
                    System.out.println("Select Car type: 1.SEDAN, 2. HATCHBACK, 3. COMBI");
                    Car.CarType carType = Car.getCarTypeByInt(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Input color");
                    String color = scanner.nextLine();

                    //Builder
                    Car newCar = new Car.CarBuilder()
                            .setBrand(brand)
                            .setName(name)
                            .setAge(age)
                            .setTopSpeed(topSpeed)
                            .setCarType(carType)
                            .setColor(color)
                            .build();
                    //Singleton
                    DataHolder.getInstance().getList().add(newCar);

                    //Observer
                    carDealership.setCarUpdate(newCar.getInfo());
                    break;
                case("3"):
                    //Adapter
                    convertUnits = !convertUnits;
                    break;
                case("0"):
                    return;
            }
        }
    }
}
