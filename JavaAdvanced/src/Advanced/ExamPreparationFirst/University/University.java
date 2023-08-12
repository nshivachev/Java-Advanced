package Advanced.ExamPreparationFirst.University;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        String result;

        if (students.size() >= capacity) {
            result = "No seats in the university";
        } else if (students.contains(student)) {
            result = "Student is already in the university";
        } else {
            students.add(student);
            result = String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }

        return result;
    }

    public String dismissStudent(Student student) {
        String result;

        if (students.contains(student)) {
            String studentName = String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
            students.remove(student);
            result = studentName;
        } else {
            result = "Student not found";
        }

        return result;
    }

    public Student getStudent(String firstName, String lastName) {
        return students.stream().filter(student ->
                student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)).findAny().get();
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();

        students.forEach(student ->
                statistics.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s%n",
                        student.getFirstName(), student.getLastName(), student.getBestSubject())));

        return statistics.toString();
    }
}
