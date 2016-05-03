package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class MagicSquares {
    public static boolean testMagic(String pathName) throws IOException {
        // Open the file
        try {
            File file = new File(pathName);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            boolean isMagic = true;
            int lastSum = -1;
            ArrayList<Integer> col_sum = new ArrayList<Integer>();
            int diagonal_sum1 = 0;
            int diagonal_sum2 = 0;

            // For each line in the file ...
            String line;
            int low_count = 0;
            while ((line = reader.readLine()) != null) {
                // ... sum each row of numbers
                String[] parts = line.split("\t");
                int sum = 0;
                int col = 0;
                int count = 0;
                for (String part : parts) {
                    sum += Integer.parseInt(part);
                    //check the columns
                    try{
                        col = col_sum.get(count);
                    } catch(IndexOutOfBoundsException e){
                        col_sum.add(0);
                    }
                    col_sum.set(count, col + Integer.parseInt(part));
                    // check the diagonal
                    if((count - low_count) == 0){
                        diagonal_sum1 += Integer.parseInt(part);
                    }else if((count + low_count) == (parts.length - 1)){
                        diagonal_sum2 += Integer.parseInt(part);
                    }
                    count++;
                }

                if (lastSum == -1) {
                    // If this is the first row, remember the sum
                    lastSum = sum;
                } else if (lastSum != sum) {
                    // if the sums don't match, it isn't magic, so stop reading
                    isMagic = false;
                    break;
                }
                low_count++;
            }
            for(int col : col_sum){
                if(col!=lastSum){
                    isMagic = false;
                    break;
                }
            }
            if(diagonal_sum1 != lastSum){
                isMagic = false;
            }else if(diagonal_sum2 != lastSum){
                isMagic = false;
            }

            reader.close();
            return isMagic;
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        String[] fileNames = { "Mercury.txt", "Luna.txt" };
        for (String fileName : fileNames) {
            System.out.println(fileName + " is magic? " + testMagic("/Users/miku/Documents/"+ fileName));
        }
    }
}
