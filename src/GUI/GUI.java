package GUI;
import ClassImplementation.LinkedList;
import Exceptions.InvalidValue;
import Player.*;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * @author Daniela Moreira 8210311
 * @author Orlando Pires 8210367
 */
public class GUI implements ActionListener {
    private final JFrame frame = new JFrame("Menu Inicial");
    private final JButton buttonMenuAdmin = new JButton("Menu Administrador");
    private final JButton buttonMenuJogador = new JButton("Menu Jogador");
    private final JButton buttonMostrarLocais = new JButton("Mostrar Locais");
    private final JButton buttonMostrarJogadores = new JButton("Mostrar Jogadores");
    private final JButton buttonLerJson = new JButton("Importar Json");
    private final JButton buttonEscreverJson = new JButton("Guardar Json");

    private Json json = new Json();
    LinkedList<Portal> portais = new LinkedList<>();
    LinkedList<Connector> conectores = new LinkedList<>();
    LinkedList<Player> jogadores = new LinkedList<>();
    Map mapa = new Map();

    public GUI() throws InvalidValue, IOException, ParseException {
        json.importarJson("Map.json", portais, conectores, jogadores);

        buttonMenuAdmin.setBounds(250, 150, 100, 20);
        buttonMenuAdmin.addActionListener(this);
        buttonMenuJogador.setBounds(250, 150, 100, 20);
        buttonMenuJogador.addActionListener(this);
        buttonMostrarLocais.setBounds(250, 150, 100, 20);
        buttonMostrarLocais.addActionListener(this);
        buttonMostrarJogadores.setBounds(250, 150, 100, 20);
        buttonMostrarJogadores.addActionListener(this);
        buttonLerJson.setBounds(250, 150, 100, 20);
        buttonLerJson.addActionListener(this);
        buttonEscreverJson.setBounds(250, 150, 100, 20);
        buttonEscreverJson.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(buttonMenuAdmin);
        panel.add(buttonMenuJogador);
        panel.add(buttonMostrarLocais);
        panel.add(buttonMostrarJogadores);
        panel.add(buttonLerJson);
        panel.add(buttonEscreverJson);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Menu Jogador");
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonMenuAdmin){
            EditMapGUI editMapGUI = new EditMapGUI(mapa);
        }
        if(e.getSource() == buttonMenuJogador){
            JogadorGUI jogadorGUI = new JogadorGUI(mapa, jogadores);
        }
        if(e.getSource() == buttonMostrarLocais){
            for(int i = 0; i < mapa.getPortais().size(); i++){
                System.out.println(mapa.getPortais().get(i).getId());
                System.out.println(mapa.getPortais().get(i).getLatitude());
                System.out.println(mapa.getPortais().get(i).getLongitude());
                System.out.println(mapa.getPortais().get(i).getEnergiaAtual());
                System.out.println("\\--------------||--------------//");
            }
            System.out.println("Existem no total " + mapa.getPortais().size() + " portais.");

            for(int i = 0; i < mapa.getConnectors().size(); i++){
                System.out.println(mapa.getConnectors().get(i).getId());
                System.out.println(mapa.getConnectors().get(i).getLatitude());
                System.out.println(mapa.getConnectors().get(i).getLongitude());
                System.out.println(mapa.getConnectors().get(i).getEnergiaAtual());
                System.out.println("\\--------------||--------------//");
            }
            System.out.println("Existem no total " + mapa.getPortais().size() + " connectores.");
        }
        if(e.getSource() == buttonMostrarJogadores){
            for(int i = 0; i < jogadores.size(); i++){
                System.out.println(jogadores.get(i).getName());
                System.out.println(jogadores.get(i).getNivel());
                System.out.println(jogadores.get(i).getEquipa());
                System.out.println(jogadores.get(i).getEnergia());
                System.out.println(jogadores.get(i).getExperiencia());
                System.out.println("\\--------------||--------------//");
            }
            System.out.println("Existem no total " + jogadores.size() + " jogadores.");
        }
        if(e.getSource() == buttonLerJson){
            try {
                json.importarJson("Map.json", portais, conectores, jogadores);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == buttonEscreverJson){
            json.exportarJson("Map.json", portais, conectores, jogadores);
        }
    }
    public static void main(String[] args) throws InvalidValue {
        try {
            GUI gui = new GUI();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
