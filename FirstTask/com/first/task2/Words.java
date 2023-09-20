package com.first.task2;

import java.util.Scanner;

public class Words {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sequence of words separated by commas: ");
        String input = scanner.nextLine();

        String[] words = input.split(",");

        System.out.println("Modified words:");
        for (String word : words) {
            System.out.println(modifyWord(word.trim()));
        }
        scanner.close();
    }

    private static String modifyWord(String word) {
        if (word.length() <= 1) {
            return word;
        }

        char firstLetter = word.charAt(0);
        StringBuilder modifiedWord = new StringBuilder();
        modifiedWord.append(firstLetter);

        for (int i = 1; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (Character.toLowerCase(currentChar) != Character.toLowerCase(firstLetter)) {
                modifiedWord.append(currentChar);
            }
        }

        return modifiedWord.toString();
    }
}
