package observer;

public class Subscriber implements Observer {
    private String carUpdate;

    @Override
    public void update(String carUpdate) {
        this.carUpdate = carUpdate;
        System.out.println("Subscriber recieved new car info:  " + carUpdate);
    }
}