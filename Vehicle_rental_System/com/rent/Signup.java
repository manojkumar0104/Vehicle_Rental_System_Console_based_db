package com.rent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Signup {
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

    public static void user(){
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
        String adm="user";
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
            System.out.println("\n---User added Succesfully---\n");
        }
        else{
            System.out.println("\nTry again!!!\n");
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}