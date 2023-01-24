package GUI;

import ClassImplementation.LinkedList;
import Player.Player;
import Player.Equipas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private LinkedList<Player> players = new LinkedList<>();
    public GUI(){
        JFrame frame = new JFrame("JFrame Example");

        JButton button = new JButton("Adicionar Jogador");
        button.setPreferredSize(new Dimension(175, 75));
        button.addActionListener(this);

        JLabel label = new JLabel(" Adicionar Jogadores");
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("8210311 Daniela Moreira // 8210367 Orlando Pires");
        frame.pack();
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        players.add(new Player("Daniela", Equipas.Giants));
        System.out.println(players.getFront().getElement().getName());
    }
    public static void main(String[] args) {
        new GUI();
    }
}