package com.company;

/**
 * Created by miku on 2016/05/03.
 */
public class SimpleCalculator {
    public static void main(String args[]){
        if(args.length != 3){
            System.out.println("This calculator requires three arguments");
            System.exit(0);
        }
        int val1 = Integer.parseInt(args[0]);
        int val2 = Integer.parseInt(args[2]);
        String ope = args[1];
        double result = Calculate(val1,val2,ope);
        System.out.println("Answer = " + result);
    }

    public static double Calculate(int val1, int val2, String ope){
        double result = 0;
        if(ope.equals("+")){
            result = val1 + val2;
        }else if(ope.equals("-")){
            result = val1 - val2;
        }else if(ope.equals("\\*")){
            result = val1 * val2;
        }else if(ope.equals("/")){
            result = (double)val1 / (double)val2;
        }
        return result;
    }

}
