package observer;

import java.util.ArrayList;
import java.util.List;

public class CarDealership implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String carUpdate;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(carUpdate);
        }
    }

    public void setCarUpdate(String carUpdate) {
        this.carUpdate = carUpdate;
        notifyObservers();
    }
}
