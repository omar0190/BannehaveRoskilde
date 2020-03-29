package com.company.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();


        do {
            try {
                //opretter en scanner
                Scanner scan = new Scanner(System.in);

                System.out.println("\n|WELCOME TO ROSKILDE BØRNEHAVE| ");
                System.out.println("----------------------------------------------------------");
                System.out.println("|1.Manager login                                         |");
                System.out.println("|2.Teacher login                                         |");
                System.out.println("----------------------------------------------------------");
                System.out.println("|0.Exit menu                                             |");
                System.out.println("----------------------------------------------------------");

                System.out.print("Please type a number to login: ");
                int selectedLogin = scan.nextInt();

                //Manager login
                if (selectedLogin == 1) {
                    menu.managerMenu();
                }

                // Teacher login
                if (selectedLogin == 2) {

                }

                //Exit from the program
                if (selectedLogin == 0) {
                    break;
                }

                if (selectedLogin > 2) {
                    System.out.println("\nPlease choose a optional number between 0-2");
                }


            } catch (InputMismatchException e) {
                System.out.println("The menu only takes integer. Please try again...");
            }


        } while (true);


    }
}
