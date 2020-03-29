package com.company.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teacher {

    String name;
    int phoneNumber;
    String email;
    int manager_id;

    Scanner scan = new Scanner(System.in);
    Database database = new Database();


    public void registerTeacher(){

        try{
            System.out.print("Type the teacher name: ");
            name = scan.nextLine();

            System.out.print("Type phone number: ");
            phoneNumber = scan.nextInt();

            System.out.print("Type email: ");
            email = scan.next();

            // automatisk sætter vi manager = 1, da vi kun har en manager
            manager_id = 1;

            //indsæt værdierne i databasen
            database.registerTeacher(name, phoneNumber, email, manager_id = 1);

            System.out.println("Teacher registered");

            System.out.println("");

        }catch (InputMismatchException e){
            System.out.println("Please try again");
        }


    }

}
