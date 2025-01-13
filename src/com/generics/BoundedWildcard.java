package com.generics;

public class BoundedWildcard {
    static void showXY(Coords<?> c) {
        System.out.println("X Y Coordinates:");
        for(int i=0; i < c.coords.length; i++)
            System.out.println(c.coords[i].x + " " +
                    c.coords[i].y);
        System.out.println();
    }
    static void showXYZ(Coords<? extends ThreeD> c) {
        System.out.println("X Y Z Coordinates:");
        for(int i=0; i < c.coords.length; i++)
            System.out.println(c.coords[i].x + " " +
                c.coords[i].y + " " +
                c.coords[i].z);
        System.out.println();
    }

    static void showAll(Coords<? extends FourD> c) {
        System.out.println("X Y Z T Coordinates:");
        for(int i=0; i < c.coords.length; i++)
            System.out.println(c.coords[i].x + " " +
                    c.coords[i].y + " " +
                    c.coords[i].z + " " +
                    c.coords[i].t);
        System.out.println();
    }

    public static void main(String[] args) {
        //you cannot include superclasses
        // FourD[] fourDs = {new TwoD(0, 0), new ThreeD(1,2,3), new FourD(1,2,3,4)};

        // but u can include subclasses 
        TwoD[] twoDs = {new TwoD(1,2), new ThreeD(1,2,3), new FourD(1,2,3,4)};
    }
}
