package com.company;

/**
 * Created by miku on 2016/05/02.
 */
public class Marathon {
    public static void main (String[] arguments) {
        String[] names = {
                "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
                "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
                "Aaron", "Kate"
        };
        int[] times = {
                341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
                343, 317, 265
        };
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + times[i]);
        }
        int best_number = ReturnBestRunnerNumber(times);
        System.out.println("Best runner\n" + names[best_number] + ":" + times[best_number]);
        int second_number = ReturnSecondRunnerNumber(times,best_number);
        System.out.println("Second runner\n" + names[second_number] + ":" + times[second_number]);
    }

    public static int ReturnBestRunnerNumber(int[] times){
        int best_time = times[0];
        int best_number = 0;
        for(int i = 1; i < times.length; i++){
            if(times[i]<best_time){
                best_time = times[i];
                best_number = i;
            }
        }
        return best_number;
    }
    public static int ReturnSecondRunnerNumber(int[] times, int best_number){
        int second_number;
        int second_time;
        if(best_number == 0){
            second_time = times[1];
            second_number = 1;
            for(int i = 2; i < times.length; i++){
                if(times[i]<second_time){
                    second_time = times[i];
                    second_number = i;
                }
            }
        }else{
            second_time = times[0];
            second_number = 0;
            for (int i = 1; i < times.length; i++) {
                if (i != best_number) {
                    if (times[i] < second_time) {
                        second_time = times[i];
                        second_number = i;
                    }
                }
            }
        }
        return second_number;
    }
}
