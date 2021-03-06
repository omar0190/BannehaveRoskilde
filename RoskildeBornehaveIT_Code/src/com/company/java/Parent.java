package com.company.java;

import java.sql.*;
import java.util.*;


public class Parent {
    private int parent_id;
    private String DadName;
    private String MomName;
    private String Address;
    private int phoneNumber;
    private String email;
    private int zip;


    Scanner scan = new Scanner(System.in);
    Database database = new Database();


    public void parentInfo() {
        try {


            //System.out.println("Assign parent_id");
            //parent_id = scan.nextInt();
            System.out.print("Assign the name of the father: ");
            DadName = scan.nextLine();
            System.out.print("Assign the name of the mother: ");
            MomName = scan.nextLine();
            System.out.print("What is the address of the family?: ");
            Address = scan.nextLine();
            System.out.print("What is the zip code?: ");
            zip = scan.nextInt();
            System.out.print("What is the phone number of the contact person?: ");
            int phoneNumber = scan.nextInt();
            System.out.print("What is the email of the contact person?:");
            String email = scan.next();

            database.createParentData(DadName, MomName, Address, phoneNumber, zip, email);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Wrong input. Try Again");
        }


    }


    public void getParentData() {
        String url = "jdbc:mysql://den1.mysql4.gear.host/roskildeit123";
        String user = "roskildeit123";
        String password = "_Roskilde123";
        try {
            //1.Get a conncection to database
            Connection myCon = DriverManager.getConnection(url, user, password);

            //2.Create statement
            Statement myState = myCon.createStatement();

            //3.Execute a query
            ResultSet getTs = myState.executeQuery("SELECT * from parent");

            //Print
            System.out.println(" parent_id  |  DadName  | MomName  | phoneNumber |Address |  email");
            while (getTs.next()) {
                System.out.println("| " + getTs.getInt(1) + " | " + getTs.getString(2) + " | " + getTs.getInt(3) + " | " + getTs.getString(4) + " | " + getTs.getInt(5) + " | " + getTs.getInt(6) + " |");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}