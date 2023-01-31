package org.example;

import java.util.Scanner;

public class GoDutch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int friends = scanner.nextInt();
        if (sum < 0) {
            System.out.println("Bill total amount cannot be negative");
        } else if (friends <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else {
            int finalSum = (sum + ((sum * 10) / 100));
            System.out.println(finalSum / friends);
        }
    scanner.close();
    }
}