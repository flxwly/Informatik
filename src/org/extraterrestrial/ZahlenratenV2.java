package org.extraterrestrial;

import java.util.Random;
import java.util.Scanner;

public class ZahlenratenV2 {

    public static int ki(int min, int max) {
        System.out.println("Der Computer tippt \"" + (min + max) / 2 + "\"");
        return (min + max) / 2;
    }

    public static int human() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Du bist am Zug! Tippe eine Nummer:");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        int guess = 0;

        int min = 0;
        int max = 100;

        boolean humansTurn = true;
        while (true) {
            if (humansTurn) {
                guess = human();
            } else {
                guess = ki(min, max);
            }

            if (guess < number) {
                System.out.println("Die Zahl \"" + guess + "\" ist kleiner als die Zufallszahl!");
                min = Math.max(min, guess);
            } else if (guess > number) {
                System.out.println("Die Zahl \"" + guess + "\" ist größer als die Zufallszahl!");
                max = Math.min(max, guess);
            } else {
                System.out.println("Die Zahl war \"" + number + "\"");
                System.out.println(humansTurn ? "Woow, du hast gewonnen!" : "Der Computer war schneller als du :/");
                break;
            }

            humansTurn = !humansTurn;
        }



    }
}
