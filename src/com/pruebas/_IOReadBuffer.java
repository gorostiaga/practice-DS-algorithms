package com.pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _IOReadBuffer {

    public static void main(String[] args) throws IOException {
        char c;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your fucking characters!!!!");
        System.out.println("Enter q to stop");

/*        while(c != 'q'){
            c = (char) br.read();
        }*/
        //use do while instead of a single while when a variable that
        // is in the condition statement has not been initialized
        // but you will initialized this variable inside the do block
        var i =0;
        do {
            System.out.println("pepe"+ i++);
            int pepe = br.read();
            //c = (char) br.read();   //the execution of the program will halt if there is no character in the buffer, it will wait for more input
            System.out.println("dishendo "+ pepe);

        } while (1 != 'q');

    }
}
