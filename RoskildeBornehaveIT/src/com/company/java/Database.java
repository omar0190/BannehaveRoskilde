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


        Connection scheData = null;
        try {
            scheData = DriverManager.getConnection(url, user, password);

            Statement scheState = scheData.createStatement();
//henter schedule tabel
            ResultSet scheResult = scheState.executeQuery("SELECT * FROM Schedule");


            System.out.println("|Shift_id|teacher_id|time_id|");
            while (scheResult.next()){

                System.out.println("|   " + scheResult.getInt(1) + "   | " + scheResult.getInt(2) + "       | " + scheResult.getInt(3) + "      | ");
            }

            ResultSet timeResult = scheState.executeQuery("SELECT * FROM schedule_time");



            System.out.println("\n|time_id|shift_id|date|start|end|duration|");
            while (timeResult.next()){
                System.out.println("| " + timeResult.getInt(1) + " | " + timeResult.getInt(2) + " | " + timeResult.getString(3) + " | " + timeResult.getDouble(4) + " | " + timeResult.getDouble(5) + " | " + timeResult.getDouble(6) + " |");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteScheduleData() {

    }

    public void updateScheduleString(int time_id, String whatToUpdate, String newInput) {

        try {
            Connection myConnectData = DriverManager.getConnection(url, user, password);

            Statement myStatement = myConnectData.createStatement();

            myStatement.executeUpdate("update schedule_time set " + whatToUpdate + " = '" + newInput + "' where time_id = " + time_id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
       /*
        int child_cpr = 0;
        String name;
        double pickupTime = 0;
        int teacher_id = 0;
        int parent_id = 0;
*/

            try {
                //1.Get a conncection to database
                Connection myCon = DriverManager.getConnection(url, user, password);

                //2.Create statement
                Statement myState = myCon.createStatement();

                //3.Execute query for database child table
                myState.executeUpdate("INSERT INTO child(child_cpr, name , pickupTime, teacher_id, parent_id) " +
                        "VALUES(" + child_cpr + ",'" + name + "'," + pickupTime + "," + teacher_id + " ', " + parent_id + ")");
                //4.Execute query for child table
                ResultSet rs = myState.executeQuery("SELECT * from child");


            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        public void createParentData(String dadName, String momName, String adress, int phoneNumber, String email){
            try {
                //1.Get a conncection to database
                Connection myCon = DriverManager.getConnection(url, user, password);

                //2.Create statement
                Statement myState = myCon.createStatement();

                //3.Execute query for database child table
                myState.executeUpdate("INSERT INTO parent(DadName, MomName , adress, phoneNumber, email) " +
                        "VALUES('" + dadName + "','" + momName + "', '" + adress + "' ," + phoneNumber + ", '" + email + "')");
                //4.Execute query for child table
                ResultSet rs = myState.executeQuery("SELECT * from parent");


            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        }


