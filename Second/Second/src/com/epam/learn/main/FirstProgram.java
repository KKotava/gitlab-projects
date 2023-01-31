package com.epam.learn.main;

import java.io.IOException;

public class FirstProgram {
    public static void main (String[] args){
//        System.out.println("Hello Java again");
//        System.out.print("42");
//        System.out.println("\nWe are using\t" + 11 + "\tversion now");
        int x;
        try {
            x = System.in.read();
            System.out.println("code = " + x + ";\nx = " + (char)x);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
