package com.first.task1;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int numCols = scanner.nextInt();

        int[][] matrix = new int[numRows][numCols];
        System.out.println("Enter the elements of the matrix:");

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.printf("Matrix element [%d][%d]", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] maxPrimeElements = new int[numCols];
        for (int j = 0; j < numCols; j++) {
            maxPrimeElements[j] = findMaxPrimeInColumn(matrix, j);
        }

        System.out.println("Vector with maximum prime elements in each column:");
        for (int element : maxPrimeElements) {
            System.out.println(element);
        }

        scanner.close();
    }

    private static int findMaxPrimeInColumn(int[][] matrix, int col) {
        int maxPrime = Integer.MIN_VALUE;

        for (int[] row : matrix) {
            if (isPrime(row[col]) && row[col] > maxPrime) {
                maxPrime = row[col];
            }
        }

        return maxPrime;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
