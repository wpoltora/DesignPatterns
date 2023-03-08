package observer;

public class DealershipWorker implements Observer {
    private String carUpdate;

    @Override
    public void update(String carUpdate) {
        this.carUpdate = carUpdate;
        System.out.println("Dealership worker recieved info about a new car: " + carUpdate);
    }
}

