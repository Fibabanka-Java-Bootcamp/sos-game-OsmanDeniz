package com.deniz.Matrix;

import java.util.Scanner;

public class Matrix {
    private final Scanner scanner = new Scanner(System.in);
    private String[][] sosMatrix;
    private int matrixSize;

    public Matrix() {
        setMatrixSize(sayHelloAndSetSize());
        createMatrix();
        initialMatrix();
    }

    public int getMatrixSize() {
        return matrixSize;
    }

    public void setMatrixSize(int matrixSize) {
        this.matrixSize = matrixSize;
    }

    public String getMatrixCell(int row, int col) {
        return sosMatrix[row][col];
    }

    public int sayHelloAndSetSize() {
        int size;

        System.out.println("Kucuklugumuzun oyunu sos basliyor.");
        System.out.println("Hazirsaniz kemerlerinizi baglayin ve ucusa hazir olun");

        do {
            System.out.printf("Kare boyutu ne olsun ? ( 3-7 ) :");
            size = scanner.nextInt();

        } while (size < 3 || size > 7);
        return size;
    }

    private void createMatrix() {
        sosMatrix = new String[matrixSize][matrixSize];
    }

    private void initialMatrix() {
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                sosMatrix[i][j] = "-";
            }
        }
    }

    public void drawMatrix() {
        int matrixSize = sosMatrix.length;
        System.out.print("  ");
        for (int i = 1; i <= matrixSize; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (j == 0) System.out.print(i + 1 + " ");
                System.out.print(" " + sosMatrix[i][j]);
            }
            System.out.println();
        }
    }

}
