package org.extraterrestrial.qp12.recursion;

public class SumFrame {
    public static void main(String[] args) {
        System.out.println(recursiveFactorial(4));
    }

    public static int recursiveSum(int n) {
        return (n <= 1) ? n : n + recursiveSum(n - 1);
    }

    public static int recursiveFibonacci(int n) {
        return (n <= 1) ? n : recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static int recursiveFactorial(int n) {
        return (n <= 1) ? n : n * recursiveFactorial(n - 1);
    }
}
