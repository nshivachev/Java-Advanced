package Advanced.Exam_17_02_23.AutomotiveRepairShop;

public class Vehicle implements Comparable<Vehicle> {
    private String VIN;
    private int mileage;
    private String damage;

    public Vehicle(String VIN, int mileage, String damage) {
        this.VIN = VIN;
        this.mileage = mileage;
        this.damage = damage;
    }

    @Override
    public int compareTo(Vehicle other) {
        return Integer.compare(this.mileage, other.mileage);
    }

    public String getVIN() {
        return VIN;
    }

    @Override
    public String toString() {
        return String.format("Damage: %s, Vehicle: %s (%d km)", damage, VIN, mileage);
    }
}
