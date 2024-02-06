package com.rent;

import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("--- Welcome to Vehicle Rental System ---");
        System.out.println("\n Enter Login or Sign-up ?");
        System.out.println("1.Login");
        System.out.println("2.Sign-up \n");
        while(true){
            int choice=sc.nextInt();
            if(choice==1){
                Login.adm();
                break;
            }
            else if(choice==2){
                Signup.user();
                break;
            }
            else{
                System.out.println("! -Please enter valid option (1 or 2)- !");
            }
        }sc.close();
    }
}