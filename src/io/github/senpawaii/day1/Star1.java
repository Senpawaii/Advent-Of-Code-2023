package io.github.senpawaii.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Star1 {
    public String solve() throws IOException {
        // Read the input file
        String file ="src/io/github/senpawaii/day1/input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file));

        int calibration = 0;

        // Read until the end of the file
        while (reader.ready()) {
            int firstDigit = -1;
            int lastDigit = -1;

            // Split the line by characters
            String line = reader.readLine();
            char[] chars = line.toCharArray();

            // Get the first and last digits
            for (char aChar : chars) {
                if (Character.isDigit(aChar)) {
                    lastDigit = Character.getNumericValue(aChar);
                    if (firstDigit == -1) {
                        firstDigit = lastDigit;
                    }
                }
            }

            if (firstDigit == -1 || lastDigit == -1) {
                continue;
            }
            int lineCalibration = firstDigit * 10 + lastDigit;
            calibration += lineCalibration;
        }

        reader.close();

        return String.valueOf(calibration);
    }
}
