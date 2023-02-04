package Advanced.SetsAndMapsLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();
        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String direction = command.split(", ")[0];
            String carNumber = command.split(", ")[1];

            parking.add(carNumber);

            if (direction.equals("OUT")) {
                parking.remove(carNumber);
            }

            command = scanner.nextLine();
        }

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parking.forEach(System.out::println);
        }
    }
}
