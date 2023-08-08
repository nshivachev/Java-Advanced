package Advanced.IteratorsAndComparatorsEx.PetClinics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String tokens[] = scanner.nextLine().split("\\s+");

            if ((tokens[0] + " " + tokens[1]).equals("Create Pet")) {
                String name = tokens[2];
                int age = Integer.parseInt(tokens[3]);
                String kind = tokens[4];

                Pet pet = new Pet(name, age, kind);
                Clinic.addExistingPet(pet);
            } else if ((tokens[0] + " " + tokens[1]).equals("Create Clinic")) {
                String name = tokens[2];
                int rooms = Integer.parseInt(tokens[3]);

                try {
                    Pet.addExistingClinic(new Clinic(name, rooms));
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Operation!");
                }
            } else if (tokens[0].equals("Add")) {
                String petName = tokens[1];
                String clinicName = tokens[2];

                try {
                    Clinic clinic = Pet.getExistingClinic(clinicName);
                    Pet pet = Clinic.getExistingPet(petName);

                    clinic.addPet(petName);
                    pet.setClinic(clinicName);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Operation!");
                }
            } else if (tokens[0].equals("Release")) {
                String clinicName = tokens[1];

                Clinic clinic = Pet.getExistingClinic(clinicName);
                clinic.releasePet();
            } else if (tokens[0].equals("HasEmptyRooms")) {
                String clinicName = tokens[1];

                Clinic clinic = Pet.getExistingClinic(clinicName);
                System.out.println(clinic.hasEmptyRooms());
            } else if (tokens[0].equals("Print") && tokens.length == 2) {
                String clinicName = tokens[1];

                Clinic clinic = Pet.getExistingClinic(clinicName);
                clinic.printRooms();

            } else if (tokens[0].equals("Print") && tokens.length == 3) {
                String clinicName = tokens[1];
                int room = Integer.parseInt(tokens[2]);

                Clinic clinic = Pet.getExistingClinic(clinicName);
                clinic.printRoom(room);
            }
        }
    }
}
