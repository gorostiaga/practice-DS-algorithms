package com.emuns;

enum Apple {
    Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);
    private int price; // price of each apple
    // Constructor
    Apple(int p) { price = p; }
    int getPrice() { return price; }
}

public class EnumDemo {

    public static void main(String[] args) {

        // sees like this declaration is not needed to instantiate a class of enum
        //Apple ap;

        // Display price of Winesap.
        System.out.println("Winesap costs " +
                Apple.Winesap.getPrice() +
                " cents.\n");
// Display all apples and prices.
        System.out.println("All apple prices:");
        for(Apple a : Apple.values())
            System.out.println(a + " costs " + a.getPrice() +
                    " cents.");
    }
}
