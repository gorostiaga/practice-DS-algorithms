package com.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class TestGeneralReduction {

    public static void main(String[] args) {
        /* Box and collect to list */
        List<Double> doubles = DoubleStream.of(16.2, 8.06, 3.0001, 12, 16.16666)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Doubles in List collection: " + doubles);

        /* Get total salary of all staff */
        double salary = Employee.listOfStaff().stream()
                        .mapToDouble(Employee::getSalary)
                                .sum();
        System.out.println("All Employee salary total is!!!!!!! " + salary);

        /* Get minimum age of all staff */
        OptionalInt minAge = Employee.listOfStaff().stream()
                .mapToInt(Employee::getAge)
                .min();
        System.out.println("Youngest member of staff is!!!!!!!!!!! " + minAge.getAsInt());

        /* Get maximum age of all staff */
        int maxAge = Employee.listOfStaff().stream()
                .map(Employee::getAge)
                .reduce(0, Integer::max);
        System.out.println("Oldest member of staff is " + maxAge);

    }
}
