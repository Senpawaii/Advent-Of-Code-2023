package io.github.senpawaii.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Star3 {
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


            Boolean valid = true;
            // Check if each subset of cubes is a valid subset
            gameLoop:
            for (String string: stringList) {
                // Read the subset of cubes
                List<String> cubes = Pattern.compile(",")
                        .splitAsStream(string)
                        .toList();

                for (String cubeColor: cubes) {
                    // Check if the cube rule is valid for each color
                    if (cubeColor.contains("green") && Integer.parseInt(cubeColor.split(" ")[1]) > 13) {
                        valid = false;
                        break gameLoop;
                    } else if (cubeColor.contains("red") && Integer.parseInt(cubeColor.split(" ")[1]) > 12) {
                        valid = false;
                        break gameLoop;
                    } else if (cubeColor.contains("blue") && Integer.parseInt(cubeColor.split(" ")[1]) > 14) {
                        valid = false;
                        break gameLoop;
                    }
                }
            }

            if (valid) {
                // If the subset is valid, add the game number to the total
                total += gameID;
            }
        }

        reader.close();
        return String.valueOf(total);
    }
}
