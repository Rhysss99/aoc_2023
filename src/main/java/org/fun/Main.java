package org.fun;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "input/day_1.txt"; // Path to the input file
        int sum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sum += getCalibrationValue(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Sum of calibration values: " + sum);
    }

    private static int getCalibrationValue(String line) {
       int firstDigit = -1;
       int lastDigit =-1;

       //Find firstDigit
        for (int i = 0; i<line.length();i++) {
            if(Character.isDigit(line.charAt(i))) {
                firstDigit = Character.getNumericValue(line.charAt(i));
                break;
            }
        }
        for (int i = line.length()-1; i>=0;i--) {
            if(Character.isDigit(line.charAt(i))) {
                lastDigit = Character.getNumericValue(line.charAt(i));
                break;
            }
        }
        if (firstDigit != -1 && lastDigit != -1) {
            return firstDigit * 10 + lastDigit;
        }
        return 0;

    }
}