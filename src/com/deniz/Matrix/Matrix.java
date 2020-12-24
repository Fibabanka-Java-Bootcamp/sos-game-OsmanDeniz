package com.deniz.Matrix;


import com.deniz.Message.Message;

public class Matrix {

    private String[][] sosMatrix;
    private int matrixSize;
    private final Message message = new Message();


    public Matrix(int size) {
        setMatrixSize(size);
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
        message.print("  ");
        for (int i = 1; i <= matrixSize; i++) {
            message.print(" " + i);
        }
        message.empty();
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (j == 0) message.print(i + 1 + " ");
                message.print(" " + sosMatrix[i][j]);
            }
            message.empty();
        }
    }

    public void fillMatrix(int row, int column, String ch) {
        if (isValid(matrixSize, row, column)) {
            if (checkCell(row, column))
                sosMatrix[row][column] = ch;

        }
    }

    public boolean checkCell(int row, int col) {
        return (sosMatrix[row][col]).equals("-");
    }

    public boolean isValid(int size, int row, int column) {
        return (row >= 0 && row <= size) && (column >= 0 && column <= size);
    }

}
