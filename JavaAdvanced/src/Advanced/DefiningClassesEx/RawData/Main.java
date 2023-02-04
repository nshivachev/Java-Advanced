package Advanced.DefiningClassesEx.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];

            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tires = new ArrayList<>();
            for (int i = 5; i < tokens.length; i += 2) {
                double tirePressure = Double.parseDouble(tokens[i]);
                int tireAge = Integer.parseInt(tokens[i + 1]);
                tires.add(new Tire(tirePressure, tireAge));
            }

            cars.add(new Car(model, engine, cargo, tires));
        }

        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            cars.stream()
                    .filter(c -> c.getCargo().getType().equals("fragile")
                            && c.getTires().stream().anyMatch(t -> t.getPressure() < 1))
                    .forEach(System.out::println);
        } else {
            cars.stream()
                    .filter(c -> c.getCargo().getType().equals("flamable")
                            && c.getEngine().getPower() > 250)
                    .forEach(System.out::println);
        }
    }
}
