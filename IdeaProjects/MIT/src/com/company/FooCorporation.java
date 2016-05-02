package com.company;

/**
 * Created by miku on 2016/05/02.
 */
public class FooCorporation {
    public static void main(String args[]){
        System.out.print("Employee 1 : ");
        CalculateSalary(7.50,35);
        System.out.print("Employee 2 : ");
        CalculateSalary(8.20,47);
        System.out.print("Employee 3 : ");
        CalculateSalary(10.00,73);

    }

    public static void CalculateSalary(double base_pay,int hours_worked){
        if(hours_worked>60) {
            System.out.println("Overworked!");
        }else if(base_pay<8.00){
            System.out.println("Base pay is too low!");
        }else{
            int overtime = hours_worked - 40;
            double saraly = base_pay * 40 + base_pay * 1.5 * overtime;
            System.out.println("$" + saraly);
        }

    }
}
