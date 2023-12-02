package io.github.senpawaii.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Star2 {
    public String solve() throws IOException {
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "1", "2", "3", "4", "5", "6", "7", "8", "9"};


        // Read the input file
        String file ="src/io/github/senpawaii/day1/input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file));

        int calibration = 0;

        // Read until the end of the file
        while (reader.ready()) {
            String firstDigit = "";
            String lastDigit = "";

            String line = reader.readLine();

            for(String digit: digits) {
                int firstIndex = line.indexOf(digit);
                int lastIndex = line.lastIndexOf(digit);

                if (firstIndex == -1) {
                    // If the line doesn't contain the digit
                    continue;
                }

                if (firstDigit.equals("")) {
                    // First occurrence
                    firstDigit = digit;
                    lastDigit = digit;
                } else {
                    if (firstIndex < line.indexOf(firstDigit)) { // If the index is smaller than the first digit's index
                        firstDigit = digit;
                    }
                    if (lastIndex > line.lastIndexOf(lastDigit)) { // If the index is bigger than the last digit's index
                        lastDigit = digit;
                    }
                }
            }

            if (firstDigit.equals("") || lastDigit.equals("")) {
                // If the line doesn't contain any digits
                continue;
            }

            // Convert the first digit and last digit to numbers if they are in words
            if (firstDigit.length() > 1) {
                firstDigit = convertWordToNumber(firstDigit);
            }
            if (lastDigit.length() > 1) {
                lastDigit = convertWordToNumber(lastDigit);
            }

            String lineCalibration = firstDigit + lastDigit;
            calibration += Integer.parseInt(lineCalibration);
        }

        reader.close();
        return String.valueOf(calibration);
    }

    private String convertWordToNumber(String word) {
        return switch (word) {
            case "zero" -> "0";
            case "one" -> "1";
            case "two" -> "2";
            case "three" -> "3";
            case "four" -> "4";
            case "five" -> "5";
            case "six" -> "6";
            case "seven" -> "7";
            case "eight" -> "8";
            case "nine" -> "9";
            default -> "";
        };
    }
}
