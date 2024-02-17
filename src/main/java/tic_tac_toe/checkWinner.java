package tic_tac_toe;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class checkWinner{

  static  boolean hasWon = false;
    public static void checkWin() {


        if (Objects.equals(TicTacToe.getButtons()[0].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[1].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[2].getText(), "X")) {
            winnerX(0, 1, 2);

        }
        if (Objects.equals(TicTacToe.getButtons()[3].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[4].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[5].getText(), "X")) {
            winnerX(3, 4, 5);

        }
        if (Objects.equals(TicTacToe.getButtons()[6].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[7].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[8].getText(), "X")) {
            winnerX(6, 7, 8);

        }
        if (Objects.equals(TicTacToe.getButtons()[0].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[4].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[8].getText(), "X")) {
            winnerX(0, 4, 8);

        }
        if (Objects.equals(TicTacToe.getButtons()[2].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[4].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[6].getText(), "X")) {
            winnerX(2, 4, 6);

        }


        if (Objects.equals(TicTacToe.getButtons()[0].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[3].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[6].getText(), "X")) {
            winnerX(0, 3, 6);

        }

        if (Objects.equals(TicTacToe.getButtons()[1].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[4].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[7].getText(), "X")) {
            winnerX(1, 4, 7);

        }
        if (Objects.equals(TicTacToe.getButtons()[2].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[5].getText(), "X") &&
                Objects.equals(TicTacToe.getButtons()[8].getText(), "X")) {
            winnerX(2, 5, 8);

        }


        if (Objects.equals(TicTacToe.getButtons()[0].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[1].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[2].getText(), "O")) {
            winnerO(0, 1, 2);


        }
        if (Objects.equals(TicTacToe.getButtons()[3].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[4].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[5].getText(), "O")) {
            winnerO(3, 4, 5);

        }
        if (Objects.equals(TicTacToe.getButtons()[6].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[7].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[8].getText(), "O")) {
            winnerO(6, 7, 8);


        }
        if (Objects.equals(TicTacToe.getButtons()[0].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[4].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[8].getText(), "O")) {
            winnerO(0, 4, 8);

        }
        if (Objects.equals(TicTacToe.getButtons()[2].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[4].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[6].getText(), "O")) {
            winnerO(2, 4, 6);

        }
        if (Objects.equals(TicTacToe.getButtons()[0].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[3].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[6].getText(), "O")) {
            winnerO(0, 3, 6);

        }
        if (Objects.equals(TicTacToe.getButtons()[1].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[4].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[7].getText(), "O")) {
            winnerO(1, 4, 7);

        }
        if (Objects.equals(TicTacToe.getButtons()[2].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[5].getText(), "O") &&
                Objects.equals(TicTacToe.getButtons()[8].getText(), "O")) {
            winnerO(2, 5, 8);

        }
    }

    public static void winnerX(int a, int b, int c) {
        TicTacToe.getNotification().setText("X won");
        TicTacToe.getButtons()[a].setBackground(Color.GREEN);
        TicTacToe.getButtons()[b].setBackground(Color.GREEN);
        TicTacToe.getButtons()[c].setBackground(Color.GREEN);
        hasWon = true;

        for (int i = 0; i < 9; i++) {
            TicTacToe.getButtons()[i].setEnabled(false);

        }
        restart();
    }

    public static void winnerO(int a, int b, int c) {
        TicTacToe.getNotification().setText("O won");
        TicTacToe.getButtons()[a].setBackground(Color.RED);
        TicTacToe.getButtons()[b].setBackground(Color.RED);
        TicTacToe.getButtons()[c].setBackground(Color.RED);
        hasWon = true;

        for (int i = 0; i < 9; i++) {
            TicTacToe.getButtons()[i].setEnabled(false);

        }
        restart();
    }

    public static void checkTie() {
        List<String> chkTie = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            String chk = TicTacToe.getButtons()[i].getText();
            chkTie.add(chk);
        }

            if (!chkTie.contains("")) {
                for (int i = 0; i < 9; i++) {
                    TicTacToe.getButtons()[i].setEnabled(false);
                }
                TicTacToe.getNotification().setText("Its a tie");
                restart();
            }
        }


    public static void restart() {

            // Create a new thread for the delay
            Thread delayThread = new Thread(() -> {
                try {
                    // Introduce a 2-second delay
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, "Delay error");
                }


                SwingUtilities.invokeLater(() -> {
                    int option = JOptionPane.showConfirmDialog(null, "Play again?", "Tic-Tac-Toe",
                            JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {

                        Random random = new Random();
                        boolean randomTurn = random.nextBoolean();
                        TicTacToe.setPlayerXTurn(randomTurn);

                        for (int i = 0; i < 9; i++) {
                            TicTacToe.getButtons()[i].setText("");
                            TicTacToe.getButtons()[i].setEnabled(true);
                            TicTacToe.getButtons()[i].setBackground(new Color(254, 254, 254));

                            if(TicTacToe.isPlayerXTurn()) {
                                TicTacToe.getNotification().setText("X turn");
                            } else{
                                TicTacToe.getNotification().setText("O turn");
                            }
                            hasWon = false;
                        }
                    } else {
                        System.exit(0); // Exit the game if the user chooses not to play again
                    }
                });
            });
            delayThread.start(); // Start the thread

        }

    }
