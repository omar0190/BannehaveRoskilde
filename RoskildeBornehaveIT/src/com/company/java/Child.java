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

    public void createChild(){ // Ikke færdig

        try {
            do {
                database.getChildData();
                System.out.println("Write the child name: ");
                name = scan.nextLine();
                System.out.println("Input child social security number: ");
                child_cpr = scan.nextInt();
                System.out.println("When is the child supposed to be picked up?: ");
                pickupTime = scan.nextDouble();
                System.out.println("Assign teacher to the child. Input teacherID: ");
                teacher_id = scan.nextInt();
                database.getTeacherData();
                //print liste a lærer, så man kan vælge en lærer
                System.out.println("Assign parents to the child. Input parentID: ");
                parent_id = scan.nextInt();
                //Du skal først oprette parent, hvor du indsætter oplysninger i parent table, hvor du efterfølgende bruger

                database.createChildData(child_cpr, name, pickupTime, teacher_id, parent_id);

                System.out.println("Do you want to add more kids to the kindergarten (y/n)");
                String moreKidsInput = scan.next();
                if(moreKidsInput.equals("n") || moreKidsInput.equals("N")){
                    moreKids = false;
                }
            } while(moreKids);
        }
        catch (Exception e){
            System.out.println("Wrong input. Please try again");
        }




    }
    public void editChild(){ // Ikke færdig
        System.out.println("Do you want to edit a child (y/n)");
        database.getChildData();
        System.out.println("Input the ID of the child you want to edit");



    }

    /*
    public void deleteChild(){ // Ikke færdig
        int child_cpr = scan.nextInt();
        System.out.println("Do you want to delete a child from list?(y/n): ");
        database.getChildData();

        System.out.println("Input social security number of the child you want to delete from the list");
        Statement stmt = con.createStatement();

        String query = "Delete from student where cpr= ' " + child_cpr + " ' ";
        int result = stmt.executeUpdate(query);
        if (result == 0){
            System.out.println("Record not found to delete");
        } else{
            System.out.println(result +"no. of record(s) found and deleted");
        }

*/




    }


