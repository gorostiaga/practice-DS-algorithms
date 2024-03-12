package com.pruebas;

public class Outer {
    // Static field of the outer class
    private static String staticFieldOuter = "Static Field Outer";

    // Non-static field of the outer class
    private String nonStaticFieldOuter = "Non-Static Field Outer";

    // Static method of the outer class
    public static void staticMethodOuter() {
        System.out.println("Static Method Outer");
    }

    // Non-static method of the outer class
    public void nonStaticMethodOuter() {
        System.out.println("Non-Static Method Outer");
    }

    // Static nested class (Inner class)
    public static class Inner {
        // Static method of the inner class can access static members of the outer class
        public static void accessStaticMembersOuter() {
            System.out.println("Accessing Static Members of Outer from Inner:");
            System.out.println(staticFieldOuter);  // Accessing static field of Outer
            staticMethodOuter();                   // Accessing static method of Outer
            System.out.println("------------------------");
        }

        // Non-static method of the inner class cannot access non-static members of the outer class
        // unless it has an instance of the outer class
        public static void accessNonStaticMembersOuter(Outer outerInstance) {
            System.out.println("Accessing Non-Static Members of Outer from Inner:");
            // System.out.println(nonStaticFieldOuter); // This line would cause a compilation error
            outerInstance.nonStaticMethodOuter();    // Accessing non-static method of Outer using an instance
            System.out.println("------------------------");
        }
    }

    public class NonStaticInner{
        public void test(){
            System.out.println("static = " + staticFieldOuter);
            System.out.println("non-static = " + nonStaticFieldOuter);
        }
    }

    public static void main(String[] args) {
        // Example of accessing static members from Outer and Inner
        Inner.accessStaticMembersOuter();
        Inner.accessNonStaticMembersOuter(new Outer());
        System.out.println("------------------------");
        // Example of accessing non-static members from Outer using an instance in Inner
        Inner innerInstance = new Inner();
        innerInstance.accessNonStaticMembersOuter(new Outer());
    }
}
