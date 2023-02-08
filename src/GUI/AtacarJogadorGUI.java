package GUI;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */

import Player.Map;
import Player.Player;
import Player.PortalGestao;
import Player.Portal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtacarJogadorGUI implements ActionListener {
    private final JFrame frame = new JFrame("Atacar Portal");
    private final JLabel idPortal = new JLabel("Digite o Id do Portal:");
    private final JTextField fieldIdPortal = new JTextField();
    private final JLabel nergiaDoada = new JLabel("Digite a enrgia que pretende doar:");
    private final JTextField fieldEnergiaDoada = new JTextField();
    private final JButton buttonAtacar = new JButton("Atacar Portal");
    private Map tempMapa;
    private Player tempJogador;
    private PortalGestao portalGestao = new PortalGestao();
    public AtacarJogadorGUI(Map mapa, Player jogador) {
        this.tempMapa = mapa;
        this.tempJogador = jogador;

        idPortal.setBounds(100,100, 100,20);
        fieldIdPortal.setBounds(150, 100, 100, 10);
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 2));
        panel.add(idPortal);
        panel.add(fieldIdPortal);
        panel.add(nergiaDoada);
        panel.add(fieldEnergiaDoada);
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Atacar Portal");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonAtacar){
            int i = tempMapa.procurarLocal(Long.parseLong(fieldIdPortal.getText()));
            if(i != -1) {
                try{
                    portalGestao.destruirPortal((Portal) tempMapa.getLocais().get(i), Double.parseDouble(fieldEnergiaDoada.getText()), tempJogador);
                }catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Portal não encontrado");
            }
        }
    }
}
