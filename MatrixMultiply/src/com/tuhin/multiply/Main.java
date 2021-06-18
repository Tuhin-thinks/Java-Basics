package com.tuhin.multiply;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    void print_matrix(int[][] matrix){
        for (int[] elements : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(elements[j] + "\t");
            }
            System.out.println();
        }
    }

    int[][] accept_elements(int[][] matrix, int rows, int columns){
        int elem;
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                System.out.print("mat[" + i + "][" + j + "] = ");
                elem = sc.nextInt();
                matrix[i][j] = elem;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        int rows, columns;
        System.out.print("Enter number of rows in the matrix:");
        rows = sc.nextInt();

        System.out.print("Enter number of columns in the matrix:");
        columns = sc.nextInt();

        int[][] matrix1 = new int[rows][columns];
        int[][] matrix2 = new int[rows][columns];
        int[][] result = new int[rows][columns];
        System.out.println("Enter elements for first matrix:");
        matrix1 = obj.accept_elements(matrix1, rows, columns);

        System.out.println("Enter elements in another matrix:");
        matrix2 = obj.accept_elements(matrix2, rows, columns);

        System.out.println("First Matrix Entered:");
        obj.print_matrix(matrix1);

        System.out.println("Second Matrix Entered:");
        obj.print_matrix(matrix2);

        int mat_elem1, mat_elem2;
        for (int r=0;r<rows;r++){
            for (int c=0;c<columns;c++){
                mat_elem1 = matrix1[r][c];
                int temp_sum = 0;
                for (int r1=0;r1<rows;r1++){
                    mat_elem2 = matrix2[r1][c];

                    temp_sum += mat_elem1 * mat_elem2;
                }
                result[r][c] = temp_sum;
            }
        }

        System.out.println("Result matrix after multiplication:");
        obj.print_matrix(result);
    }
}
