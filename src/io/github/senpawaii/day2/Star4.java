package io.github.senpawaii.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Star4 {
    public String solve() throws IOException {
        String file = "src/io/github/senpawaii/day2/input.txt";

        int total = 0;

        // Read the file and process each line
        List<String> lines = Files.readAllLines(Path.of(file));

        for (String line : lines) {
            // Read all game subsets of cubes that were revealed from the bag
            List<String> stringList = List.of(line.substring(line.indexOf(":") + 1).split(";"));

            Map<String, Integer> minimums = new HashMap<>();
            minimums.put("red", 0);
            minimums.put("green", 0);
            minimums.put("blue", 0);

            for (String string: stringList) {
                // Read the subset of cubes
                List<String> cubes = List.of(string.split(","));

                for (String cubeColor: cubes) {
                    String color = cubeColor.split(" ")[2];
                    int cubeNumber = Integer.parseInt(cubeColor.split(" ")[1]);
                    if (minimums.containsKey(color)) {
                        minimums.put(color, Math.max(minimums.get(color), cubeNumber));
                    }
                }
            }
            int power = minimums.get("blue") * minimums.get("green") * minimums.get("red");
            total += power;
        }

        return String.valueOf(total);
    }
}
