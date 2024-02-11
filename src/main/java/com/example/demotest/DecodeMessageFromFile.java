package com.example.demotest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DecodeMessageFromFile {

    public static void main(String[] args) throws IOException {
        String fileName = "coding_qual_input.txt";
        //String fileName = "test.txt";
        String decodedMessage = decode(fileName);
        System.out.println("Decoded message: " + decodedMessage);
    }

    // Method to decode message from file
    public static String decode(String messageFile) throws IOException {
        var lineKeyValueMap = new HashMap<Integer, String>();
        Files.readAllLines(Path.of(messageFile)).forEach(line -> {
            String[] keyValue = line.split(" ");
            lineKeyValueMap.put(Integer.parseInt(keyValue[0]), keyValue[1]);
        });
        var sortedKeys = lineKeyValueMap.keySet().stream().sorted().toList();
        var pyramid  = createStaircase(sortedKeys);
        var decodedNumbers = pyramid.stream().map(List::getLast).toList();

        return decodedNumbers.stream()
                .map(number -> lineKeyValueMap.get(number))
                .collect(Collectors.joining(" "));
    }

    static List<List<Integer>> createStaircase(List<Integer> numbers) {
        var step=1;
        var subsets = new ArrayList<List<Integer>>();

        var modifiedNumbers = new ArrayList<>(numbers);
        while (!modifiedNumbers.isEmpty()) {
            var subset = new ArrayList<Integer>();
            for (int i = 0; i < step; i++) {
                if (!modifiedNumbers.isEmpty()) {
                    subset.add(modifiedNumbers.remove(0));
                }
            }
            subsets.add(subset);
            step++;
        }
        return subsets;
    }
}
