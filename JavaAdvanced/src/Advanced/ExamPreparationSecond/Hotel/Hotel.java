package Advanced.ExamPreparationSecond.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (roster.size() < capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        return roster.removeIf(person -> person.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        return roster.stream()
                .filter(person -> person.getName().equals(name) && person.getHometown().equals(hometown))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append(String.format("The people in the hotel %s are:%n", name));
        roster.forEach(person -> statistics.append(person).append(System.lineSeparator()));

        return statistics.toString();
    }


}
