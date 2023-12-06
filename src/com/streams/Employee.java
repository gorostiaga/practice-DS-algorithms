package com.streams;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Employee class for testing our streams */
public class Employee {

    public enum Sex {
        MALE, FEMALE, NON_BINARY
    }

    private final String name;
    private final Sex gender;
    private final LocalDate dateOfBirth;
    private final double salary;
    private final List<String> roles;

    // Constructor
    public Employee(String name, Sex gender, LocalDate dateOfBirth, double salary, List<String> roles) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.roles = roles;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Sex getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public List<String> getRoles() {
        return roles;
    }

    // Other methods
    public int getAge() {
        return dateOfBirth
                .until(IsoChronology.INSTANCE.dateNow())
                .getYears();
    }

    public static List<Employee> listOfStaff() {

        List<Employee> staff = new ArrayList<>();
        staff.add(new Employee("Jack", Employee.Sex.MALE,
                IsoChronology.INSTANCE.date(1954, 12, 2), 49999.00,
                new ArrayList<>(Arrays.asList("Manager", "Director"))));
        staff.add(new Employee("Jill", Employee.Sex.FEMALE,
                IsoChronology.INSTANCE.date(1995, 10, 25), 24999.00,
                new ArrayList<>(Arrays.asList("Secretary", "Manager", "Personnel"))));
        staff.add(new Employee("Dorothy", Employee.Sex.FEMALE,
                IsoChronology.INSTANCE.date(1972, 4, 7), 21999.00,
                new ArrayList<>(Arrays.asList("Secretary", "Receptionist"))));
        staff.add(new Employee("Bert", Employee.Sex.MALE,
                IsoChronology.INSTANCE.date(1968, 11, 5), 21999.00,
                new ArrayList<>(Arrays.asList("Clerk", "Receptionist"))));
        staff.add(new Employee("Mary", Employee.Sex.FEMALE,
                IsoChronology.INSTANCE.date(2001, 3, 3), 16999.00,
                new ArrayList<>(Arrays.asList("Trainee", "Receptionist"))));
        staff.add(new Employee("Derek", Employee.Sex.NON_BINARY,
                IsoChronology.INSTANCE.date(1987, 7, 17), 32499.00,
                new ArrayList<>(Arrays.asList("Manager", "Sales"))));
        staff.add(new Employee("Jane", Employee.Sex.FEMALE,
                IsoChronology.INSTANCE.date(1960, 12, 3), 56999.00,
                new ArrayList<>(Arrays.asList("Director", "Accountant"))));
        staff.add(new Employee("Matthew", Employee.Sex.MALE,
                IsoChronology.INSTANCE.date(2002, 4, 7), 12999.00,
                new ArrayList<>(Arrays.asList("Personnel", "Receptionist"))));

        return staff;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", salary=" + salary +
                ", roles=" + roles +
                '}';
    }
}