package com.arjun;

import java.util.HashSet;
import java.util.Optional;

public class FirstRepeatedCharacter {
    public static void main(String[] args) {
        String input = "Hello, World!";
        Optional<Character> firstRepeatedChar = findFirstRepeatedCharacter(input);
        if (firstRepeatedChar.isPresent()) {
            System.out.println("First repeated character: " + firstRepeatedChar.get());
        } else {
            System.out.println("No repeated character found.");
        }
    }

    private static Optional<Character> findFirstRepeatedCharacter(String input) {
        HashSet<Character> uniqueChars = new HashSet<>();

        return input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !uniqueChars.add(c))
                .findFirst();
    }
}

