package com.company.java;

import java.util.*;

public class Child {
    String name;
    int child_cpr;
    double pickupTime;
    int teacher_id;
    int parent_id;
    boolean moreKids = true;

    Scanner scan = new Scanner(System.in);
    Database database = new Database();
    Parent parent = new Parent();

    public void createChild() { // Ikke færdig

        try {
            do {
                System.out.println("|Register child|");

                System.out.print("Write the child name: ");
                name = scan.nextLine();
                System.out.print("Input child social security number: ");
                child_cpr = scan.nextInt();
                System.out.print("When is the child supposed to be picked up?: ");
                pickupTime = scan.nextDouble();
// sætter forældre oplysninger ind i databasen
                parent.parentInfo();

                database.getTeacherData();
                System.out.print("Assign teacher to the child (Input teacherID): ");
                teacher_id = scan.nextInt();

                database.createChildData(child_cpr, name, pickupTime, teacher_id);
                System.out.println("Child registered");
                System.out.println("Do you want to add more kids to the kindergarten (y/n)");
                String moreKidsInput = scan.next();
                if (moreKidsInput.equals("n") || moreKidsInput.equals("N")) {
                    moreKids = false;
                }
            } while (moreKids);
        } catch (Exception e) {
            System.out.println("Wrong input. Please try again");
        }


    }

    public void getChildren() {
        System.out.println("|List of Children|");
        database.getChildData();
    }


    public void editChild() {

        database.getChildData();

        System.out.print("\nType the child_cpr number you want to edit?: ");
        int inputId = scan.nextInt();

        System.out.print("Which column do you want to edit?: ");
        String columnName = scan.next();

        System.out.print("Type the new data to insert?: ");
        String newData = scan.next();

        database.updateChildString(inputId, columnName, newData);
    }

    public void deleteChild() {

        database.getChildData();
        System.out.print("Type the child_cpr you want to delete from the child table: ");
        int deleteChildCpr = scan.nextInt();
        database.deleteChildData(deleteChildCpr);
        getChild();
        }
    public void getChild() {
        database.getChildData();
    }
}


