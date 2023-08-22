package Advanced.Exam_17_02_23.AutomotiveRepairShop;

import java.util.ArrayList;
import java.util.List;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicles.size() < capacity) {
            vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        return vehicles.removeIf(vehicle -> vehicle.getVIN().equals(vin));
    }

    public int getCount(){
        return vehicles.size();
    }

    public Vehicle getLowestMileage() {
        return vehicles.stream().min(Vehicle::compareTo).orElse(null);
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("Vehicles in the preparatory:").append(System.lineSeparator());
        vehicles.forEach(vehicle -> report.append(vehicle).append(System.lineSeparator()));

        return report.toString();
    }
}
