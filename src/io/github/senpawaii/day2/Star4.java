package io.github.senpawaii.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Star4 {
    public String solve() throws IOException {
        // Read the input file
        String file = "src/io/github/senpawaii/day2/input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file));

        int total = 0;

        // Read until the end of the file
        while (reader.ready()) {
            String line = reader.readLine();

            // Read the game number
            String game = line.substring(0, line.indexOf(":"));
            int gameID = Integer.parseInt(game.substring(game.indexOf(" ") + 1));

            // Read all game subsets of cubes that were revealed from the bag
            List<String> stringList = Pattern.compile(";")
                    .splitAsStream(line.substring(line.indexOf(":") + 1))
                    .toList();


            int minimumRed = 0;
            int minimumGreen = 0;
            int minimumBlue = 0;

            // Check if each subset of cubes is a valid subset
            for (String string: stringList) {
                // Read the subset of cubes
                List<String> cubes = Pattern.compile(",")
                        .splitAsStream(string)
                        .toList();

                for (String cubeColor: cubes) {
                    // Check if the cube rule is valid for each color
                    int cubeNumber = Integer.parseInt(cubeColor.split(" ")[1]);
                    if (cubeColor.contains("green")) {
                        if (cubeNumber > minimumGreen) {
                            minimumGreen = cubeNumber;
                        }
                    }

                    if (cubeColor.contains("red")) {
                        if (cubeNumber > minimumRed) {
                            minimumRed = cubeNumber;
                        }
                    }
                    if (cubeColor.contains("blue")) {
                        if (cubeNumber > minimumBlue) {
                            minimumBlue = cubeNumber;
                        }
                    }
                }
            }
            int power = minimumBlue * minimumGreen * minimumRed;
            total += power;
        }

        reader.close();
        return String.valueOf(total);
    }
}
