package org.extraterrestrial;

import java.util.Arrays;

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


        System.out.println(encrypt("Hallo, mein Name ist Nepomuk!"));


    }


    static String encrypt(String message) {
        char[][] arr = new char[8][8];

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //arr[i][j] = (i * 8 + j < message.length()) ? message.charAt(i * 8 + j) : ' ';
                str.append(i + j * 8 < message.length() ? message.charAt(i + j * 8) : ' ');
            }
        }

        /*for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                str.append(arr[j][i]);
            }
        }*/

        return str.toString();
    }
}
