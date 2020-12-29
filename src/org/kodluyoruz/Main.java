package org.kodluyoruz;

import com.deniz.Game.Game;
import com.deniz.Matrix.Matrix;
import com.deniz.Message.Message;

import java.util.Scanner;

public class Main {
    private static final Message message = new Message();

    public static void main(String[] args) {
        try {
            message.rules();
            Game game = new Game();
            Matrix matrix = new Matrix(game.sayHelloAndSetSize());
            final int gameTotal = matrix.getMatrixSize() * matrix.getMatrixSize();
            int row = -1, col = -1, temp = 0;

            message.empty();
            message.divider();
            message.println("Oyuna baslayacak olan oyuncu = " + game.getGamer());
            message.println("Sizin karakteriniz = " + game.getUserCharacter());
            message.println("Rakip karakter = " + game.getComputerCharacter());
            message.divider();
            message.empty();

            while (game.getGameCount() < gameTotal) {
                if (game.getGamer() == "Computer") {
                    final int computerScore = game.getComputerPoint();
                    do {
                        row = game.assignComputerValue(matrix.getMatrixSize());
                        col = game.assignComputerValue(matrix.getMatrixSize());
                    } while (!matrix.checkCell(row, col));

                    matrix.fillMatrix(row, col, game.getComputerCharacter());
                    message.print("Current Gamer => Computer, ");
                    message.println("Oynanan hamle : " + (row + 1) + ", " + (col + 1));

                    matrix.drawMatrix();
                    game.checkSOS(matrix, row, col, game.getComputerCharacter(), "Computer");
                    message.println("Skorlar: Computer : " + game.getComputerPoint() + ", User : " + game.getUserPoint());
                    game.changeGameCount();
                    if (Math.abs(game.getComputerPoint() - computerScore) > 0) {
                        message.println("SOS oldugun icin yeniden oyun hakki veriliyor");
                        game.setGamer("Computer");
                    } else game.setGamer("User");
                    message.divider();
                } else {
                    final int userScore = game.getUserPoint();
                    message.println("Current Gamer => User");
                    temp = 0;
                    do {
                        if (temp > 0) {
                            message.println("Hata, degerler yeniden aliniyor");
                        }
                        message.print("Satir : ");
                        row = game.getUserInput() - 1;
                        message.print("Sutun : ");
                        col = game.getUserInput() - 1;
                        temp++;
                    } while (!matrix.isValid(matrix.getMatrixSize() - 1, row, col) || !matrix.checkCell(row, col));
                    matrix.fillMatrix(row, col, game.getUserCharacter());
                    matrix.drawMatrix();
                    game.checkSOS(matrix, row, col, game.getUserCharacter(), "User");
                    message.println("Skorlar: Computer : " + game.getComputerPoint() + ", User : " + game.getUserPoint());
                    game.changeGameCount();
                    if (Math.abs(game.getUserPoint() - userScore) > 0) {
                        message.println("SOS oldugun icin yeniden oyun hakki veriliyor");
                        game.setGamer("User");
                    } else game.setGamer("Computer");
                    message.divider();
                }
            }
            game.finishScore();
            newGame();
        } catch (RuntimeException e) {
            message.println("Hata ile karsilasildi");
            newGame();
        }
    }

    static void newGame() {
        try {
            int secim;
            Scanner scan = new Scanner(System.in);
            message.println("Yeniden oynamak ister misin?\n 1-EVET | Digerleri - Hayir ");

            secim = scan.nextInt();
            if (secim == 1) {
                main(null);
            } else return;
        } catch (RuntimeException e) {
            newGame();
        }

    }
}
