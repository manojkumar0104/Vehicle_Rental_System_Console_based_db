package com.rent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
    static Scanner sc = new Scanner(System.in);
    static DB db = new DB();
    static Connection con;

    static {
        try {
            con = DB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void choice() {
        System.out.println("Enter your choice:\n1.Add Vehicle\n2.Remove Vehicle\n3.Add Admin\n");
        while(true){
        int choice = sc.nextInt();
        if (choice == 1) {
            while (true) {
                System.out.println("Select Bike or Car:(1.Bike and 2.Car)");
                int des = sc.nextInt();
                if (des == 1) {
                    bike();
                    break;
                } else if (des == 2) {
                    car();
                    break;
                } else {
                    System.out.println("!- Invalid choice -!");
                }
            }break;
        }else if(choice==2){
            while (true) {
                System.out.println("Select Bike or Car:(1.Bike and 2.Car)");
                int des = sc.nextInt();
                if (des == 1) {
                    removebike();
                    break;
                } else if (des == 2) {
                    removecar();
                    break;
                } else {
                    System.out.println("!- Invalid choice -!");
                }
            }break;
        }else if(choice==3){
            addadmin();
            break;
        }else{
            System.out.println("!- Invalid choice -!");
        }
    }
    }

    public static void bike() {
        sc.nextLine();
        try {
            System.out.println("\nEnter Bike Details :");
            System.out.println("Enter vehicle id:");
            String v_id = sc.nextLine();
            System.out.println("Enter bike id:");
            String b_id = sc.nextLine();
            System.out.println("Enter bike name:");
            String b_name = sc.nextLine();
            System.out.println("Enter bike Model:");
            String b_model = sc.nextLine();
            System.out.println("Enter bike number:");
            String b_no = sc.nextLine();
            System.out.println("Enter bike cost:");
            String b_cost = sc.nextLine();
            String b_sts = "available";
            String sql = "INSERT INTO bike_details(vehicle_id,bike_id,bike_name,bike_model,bike_number,bike_cost,status) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, v_id);
            stmt.setString(2, b_id);
            stmt.setString(3, b_name);
            stmt.setString(4, b_model);
            stmt.setString(5, b_no);
            stmt.setString(6, b_cost);
            stmt.setString(7, b_sts);
            int res = stmt.executeUpdate();
            if (res > 0) {
                System.out.println("\n---Bike added Succesfully---\n");
            } else {
                System.out.println("\nTry again!!!\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void car() {
        try {
            System.out.println("\nEnter car Details :");
            System.out.println("Enter vehicle id:");
            String v_id = sc.nextLine();
            System.out.println("Enter car id:");
            String c_id = sc.nextLine();
            System.out.println("Enter car name:");
            String c_name = sc.nextLine();
            System.out.println("Enter car Model:");
            String c_model = sc.nextLine();
            System.out.println("Enter car number:");
            String c_no = sc.nextLine();
            System.out.println("Enter car cost:");
            String c_cost = sc.nextLine();
            String c_sts = "available";
            String sql = "INSERT INTO car_details(vehicle_id,car_id,car_name,car_model,car_number,car_cost,status) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, v_id);
            stmt.setString(2, c_id);
            stmt.setString(3, c_name);
            stmt.setString(4, c_model);
            stmt.setString(5, c_no);
            stmt.setString(6, c_cost);
            stmt.setString(7, c_sts);
            int res = stmt.executeUpdate();
            if (res > 0) {
                System.out.println("\n---Car added Succesfully---\n");
            } else {
                System.out.println("\nTry again!!!\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void removebike(){
        sc.nextLine();
        try{
            System.out.println("Enter Bike_id to Remove:");
            String b_id=sc.nextLine();
            String sql = "DELETE FROM bike_details WHERE bike_id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, b_id);
            int res=stmt.executeUpdate();
            if (res > 0) {
                System.out.println("\n---Bike removed Succesfully---\n");
            } else {
                System.out.println("\nTry again!!!\n");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void removecar(){
        sc.nextLine();
        try{
            System.out.println("Enter Car_id to Remove:");
            String b_id=sc.nextLine();
            String sql = "DELETE FROM car_details WHERE car_id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, b_id);
            int res=stmt.executeUpdate();
            if (res > 0) {
                System.out.println("\n---Car removed Succesfully---\n");
            } else {
                System.out.println("\nTry again!!!\n");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void addadmin(){
        try{
            System.out.println("Enter details:");
            String u_id="0";
            System.out.println("Enter Name:");
            String u_name=sc.nextLine();
            System.out.println("Enter Phone Number:");
            String ph_no="";
            while(true){
            ph_no=sc.nextLine();
            if(ph_no.length()==10){
            try {
                int ph = Integer.parseInt(ph_no);
                break;
            } catch (NumberFormatException e) {
                System.out.println("!- A Phone number should not contain any string -!");
            }
            }else{
                System.out.println("!- Enter a valid Phone Number of 10 digits -!");
            }
            }
            String pass="";
            while(true){
            System.out.println("Enter Password:");
            pass=sc.nextLine();
            System.out.println("Confirm Password:");
            String cpass=sc.nextLine();
            if(pass.equals(cpass)){
                break;
            }else{
                System.out.println("\n !- Your Password and Confirm Password must be same -! ");
            }
            }
            String adm="admin";
            String sql="INSERT INTO user_details(user_id,user_name,phone_number,password,administrator) VALUES(?,?,?,?,?)";
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setString(1,u_id);
            stmt.setString(2,u_name);
            stmt.setString(3,ph_no);
            stmt.setString(4,pass);
            stmt.setString(5,adm);
            int res=stmt.executeUpdate();  
            if(res>0)
            {
                System.out.println("\n---Admin added Succesfully---\n");
            }
            else{
                System.out.println("\nTry again!!!\n");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
