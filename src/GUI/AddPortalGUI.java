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
    private final JButton button = new JButton("Adicionar Portal");
    private final JLabel label = new JLabel(" Adicionar Portal");
    private final JLabel iDportal = new JLabel("Digite o Id do Portal:");
    private final JTextField fieldIdProtal = new JTextField();
    private final JLabel LatitudePortal = new JLabel("Digite a Latitude do Portal:");
    private final JTextField fieldLatitudePortal = new JTextField();
    private final JLabel LongitudePortal = new JLabel("Digite a longitude do Portal:");
    private final JTextField fieldLongitudePortal = new JTextField();
    private final JLabel EnergiaPortal = new JLabel("Digite a Energia do Portal:");
    private final JTextField fieldEnergiaPortal = new JTextField();
    private final Checkbox Sparks = new Checkbox("Sparks");
    private final Checkbox Giants = new Checkbox("Giants");
    private final Checkbox Neutro = new Checkbox("Neutro");

    public AddPortalGUI() {
        button.setBounds(250, 150, 100, 20);
        button.addActionListener(this);
        label.setBounds(100, 100, 100, 20);
        iDportal.setBounds(100, 100, 100, 20);
        fieldIdProtal.setBounds(150, 100, 100, 10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(iDportal);
        panel.add(fieldIdProtal);
        panel.add(LatitudePortal);
        panel.add(fieldLatitudePortal);
        panel.add(LongitudePortal);
        panel.add(fieldLongitudePortal);
        panel.add(EnergiaPortal);
        panel.add(fieldEnergiaPortal);
        panel.add(Sparks);
        panel.add(Giants);
        panel.add(Neutro);

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
        if (e.getSource() == button)
            System.out.println("Eu sou lindo!!");
    }
}
