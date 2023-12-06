package com.pruebas;

public interface InterClass {

    void pepeLucho();

    default void defaultMethod() {
        System.out.println("Default implementation in MyInterface");
    }
}
