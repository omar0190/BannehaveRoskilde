package com.company.java;

import java.util.*;

public class Parent {
    String dadName;
    String momName;
    String adress;
    int phoneNumber;
    String email;


    Scanner scan = new Scanner(System.in);
    Database database = new Database();

    public void parentInfo() {
        System.out.println("Assign the name of the father: ");
        dadName = scan.nextLine();
        System.out.println("Assign the name of the mother: ");
        momName = scan.nextLine();
        System.out.println("What is the adress of the family?: ");
        adress = scan.nextLine();
        System.out.println("What is the phonenumber of the contactperson?: ");
        int phoneNumber = scan.nextInt();
        System.out.println("What is the email of the contactperson?:");
        String email = scan.nextLine();

        database.createParentData(dadName, momName, adress, phoneNumber, email);

    }


}
