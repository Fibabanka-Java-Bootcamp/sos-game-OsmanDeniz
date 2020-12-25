package com.deniz.Game;

import com.deniz.Matrix.Matrix;
import com.deniz.Message.Message;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private final Message message = new Message();
    private String gamer;
    private String computerCharacter;
    private String userCharacter;
    private int gameCount = 0;
    private int userPoint = 0;
    private int computerPoint = 0;


    public Game() {
        selectGamer();
        assignCharacters();
    }

    public String getGamer() {
        return gamer;
    }

    public void setGamer(String gamer) {
        this.gamer = gamer;
    }

    public int getUserPoint() {
        return userPoint;
    }

    public int getComputerPoint() {
        return computerPoint;
    }

    public String getComputerCharacter() {
        return computerCharacter;
    }

    public void setComputerCharacter(String computerCharacter) {
        this.computerCharacter = computerCharacter;
    }

    public String getUserCharacter() {
        return userCharacter;
    }

    public void setUserCharacter(String userCharacter) {
        this.userCharacter = userCharacter;
    }

    public int getGameCount() {
        return gameCount;
    }

    public int changeGameCount() {
        return gameCount++;
    }

    public int sayHelloAndSetSize() {
        int size;

        message.println("Kucuklugumuzun oyunu sos basliyor.");
        message.println("Hazirsaniz kemerlerinizi baglayin ve ucusa hazir olun");

        do {
            message.print("Kare boyutu ne olsun ? ( 3-7 ) :");
            size = scanner.nextInt();

        } while (size < 3 || size > 7);
        return size;
    }

    public void selectGamer() {

        int rnd = random.nextInt(1000);
        if (rnd % 2 == 0)
            setGamer("User");
        else
            setGamer("Computer");
    }

    public void assignCharacters() {
        int rnd = random.nextInt(1000);

        if (rnd % 2 == 0) {
            setUserCharacter("S");
            setComputerCharacter("O");
        } else {
            setUserCharacter("O");
            setComputerCharacter("S");
        }
    }

    public int getUserInput() {
        return scanner.nextInt();
    }

    public int assignComputerValue(int value) {
        return random.nextInt(value);
    }

    // Bu kisim eklenecek
    public void checkSOS(Matrix matrix, int row, int col, String ch, String gamer) {
        int size = matrix.getMatrixSize();

        if (ch == "S") {
            if (row - 2 >= 0) { //yukari dogru
                if ((matrix.getMatrixCell(row, col) + matrix.getMatrixCell(row - 1, col) + matrix.getMatrixCell(row - 2, col)).equals("SOS")) {
                    if (gamer == "User") userPoint++;
                    else computerPoint++;
                }
                if (col - 2 >= 0) {
                    if ((matrix.getMatrixCell(row, col) + matrix.getMatrixCell(row - 1, col - 1) + matrix.getMatrixCell(row - 2, col - 2)).equals("SOS")) {
                        if (gamer == "User") userPoint++;
                        else computerPoint++;
                    }
                }
                if (col + 2 < size) {
                    if ((matrix.getMatrixCell(row, col) + matrix.getMatrixCell(row - 1, col + 1) + matrix.getMatrixCell(row - 2, col + 2)).equals("SOS")) {
                        if (gamer == "User") userPoint++;
                        else computerPoint++;
                    }
                }
            }
            if (row + 2 < size) { //asagi dogru
                if ((matrix.getMatrixCell(row, col) + matrix.getMatrixCell(row + 1, col) + matrix.getMatrixCell(row + 2, col)).equals("SOS")) {
                    if (gamer == "User") userPoint++;
                    else computerPoint++;
                }

                if (col - 2 >= 0) {
                    if ((matrix.getMatrixCell(row, col) + matrix.getMatrixCell(row + 1, col - 1) + matrix.getMatrixCell(row + 2, col - 2)).equals("SOS")) {
                        if (gamer == "User") userPoint++;
                        else computerPoint++;
                    }
                }
                if (col + 2 < size) {
                    if ((matrix.getMatrixCell(row, col) + matrix.getMatrixCell(row + 1, col + 1) + matrix.getMatrixCell(row + 2, col + 2)).equals("SOS")) {
                        if (gamer == "User") userPoint++;
                        else computerPoint++;
                    }
                }

            }
            if (col - 2 >= 0) { //sola
                if ((matrix.getMatrixCell(row, col) + matrix.getMatrixCell(row, col - 1) + matrix.getMatrixCell(row, col - 2)).equals("SOS")) {
                    if (gamer == "User") userPoint++;
                    else computerPoint++;
                }
            }
            if (col + 2 < size) { //saga
                if ((matrix.getMatrixCell(row, col) + matrix.getMatrixCell(row, col + 1) + matrix.getMatrixCell(row, col + 2)).equals("SOS")) {
                    if (gamer == "User") userPoint++;
                    else computerPoint++;
                }
            }


        } else {

            if ((row - 1 >= 0) && (row + 1 < size)) {
                if ((matrix.getMatrixCell(row - 1, col) + matrix.getMatrixCell(row, col) + matrix.getMatrixCell(row + 1, col)).equals("SOS")) {
                    if (gamer == "User") userPoint++;
                    else computerPoint++;
                }
                if ((col - 1 >= 0) && (col + 1 < size)) {
                    if ((matrix.getMatrixCell(row - 1, col - 1) + matrix.getMatrixCell(row, col) + matrix.getMatrixCell(row + 1, col + 1)).equals("SOS")) {
                        if (gamer == "User") userPoint++;
                        else computerPoint++;
                    }
                    if ((matrix.getMatrixCell(row + 1, col - 1) + matrix.getMatrixCell(row, col) + matrix.getMatrixCell(row - 1, col + 1)).equals("SOS")) {
                        if (gamer == "User") userPoint++;
                        else computerPoint++;
                    }
                }
            }
            if ((col - 1 >= 0) && (col + 1 < size)) {
                if ((matrix.getMatrixCell(row, col - 1) + matrix.getMatrixCell(row, col) + matrix.getMatrixCell(row, col + 1)).equals("SOS")) {
                    if (gamer == "User") userPoint++;
                    else computerPoint++;
                }
            }
        }
    }
}
