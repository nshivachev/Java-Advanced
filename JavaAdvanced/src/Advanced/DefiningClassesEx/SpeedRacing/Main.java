package Advanced.DefiningClassesEx.SpeedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> carList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");

            String model = tokens[0];
            double fuelAmount =  Double.parseDouble(tokens[1]);
            double fuelCostPerKm = Double.parseDouble(tokens[2]);

            carList.add(new Car(model, fuelAmount, fuelCostPerKm));
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String model = tokens[1];
            double distance = Double.parseDouble(tokens[2]);

            Car car = carList.stream().filter(c -> c.getModel().equals(model)).findFirst().get();

            if (car.canCarMoveTheDistance(distance)) {
                car.drive(distance);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            input = scanner.nextLine();
        }

        carList.forEach(System.out::println);
    }
}
