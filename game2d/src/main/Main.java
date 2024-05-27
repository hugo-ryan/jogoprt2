package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2d jogo");

        JogoPanel jogoPanel = new JogoPanel();
        window.add(jogoPanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        jogoPanel.startGameThread();
    }
}