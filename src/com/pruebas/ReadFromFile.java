package com.pruebas;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromFile {

    public static void main(String[] args) {
        int i;
        FileInputStream fi;
/*        if(args.length !=1){
            System.out.println("Put the fucking file");
            return;
        }*/
        String filePath = "/home/goros/Workspace/java/practice-DS-algorithms/src/com/pruebas/test.txt";
        try{

            fi = new FileInputStream(filePath);

        } catch (IOException e){
            System.out.println("Cannot open the fucking file");
            e.printStackTrace();
            return;
        }

        try{
               do{
                   i = fi.read();
                   if(i != -1) System.out.println((char) i);

               } while (i != -1);
        } catch (IOException e){
            System.out.println("Cannot read the fucking file");

        }
        try {
            fi.close();
        } catch(IOException e) {
            System.out.println("Error Closing File");
        }


    }
}
