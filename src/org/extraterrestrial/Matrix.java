package org.extraterrestrial;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {

        int[][] matrix = {{1,5,2}, {3,6,7}, {4,8,2}};
        System.out.println  ("Zeile: 1\ti: -\tj: -\tMatrix:\t" + Arrays.deepToString(matrix));

        for (int i = 0; i < matrix.length; i++) {
            System.out.println  ("Zeile: 2\ti: " + i + "\tj: -\tMatrix:\t" + Arrays.deepToString(matrix));
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println  ("Zeile: 3\ti: " + i + "\tj: " + j + "\tMatrix:\t" + Arrays.deepToString(matrix));
                matrix[i][j] *= 2;
                System.out.println  ("Zeile: 4\ti: " + i + "\tj: " + j + "\tMatrix:\t" + Arrays.deepToString(matrix));
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nachricht zum verschlüsseln eingeben:");
        String str = scanner.nextLine();
        System.out.println("Die verschlüsselte Nachricht lautet: \"" + encrypt(str) + "\"");
        System.out.println("Nachricht zum entschlüsseln eingeben:");
        str = scanner.nextLine();
        System.out.println("Die entschlüsselte Nachricht lautet: \"" + encrypt(str) + "\"");

    }


    static String encrypt(String message) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i + j * 8 < message.length()) {
                    str.append(message.charAt(i + j * 8));
                }
            }
        }

        return str.toString();
    }
}
