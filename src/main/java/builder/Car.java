package builder;

import adapter.Movable;

public class Car implements Movable {
    private String brand;
    private String name;
    private String color;
    private int age;
    private int topSpeed;
    CarType carType;

    public enum CarType{SEDAN, HATCHBACK, COMBI}

    public Car(String brand, String name, String color, int age, int topSpeed, CarType carType) {
        this.brand = brand;
        this.name = name;
        this.color = color;
        this.age = age;
        this.topSpeed = topSpeed;
        this.carType = carType;
    }

    @Override
    public String getInfo(){
        return "Brand: " + brand + " Name: " + name + " Color: " + color +" Age: " + age + " Type: " +carType + " Top speed: " + topSpeed + "MPH";
    }


    public static CarType getCarTypeByInt(int index){
        if (index == 1){
            return CarType.SEDAN;
        }
        if (index == 2){
            return CarType.HATCHBACK;
        }
        if (index == 3){
            return CarType.COMBI;
        }
        else return CarType.SEDAN;
    }

    public static class CarBuilder {
        private String brand;
        private String name;
        private String color;
        private int age;
        private int topSpeed;
        private CarType carType;

        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public CarBuilder setTopSpeed(int topSpeed){
            this.topSpeed = topSpeed;
            return this;
        }

        public CarBuilder setCarType(CarType carType) {
            this.carType = carType;
            return this;
        }

        public Car build() {
            return new Car(brand, name, color, age, topSpeed, carType);
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}


