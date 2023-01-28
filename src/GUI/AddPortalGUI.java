package GUI;

import ClassImplementation.LinkedList;
import Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPortalGUI implements ActionListener {
    private final LinkedList<Player> players = new LinkedList<>();
    private final JFrame frame = new JFrame("JFrame Example");
    private final JButton button = new JButton("Adicionar Protal");
    private final JLabel label = new JLabel(" Adicionar Portal");
    private final JLabel iDportal = new JLabel("Digite o Id do Protal:");
    private final JTextField fieldName = new JTextField();

    public AddPortalGUI(){
        button.setBounds(250, 150,100,20);
        button.addActionListener(this);
        label.setBounds(100,100, 100,20);
        iDportal.setBounds(100,100, 100,20);
        fieldName.setBounds(150, 100, 100, 10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(iDportal);
        panel.add(fieldName);

        panel.add(button);

        frame.setSize(500, 500);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("8210311 Daniela Moreira // 8210367 Orlando Pires");
        frame.pack();
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button)
            System.out.println("Eu sou lindo!!");
    }

    public static void main(String[] args) {
        new AddPortalGUI();
    }
}
