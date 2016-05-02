package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MagicSquares {
    public static boolean testMagic(String pathName) throws IOException {
        // Open the file
        try {
            File file = new File(pathName);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            boolean isMagic = true;
            int lastSum = -1;

            // For each line in the file ...
            String line;
            while ((line = reader.readLine()) != null) {
                // ... sum each row of numbers
                String[] parts = line.split("\t");
                int sum = 0;
                for (String part : parts) {
                    sum += Integer.parseInt(part);
                }

                if (lastSum == -1) {
                    // If this is the first row, remember the sum
                    lastSum = sum;
                } else if (lastSum != sum) {
                    // if the sums don't match, it isn't magic, so stop reading
                    isMagic = false;
                    break;
                }
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
