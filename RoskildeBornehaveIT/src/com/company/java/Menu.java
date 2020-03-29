package com.company.java;

import java.util.Scanner;

public class Menu {

    Scanner scan = new Scanner(System.in);
    Schedule schedule = new Schedule();


    public void managerMenu() {


        while (true) {

            System.out.println("\n|ROSKILDE BØRNEHAVE| ");
            System.out.println("----------------------------------------------------------");
            System.out.println("|1.Register a child                                      |");
            System.out.println("|2.Edit child information                                |");
            System.out.println("|3.Delete child                                          |");
            System.out.println("|4.See child list                                        |");
            System.out.println("|5.Create new shift for schedule                         |");
            System.out.println("|6.Edit schedule                                         |");
            System.out.println("|7.Delete shift                                          |");
            System.out.println("|8.See schedule                                          |");
            System.out.println("----------------------------------------------------------");
            System.out.println("|0.Exit menu                                             |");
            System.out.println("----------------------------------------------------------");


            try {
                System.out.print("Please type a number from the menu: ");
                int seletedNum = scan.nextInt();

                //Menu 1
                if (seletedNum == 1) {
                    Child child = new Child();
                    child.createChild();

                }

                //Menu 2
                if (seletedNum == 2) {

                }

                //Menu 3
                if (seletedNum == 3) {

                }

                //Menu 4
                if (seletedNum == 4) {

                }

                //Menu 5
                if (seletedNum == 5) {
                    schedule.createSchedule();
                }

                //Menu 6
                if (seletedNum == 6) {
                    schedule.editSchedule();
                }

                //Menu 7
                if (seletedNum == 7) {

                }

                //menu 8
                if (seletedNum == 8) {
                    schedule.getSchedule();

                }
                //Menu 0
                if (seletedNum == 0) {
                    break;

                }

                if (seletedNum > 8) {
                    System.out.println("\nPlease type a optional number between 0-6.");
                }
            } catch (Exception e) {
                System.out.println("Please type a integer to continue...");
            }


        }


    }


}
