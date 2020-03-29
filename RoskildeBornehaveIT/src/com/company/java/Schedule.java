package com.company.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Schedule {
    int teacher_id;
    String time_id;
    String date;
    double startTime;
    double endTime;
    double duration;

    Scanner scan = new Scanner(System.in);
    Database database = new Database();
    Teacher teacher = new Teacher();


    public void createSchedule() {


        try {
            boolean moreShifts = true;

            do {

                System.out.println("Do you want to add a new teacher to the kindergarden(y/n)");
                String registerTeacherInput = scan.next();
                if (registerTeacherInput.equals("y") || registerTeacherInput.equals("Y")) {
                    teacher.registerTeacher();
                }

                System.out.println("\n|List of teachers|");
                database.getTeacherData();
                System.out.print("\nWhich teacher do you want to assign this shift to? (Type id): ");
                teacher_id = scan.nextInt();

                System.out.print("What date (0000-00-00): ");
                date = scan.next();

                System.out.print("What time is the shift starting?: ");
                startTime = scan.nextDouble();

                System.out.print("What time does the shift end?: ");
                endTime = scan.nextDouble();

                //beregner durantion
                duration = endTime - startTime;

                database.createScheduleData(teacher_id, date, startTime, endTime, duration);

                // vi laver en boolsk udtryk while loop, så hvis vi svare n, så stopper loopet
                System.out.print("Do you want to add more shifts?(y/n): ");
                String moreInput = scan.next();
                if (moreInput.equals("n") || moreInput.equals("N")) {
                    moreShifts = false;
                }


            } while (moreShifts);

        } catch (InputMismatchException e) {
            System.out.println("Wrong input. Please try again");
        }

    }

    public void editSchedule(){

        database.getScheduleData();

        System.out.print("\nType the id number you want to edit?: ");
        int inputId = scan.nextInt();

        System.out.print("Which column do you want to edit?: ");
        String columnName = scan.next();

        System.out.print("Type the new data to insert?: ");
        String newData = scan.next();

        database.updateScheduleString(inputId, columnName, newData);

    }

    public void deleteSchedule(){

    }

    public void getSchedule() {
        database.getScheduleData();
    }


}
