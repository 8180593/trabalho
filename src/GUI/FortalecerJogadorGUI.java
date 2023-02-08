package GUI;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
import Exceptions.InvalidValue;
import Player.Map;
import Player.Player;
import Player.Portal;
import Player.PortalGestao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FortalecerJogadorGUI implements ActionListener {
    private final JFrame frame = new JFrame("Fortalecer Portal");
    private final JLabel idPortal = new JLabel("Digite o Id do Portal:");
    private final JLabel enrgiaDoada = new JLabel("Digite a Energia a ser doada:");
    private final JTextField fieldIdPortal = new JTextField();
    private final JTextField fieldEnergiaDoada = new JTextField();
    private final JButton buttonFortalecer = new JButton("Fortalecer Portal");
    private Map tempMapa;
    private Player tempJogador;
    private PortalGestao portalGestao = new PortalGestao();
    public FortalecerJogadorGUI(Map mapa, Player jogador){
        this.tempMapa = mapa;
        this.tempJogador = jogador;

        idPortal.setBounds(100,100, 100,20);
        fieldIdPortal.setBounds(150, 100, 100, 10);
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 2));
        panel.add(idPortal);
        panel.add(fieldIdPortal);
        panel.add(enrgiaDoada);
        panel.add(fieldEnergiaDoada);
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Fortalecer Portal");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonFortalecer){
            int i = tempMapa.procurarLocal(Long.parseLong(fieldIdPortal.getText()));
            if(i != -1) {
                try {
                    portalGestao.fortalecerPortal((Portal) tempMapa.getLocais().get(i), Double.parseDouble(fieldEnergiaDoada.getText()), tempJogador);
                } catch (InvalidValue ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
