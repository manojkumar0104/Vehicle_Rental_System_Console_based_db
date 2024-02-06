package com.rent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class User {
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
    public static void choice(){
        System.out.println("Enter your choice : \n1.Rent a vehicle\n2.Return a Vehicle");
        while(true){
            int choice=sc.nextInt();
            if(choice==1){
                display();
                System.out.println("\n Enter Bike or Car:(1-Bike and 2-Car)");
                int des=sc.nextInt();
                if(des==1){
                    bikerent();
                }
            }
        }
    }
    public static void display(){
        try{
            // String sq = "SELECT COUNT(status) FROM bike_details";
            // PreparedStatement stm=con.prepareStatement(sq);

            String sql = "SELECT * FROM bike_details WHERE status='available'";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = (ResultSetMetaData)rs.getMetaData();
            int col = rsmd.getColumnCount();
            for (int i = 1; i < col; i++) {
                if (i > 1)
                    System.out.print("\t");
                System.out.print(rsmd.getColumnName(i));
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i < col; i++) {
                    if (i > 1)
                        System.out.print("\t");
                    String val = rs.getString(i);
                    System.out.print(val);
                }
                System.out.println();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            String sql = "SELECT * FROM car_details WHERE status='availabe'";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = (ResultSetMetaData)rs.getMetaData();
            int col = rsmd.getColumnCount();
            for (int i = 1; i < col; i++) {
                if (i > 1)
                    System.out.print("\t");
                System.out.print(rsmd.getColumnName(i));
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i < col; i++) {
                    if (i > 1)
                        System.out.print("\t");
                    String val = rs.getString(i);
                    System.out.print(val);
                }
                System.out.println();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void bikerent(){
        sc.nextLine();
        System.out.println("Enter Bike id to rent:");
        String b_id=sc.nextLine();
        
    }
}
