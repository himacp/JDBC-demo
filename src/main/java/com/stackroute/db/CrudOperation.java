package com.stackroute.db;

import java.sql.*;

public class CrudOperation {
private Connection con;
    public void displayData() {
        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Student","user","hima");
            //create statement object
            System.out.println("got connected");

            Statement stmt=con.createStatement();


            //execute query
            ResultSet rs=stmt.executeQuery("select * from student");
            //process result
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2));

        }catch(Exception e){ System.out.println(e);}
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayCustomrerByName() {

        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Student","user","hima");
            //create statement object
            System.out.println("got connected");

            PreparedStatement stmt=con.prepareStatement("Select * from student where name = ? and password = ?");
            stmt.setString(1,"hima");
            stmt.setString(2,"abc");
            ResultSet rs = stmt.executeQuery();
            //execute query
          //  ResultSet rs=stmt.executeQuery("select * from customers");
            //process result
            while(rs.next())
                System.out.println("Username: "+rs.getString(1)+"  password: "+rs.getString(2));
            con.close();
        }catch(Exception e){ System.out.println(e);}
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertCustomer(String name, String password) {

        //PreparedStatement
    }
    }
