package com.company.java;

import java.sql.*;

public class Database {

    String url = "jdbc:mysql://den1.mysql4.gear.host/roskildeit123";
    String user = "roskildeit123";
    String password = "_Roskilde123";

    public void createScheduleData(int teacher_id, String date, double startTime, double endTime, double duration) {

        // til at sætte ind på schedule tabel
        int time_id = 0;
        int shift_id = 0;

        try {
            //1.Get a conncection to database
            Connection myCon = DriverManager.getConnection(url, user, password);

            //2.Create statement
            Statement myState = myCon.createStatement();

            //3.Execute query for database schedule time table
            myState.executeUpdate("INSERT INTO schedule_time(date, start, end, duration) " +
                    "VALUES(" + "'" + date + "'," + startTime + "," + endTime + "," + duration + ")");

            //4.Execute query for schedule_time for get time_id
            ResultSet rs = myState.executeQuery("SELECT * from schedule_time");

            while (rs.next()) {
                time_id = rs.getInt(1);
            }

            //5.insert data to schedule table
            myState.executeUpdate("INSERT INTO schedule(teacher_id, time_id) VALUES(" + teacher_id + ", " + time_id + ")");

            //6.When shift id is created, then put it inside schedule_time table
            ResultSet rs1 = myState.executeQuery("SELECT * from schedule");
            while (rs1.next()) {
                shift_id = rs1.getInt(1);
            }

            //Insert shift id into schedule_time table
            String addId = "update schedule_time set shift_id = "+ shift_id + " where time_id = " + time_id;
            myState.executeUpdate(addId);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getScheduleData() {

    }

    public void deleteScheduleData() {

    }

    public void updateScheduleData() {

    }

    public void registerTeacher(String name, int phoneNumber, String email, int manager_id){
        try {
            //1.Get a conncection to database
            Connection myCon = DriverManager.getConnection(url, user, password);

            //2.Create statement
            Statement myState = myCon.createStatement();

            //3.Execute query for database schedule time table
            myState.executeUpdate("INSERT INTO Teacher(name, phoneNumber, email, manager_id) " +
                    "VALUES(" + "'" + name + "'," + phoneNumber + ", '" + email + "'," + manager_id + ")");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getTeacherData() {
        try {
            //1.Get a conncection to database
            Connection myCon = DriverManager.getConnection(url, user, password);

            //2.Create statement
            Statement myState = myCon.createStatement();

            //3.Execute a query
            ResultSet getTs = myState.executeQuery("SELECT * from teacher");

            //Print
            System.out.println("Teacher_id  |  Name  |  phoneNumber  |  email  |  manger_id");
            while (getTs.next()) {
                System.out.println("| " + getTs.getInt(1) + " | " + getTs.getString(2) + " | " + getTs.getInt(3) + " | " + getTs.getString(4) + " | " + getTs.getInt(5) + " |");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getChildData(){
        try {
            //1.Get a conncection to database
            Connection myCon = DriverManager.getConnection(url, user, password);

            //2.Create statement
            Statement myState = myCon.createStatement();

            //3.Execute a query
            ResultSet getTs = myState.executeQuery("SELECT * from child");

            //Print
            System.out.println(" child_cpr  |  Name  | pickupTime  | teacher_id |  parent_id");
            while (getTs.next()) {
                System.out.println("| " + getTs.getInt(1) + " | " + getTs.getString(2) + " | " + getTs.getInt(3) + " | " + getTs.getString(4) + " | " + getTs.getInt(5) + " |");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void createChildData(int child_cpr, String name, double pickupTime, int teacher_id, int parent_id){


        try {
            //1.Get a conncection to database
            Connection myCon = DriverManager.getConnection(url, user, password);

            //2.Create statement
            Statement myState = myCon.createStatement();

            //3.Execute query for database child table
            myState.executeUpdate("INSERT INTO child(child_cpr, name , pickupTime, teacher_id, parent_id) " +
                    "VALUES(" + child_cpr + ",'" + name + "'," + pickupTime + "," + teacher_id + " ',' " + parent_id + ")");
            //4.Execute query for parent table
            ResultSet rs = myState.executeQuery("SELECT * from parent");

            while(rs.next()){
            parent_id =rs.getInt(1);
            }
            //5.insert data to child table
            myState.executeUpdate("INSERT INTO child(parent_id) VALUES(" + parent_id + ")");

            //6.When parent id is created, then put it inside child_table table
            ResultSet rs1 = myState.executeQuery("SELECT * from child");
            while (rs1.next()) {
                parent_id  = rs1.getInt(1);
            }
            //Insert shift id into schedule_time table
            String addId = "update child set parent_id = "+ parent_id;
            myState.executeUpdate(addId);



        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static void createParentData(int parent_id, String DadName, String MomName, String adress, int phoneNumber, String email){
        String url = "jdbc:mysql://den1.mysql4.gear.host/roskildeit123";
        String user = "roskildeit123";
        String password = "_Roskilde123";
        try {
            //1.Get a conncection to database
            Connection myCon = DriverManager.getConnection(url, user, password);

            //2.Create statement
            Statement myState = myCon.createStatement();

            //3.Execute query for database child table
            myState.executeUpdate("INSERT INTO parent(parent_id, DadName, MomName , Adress, phoneNumber, email) " +
                    "VALUES(" + parent_id + ",' " + DadName + ",'" + MomName + "'," + adress + "," + phoneNumber + " '," + email + ")");
            //4.Execute query for child table
            ResultSet rs = myState.executeQuery("SELECT * from parent");


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Wrong input try again");
        }


    }

}

