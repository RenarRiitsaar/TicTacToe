package tic_tac_toe;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
class checkWinnerTests {

    @Test
    void checkWin() {
        new TicTacToe();

        String xWon = "X won";
        String oWon = "O won";
        TicTacToe.getButtons()[0].setText("X");
        TicTacToe.getButtons()[1].setText("X");
        TicTacToe.getButtons()[2].setText("X");

        checkWinner.checkWin();

        assertEquals(TicTacToe.getNotification().getText(), xWon);

        checkWinner.restart();



        TicTacToe.getButtons()[3].setText("O");
        TicTacToe.getButtons()[4].setText("O");
        TicTacToe.getButtons()[5].setText("O");


        checkWinner.checkWin();

        assertEquals(TicTacToe.getNotification().getText(), oWon);

    }


    @Test
    void checkTie() {

        new TicTacToe();

        String checkTie = "Its a tie";
        TicTacToe.getButtons()[0].setText("F");
        TicTacToe.getButtons()[1].setText("F");
        TicTacToe.getButtons()[2].setText("F");
        TicTacToe.getButtons()[3].setText("F");
        TicTacToe.getButtons()[4].setText("F");
        TicTacToe.getButtons()[5].setText("F");
        TicTacToe.getButtons()[6].setText("F");
        TicTacToe.getButtons()[7].setText("F");
        TicTacToe.getButtons()[8].setText("F");


        checkWinner.checkTie();

        assertEquals(TicTacToe.getNotification().getText(), checkTie);


    }

    @Test
    void restart() {
        new TicTacToe();

        String buttonValue = "";

        checkWinner.restart();



        for (int i = 0; i < 9 ; i++) {
            assertEquals(TicTacToe.getButtons()[i].getText(), buttonValue);
            assertTrue(TicTacToe.getButtons()[i].isEnabled());
            assertEquals(TicTacToe.getButtons()[i].getBackground(), new Color(254, 254, 254));

        }

        assertFalse(checkWinner.isHasWon());

    }
}