package adapter;

import builder.Car;

public class MovableAdapterImpl implements MovableAdapter{
    private Car car;

    public MovableAdapterImpl(Car car) {
        this.car = car;
    }

    @Override
    public String getInfo() {
        return "Brand: " + car.getBrand() + " Name: " + car.getName() + " Color: " + car.getColor() +" Age: " + car.getAge() + " Type: " + car.getCarType() + " Top speed: " + convertMPHtoKMPH(car.getTopSpeed()) +"KPH";
    }

    private int convertMPHtoKMPH(int mph) {
        return (int)(mph * 1.60934);
    }
}
