package com.rent;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
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

    public static int login(String user_id,String password){
        try{
        String sql = "SELECT * FROM user_details where user_id = ? and password= ?"; 
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,user_id);
        stmt.setString(2,password);
        ResultSet rs=stmt.executeQuery();
        if(rs.next()){
            String adm = rs.getString("administrator");
            String name = rs.getString("user_name");
            String u_id = rs.getString("user_id");
            System.out.println();
            if(adm.equals("admin")){
                System.out.println("Welcome Admin "+name+"user_id : "+u_id);
                Admin.choice();
            }else{
                System.out.println("Welcome User "+name);
                User.choice();
            }
        }else{
            System.out.println("\n!-Invalid user_id or Password-!");
            System.out.println("!- Login again Or else SigUp as new User -!\n");
            Main.main(null);
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
        return 0;
    }

    public static void adm() {
        System.out.println("Enter Your User id:");
        String user_id = sc.nextLine();
        System.out.println("Enter Password:");
        String password = sc.nextLine();
        login(user_id, password);
    }
}
