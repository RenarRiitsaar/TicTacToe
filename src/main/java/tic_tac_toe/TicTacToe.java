package tic_tac_toe;


import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;


public class TicTacToe implements ActionListener {

    @Getter
    private static final JFrame frame = new JFrame();
    @Getter
    private static final JLabel notification = new JLabel();
    private final JPanel titlePanel = new JPanel();
    private final JPanel buttonPanel = new JPanel();
    @Getter
    private static JButton[] buttons = new JButton[9];
    @Setter @Getter
    private static boolean isPlayerXTurn =true;

    TicTacToe(){
        frame.setSize(500,500);
        frame.setTitle("Tic-Tac-Toe");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        notification.setText("Tic-Tac-Toe");
        notification.setFont(new Font("Old English Text MT",Font.BOLD,50));
        notification.setHorizontalAlignment(JLabel.CENTER);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,500,100);

        buttonPanel.setLayout(new GridLayout(3,3));

        for(int i =0; i<9; i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setBackground(new Color(254,254,254));
            buttons[i].setFont(new Font("Old English Text MT", Font.BOLD, 100));
            buttons[i].setText("");
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        titlePanel.add(notification);

        frame.add(titlePanel,BorderLayout.NORTH);
        frame.add(buttonPanel);

        Random random = new Random();
        isPlayerXTurn = random.nextBoolean();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notification.setText(isPlayerXTurn ? "X turn" : "O turn");
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {

            if (e.getSource() == buttons[i]) {
                if (isPlayerXTurn) {
                    if (Objects.equals(buttons[i].getText(), ""))
                        buttons[i].setText("X");
                        buttons[i].setBackground(Color.GREEN);
                        buttons[i].setEnabled(false);
                    isPlayerXTurn = false;
                    notification.setText("O turn");
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setText("O");
                            buttons[i].setBackground(Color.RED);
                            buttons[i].setEnabled(false);
                        isPlayerXTurn = true;
                        notification.setText("X turn");
                    }
                }
            }
        }
        checkWinner.checkWin();
        checkWinner.checkTie();
    }

}
