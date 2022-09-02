package org.extraterrestrial.qp12;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix {

    static int[] zahlen = {8, 70, 5, 44, 49, 3, 11, 17, 4};


    public static void main(String[] args) {

        int[][] matrix = {{1, 5, 2}, {3, 6, 7}, {4, 8, 2}};
        System.out.println("Zeile: 1\ti: -\tj: -\tMatrix:\t" + Arrays.deepToString(matrix));

        for (int i = 0; i < matrix.length; i++) {
            System.out.println("Zeile: 2\ti: " + i + "\tj: -\tMatrix:\t" + Arrays.deepToString(matrix));
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("Zeile: 3\ti: " + i + "\tj: " + j + "\tMatrix:\t" + Arrays.deepToString(matrix));
                matrix[i][j] *= 2;
                System.out.println("Zeile: 4\ti: " + i + "\tj: " + j + "\tMatrix:\t" + Arrays.deepToString(matrix));
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nachricht zum verschlüsseln eingeben:");
        String str = scanner.nextLine();
        System.out.println("Die verschlüsselte Nachricht lautet: \"" + encrypt(str) + "\"");
        System.out.println("Nachricht zum entschlüsseln eingeben:");
        str = scanner.nextLine();
        System.out.println("Die entschlüsselte Nachricht lautet: \"" + encrypt(str) + "\"");


        boolean arr[][] =
                {{true, false, true, false, true, false},
                        {false, false, false, false, true, false},
                        {true, false, false, true, false, false},
                        {true, false, false, true, false, false},
                        {false, true, true, true, true, false},
                        {true, true, true, true, true, false}};

        for (int i = 0; i < 5; i++) {
            boolean parity = false;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j]) {
                    parity = !parity;
                }
            }
            arr[i][5] = parity;
        }

        for (int i = 0; i < 5; i++) {
            boolean parity = false;
            for (int j = 0; j < 5; j++) {
                if (arr[j][i]) {
                    parity = !parity;
                }
            }
            arr[5][i] = parity;
        }

        printParityMatrix(arr);

    }

    static public void printParityMatrix(boolean[][] matrix) {
        for (boolean[] booleans : matrix) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    System.out.print(" 1 ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }
    }

    static boolean pruefen(int[] zahlen, int a) {
        for (int n :
                zahlen) {
            if (a == n) {
                return true;
            }
        }
        return false;
    }

    static boolean pruefen(int a) {
        for (int i = 0; i < zahlen.length; i++) {
            if (a == zahlen[i]) {
                return true;
            }
        }
        return false;
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
