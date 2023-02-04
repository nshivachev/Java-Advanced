package Advanced.DefiningClassesEx.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private double distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public boolean canCarMoveTheDistance(double distance) {
        return fuelAmount >= calculateTotalFuel(distance);
    }

    public void drive(double distance) {
        fuelAmount -= calculateTotalFuel(distance);
        distanceTraveled += distance;
    }

    public double calculateTotalFuel(double distance) {
        return distance * fuelCostPerKm;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", model, fuelAmount, distanceTraveled);
    }
}
