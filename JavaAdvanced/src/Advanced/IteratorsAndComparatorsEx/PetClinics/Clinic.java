package Advanced.IteratorsAndComparatorsEx.PetClinics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Clinic {
    private String name;
    private int numberOfRooms;
    private static Map<String, Pet> existingPetMap = new HashMap<>();
    private Pet[] petRooms;

    public Clinic(String name, int numberOfRooms) {
        if (numberOfRooms % 2 == 0) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.numberOfRooms = numberOfRooms;
        petRooms = new Pet[numberOfRooms];
    }

    public String getName() {
        return name;
    }

    public Pet getPet(int roomNumber) {
        return petRooms[roomNumber - 1];
    }

    public static Pet getExistingPet(String petName) {
        if (existingPetMap.containsKey(petName)) {
            return existingPetMap.get(petName);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void addExistingPet(Pet pet) {
        existingPetMap.put(pet.getName(), pet);
    }

    public void addPet(String petName) {
        boolean isOperationsSuccessful = false;
        int middleIndex = numberOfRooms / 2;

        if (petRooms[middleIndex] == null) {
            petRooms[middleIndex] = existingPetMap.get(petName);
            isOperationsSuccessful = true;
        } else if (numberOfRooms > 1) {
            for (int i = 1; i <= middleIndex; i++) {
                isOperationsSuccessful = false;

                if (petRooms[middleIndex - i] == null) {
                    petRooms[middleIndex - i] = existingPetMap.get(petName);
                    isOperationsSuccessful = true;
                    break;
                } else if (petRooms[middleIndex + i] == null) {
                    petRooms[middleIndex + i] = existingPetMap.get(petName);
                    isOperationsSuccessful = true;
                    break;
                }
            }
        }

        System.out.println(isOperationsSuccessful);
    }

    public void releasePet() {
        boolean isOperationsSuccessful = false;
        boolean isSecondRound = false;
        int middleIndex = numberOfRooms / 2;

        for (int i = middleIndex; i < numberOfRooms; i++) {
            if (isSecondRound && i == middleIndex) {
                break;
            }

            if (petRooms[i] != null) {
                petRooms[i] = null;
                isOperationsSuccessful = true;
                break;
            }

            if (i == numberOfRooms - 1) {
                i = 0;
                isSecondRound = true;
            }
        }

        System.out.println(isOperationsSuccessful);
    }

    public boolean hasEmptyRooms() {
        for (Pet pet : petRooms) {
            if (pet == null) {
                return true;
            }
        }

        return false;
    }

    public void printRooms() {
        Arrays.stream(petRooms).forEach(room -> {
            if (room == null) {
                System.out.println("Room empty");
            } else {
                System.out.println(room);
            }
        });
    }

    public void printRoom(int roomNumber) {
        Pet pet = getPet(roomNumber);

        if (pet == null) {
            System.out.println("Room empty");
        } else {
            System.out.println(pet);
        }
    }
}
