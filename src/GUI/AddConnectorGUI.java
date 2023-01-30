package GUI;

import ClassImplementation.LinkedList;
import Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddConnectorGUI implements ActionListener {
    private final LinkedList<Player> players = new LinkedList<>();
    private final JFrame frame = new JFrame("JFrame Example");
    private final JButton button = new JButton("Adicionar Connector");
    private final JLabel label = new JLabel(" Adicionar Connector");
    private final JLabel iDconnector = new JLabel("Digite o Id do Portal:");
    private final JTextField fieldIdConnector = new JTextField();
    private final JLabel LatitudeConnector = new JLabel("Digite a Latitude do Connector:");
    private final JTextField fieldLatitudeConnector = new JTextField();
    private final JLabel LongitudeConnector = new JLabel("Digite a longitude do Connector:");
    private final JTextField fieldLongitudeConnector = new JTextField();
    private final JLabel EnergiaConnector = new JLabel("Digite a Energia do Connector:");
    private final JTextField fieldEnergiaConnector = new JTextField();

    public AddConnectorGUI(){
        button.setBounds(250, 150,100,20);
        button.addActionListener(this);
        label.setBounds(100,100, 100,20);
        iDconnector.setBounds(100,100, 100,20);
        fieldIdConnector.setBounds(150, 100, 100, 10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(iDconnector);
        panel.add(fieldIdConnector);
        panel.add(LatitudeConnector);
        panel.add(fieldLatitudeConnector);
        panel.add(LongitudeConnector);
        panel.add(fieldLongitudeConnector);
        panel.add(EnergiaConnector);
        panel.add(fieldEnergiaConnector);
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
}
