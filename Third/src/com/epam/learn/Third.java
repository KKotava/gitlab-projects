package com.epam.learn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Third {
    public static void main (String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
//        String input = scan.next();
//        String input2 = scan.next();
//        System.out.printf("hello %s %s \n", input, input2);
//
//        Scanner scan1 = new Scanner(System.in);
//        int number = scan.nextInt();
//        System.out.println("goodbye " + number);

//
//        Scanner scanner = new Scanner(System.in);
//        int seconds = scanner.nextInt();
//
//        int hours = ( seconds / 3600 ) % 24;
//        int minutes = ( seconds / 60 ) % 60;
//        int secondsOutput = seconds % 60;
//
//        System.out.printf(hours + ":%02d:%02d", minutes, secondsOutput);
        Scanner scanner = new Scanner(System.in);
//        scanner.useDelimiter(System.lineSeparator());
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int amount = Integer.parseInt(reader.readLine());
        int amount = Integer.parseInt(scanner.nextLine());


        if (amount == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else if (amount < 0) {
            System.out.println("Seriously? Why so negative?");
        } else {
            String[] names = new String[amount];
            for (int i = 0; i < amount; i++) {
//                names[i] = System.console().readLine();
                names[i] = scanner.nextLine();
            }
            for (int j = 0; j < names.length; j++) {
                System.out.println("Hello, " + names[j]);

//            for (int i = 0; i < amount; i++) {
//                String name = scanner.next();
//                System.out.println("Hello, " + name);
            }
        }
    }
}

