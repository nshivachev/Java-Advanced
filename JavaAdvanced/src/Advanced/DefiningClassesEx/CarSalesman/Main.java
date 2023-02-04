package Advanced.DefiningClassesEx.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int engineNumber = Integer.parseInt(scanner.nextLine());

        List<Engine> engineList = new ArrayList<>();

        while (engineNumber-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            String power = tokens[1];
            String displacement = null;
            String efficiency = null;

            switch (tokens.length) {
                case 4:
                    displacement = tokens[2];
                    efficiency = tokens[3];
                    break;
                case 3:
                    if (tokens[2].matches("\\d+")) {
                        displacement = tokens[2];
                        efficiency = "n/a";
                    } else {
                        efficiency = tokens[2];
                        displacement = "n/a";
                    }
                    break;
                case 2:
                    displacement = "n/a";
                    efficiency = "n/a";
                    break;
                default:
                    break;
            }

            engineList.add(new Engine(model, power, displacement, efficiency));
        }

        int carNumber = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        while (carNumber-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String mode = tokens[0];
            String engine = tokens[1];
            String weight = null;
            String color = null;

            switch (tokens.length) {
                case 4:
                    weight = tokens[2];
                    color = tokens[3];
                    break;
                case 3:
                    if (tokens[2].matches("\\d+")) {
                        weight = tokens[2];
                        color = "n/a";
                    } else {
                        color = tokens[2];
                        weight = "n/a";
                    }
                    break;
                case 2:
                    weight = "n/a";
                    color = "n/a";
                    break;
            }

            carList.add(new Car(mode, engineList.stream().filter(e -> e.getModel().equals(engine)).findFirst().get(), weight, color));
        }

        carList.forEach(System.out::println);
    }
}
