package com.pruebas;

public class Person implements Comparable<Person>{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getDeadYears(){
        return this.age +10 ; 
    }

    @Override
    public int compareTo(Person that) {
        if(this.age > that.age)
            return 1;
        else if (this.age == that.age)
            return 0;
        else
            return -1;

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
