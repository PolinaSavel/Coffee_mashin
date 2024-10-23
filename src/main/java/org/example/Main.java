package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine(600, 300, 200); // Nachalnie resursi

        while (true) {
            System.out.println("Select coffee type (espresso, latte, cappuccino, mode) or type 'exit' to quit:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("status")) {    // status resursov
                coffeeMachine.displayResources();
            } else if (input.equalsIgnoreCase("refill")) {    // dobavit' resurs
                System.out.println("Enter water, milk and coffee beans to refill (space-separated):");
                String[] refillInput = scanner.nextLine().split(" ");  //smotrim chto dobavili
                if (refillInput.length == 3) {           // esli popolnili 3 ingridienta
                    int water = Integer.parseInt(refillInput[0]);      //dobavili воду
                    int milk = Integer.parseInt(refillInput[1]);       // dobavili moloka
                    int coffeeBeans = Integer.parseInt(refillInput[2]);     //dobavili coffee
                    coffeeMachine.refill(water, milk, coffeeBeans);     //pereschet ostatkov resursov
                } else {
                    System.out.println("Invalid input. Please enter three numbers.");
                }
            } else {
                coffeeMachine.makeCoffee(input);
            }
        }
        scanner.close();
        System.out.println("Thank you for using the coffee machine!");
    }
}