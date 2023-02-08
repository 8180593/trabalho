package GUI;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
import Player.AcaoPlayer;
import Player.Map;
import Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    * andar, atacar e fortalecer
 */
public class MenuPlayerGUI implements ActionListener {
    private final JFrame frame = new JFrame("Menu Player");
    private final JButton buttonAndar = new JButton("Andar");
    private final JButton buttonAtacar = new JButton("Atacar");
    private final JButton buttonFortalecer = new JButton("Fortalecer");
    private Map tempMapa;
    private Player tempPlayer;
    private AcaoPlayer acaoPlayer;
    public MenuPlayerGUI(Map mapa, Player jogador) {
        this.tempMapa = mapa;
        this.tempPlayer = jogador;

        buttonAndar.setBounds(250, 150, 100, 20);
        buttonAndar.addActionListener(this);

        buttonAtacar.setBounds(250, 150, 100, 20);
        buttonAtacar.addActionListener(this);

        buttonFortalecer.setBounds(250, 150, 100, 20);
        buttonFortalecer.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(buttonAndar);
        panel.add(buttonAtacar);
        panel.add(buttonFortalecer);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Menu Player");
        frame.pack();
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonAndar){
            new AndarJogadorGUI(tempMapa, tempPlayer);
        }else if(e.getSource() == buttonAtacar){
            new AtacarJogadorGUI(tempMapa, tempPlayer);
        }else if(e.getSource() == buttonFortalecer){
            new FortalecerJogadorGUI(tempMapa, tempPlayer);
        }else{
            throw new RuntimeException("Erro no MenuPlayer");
        }
    }
}
