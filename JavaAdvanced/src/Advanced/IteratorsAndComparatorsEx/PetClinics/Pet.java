package Advanced.IteratorsAndComparatorsEx.PetClinics;

import java.util.HashMap;
import java.util.Map;

public class Pet {
    private String name;
    private int age;
    private String kind;
    private static Map<String, Clinic> existingClinicMap = new HashMap<>();
    private Clinic clinic;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
        ;
    }

    public String getName() {
        return name;
    }

    public static Clinic getExistingClinic(String clinicName) {
        if (existingClinicMap.containsKey(clinicName)) {
            return existingClinicMap.get(clinicName);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void addExistingClinic(Clinic clinic) {
        existingClinicMap.put(clinic.getName(), clinic);
    }

    public void setClinic(String clinicName) {
        clinic = existingClinicMap.get(clinicName);
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", name, age, kind);
    }
}
