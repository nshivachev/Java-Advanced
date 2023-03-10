package Advanced.DefiningClassesEx.CatLady;

public class Cat {
    private String breed;
    private String name;
    private double size;

    Cat(String breed, String name, double size) {
        this.breed = breed;
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", breed, name, size);
    }


}
