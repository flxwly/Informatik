package org.extraterrestrial.qp12;

import java.util.Arrays;
import java.util.Random;

public class Zufallszahlen {
    public static void main(String[] args) {

        Random random = new Random();

        int[] randomNums = new int[50];
        int num = 0;

        for (int i = 0; i < randomNums.length; i++) {
            do {
                num = random.nextInt(1000);
            } while (contains(randomNums, num));
            randomNums[i] = num;
        }

        System.out.println(Arrays.toString(randomNums));
    }

    public static boolean contains(int[] arr, int n) {
        for (int m :
                arr) {
            if (n == m)
                return true;
        }
        return false;
    }
}
