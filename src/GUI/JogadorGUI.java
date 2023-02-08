package GUI;

import ClassImplementation.LinkedList;
import Player.Map;
import Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class JogadorGUI implements ActionListener {
    private final JFrame frame = new JFrame("Menu Jogador");
    private final JButton buttonAdicionar = new JButton("Adicionar Jogador");
    private final JButton buttonRemover = new JButton("Remover Jogador");
    private final JTextField textFieldJogador = new JTextField();
    private final JLabel label = new JLabel("Insira o Id do Jogador para fazer Login/Remover:");
    private final JButton buttonLogin = new JButton("Login Jogador");
    Map tempMapa = new Map();
    LinkedList<Player> tempJogadores = new LinkedList<>();
    int jogadorValido;

    public JogadorGUI(Map mapa, LinkedList<Player> jogadores) {
        this.tempMapa = mapa;
        this.tempJogadores = jogadores;

        buttonAdicionar.setBounds(250, 150, 100, 20);
        buttonAdicionar.addActionListener(this);

        buttonRemover.setBounds(250, 150, 100, 20);
        buttonRemover.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(buttonAdicionar);
        panel.add(label);
        panel.add(textFieldJogador);
        panel.add(buttonRemover);
        panel.add(buttonLogin);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Menu Jogador");
        frame.pack();
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAdicionar) {
            AddJogadorGUI addJogadorGUI = new AddJogadorGUI();
        }
        if (e.getSource() == buttonRemover) {
            jogadorValido = jogadorValido(textFieldJogador.getText());
            if (jogadorValido == -1) {
                System.out.println("Jogador não encontrado!");
            } else {
                tempJogadores.remove(jogadorValido);
                System.out.println("Jogador removido com sucesso!");
            }
            if (e.getSource() == buttonLogin) {
                jogadorValido = jogadorValido(textFieldJogador.getText());
                if (jogadorValido != -1) {
                    new MenuPlayerGUI(tempMapa, tempJogadores.get(jogadorValido));
                } else {
                    System.out.println("Jogador não encontrado!");
                }
            }
        }
    }

    /**
     * Metdo Jogador Válido
     *
     * Procura o jogador pelo seu nome
     * @param nome do jogador que se quer encontrar
     * @return -1 se não encontrar e a posição se o encontrar
     */
    public int jogadorValido(String nome){
        for(int i = 0; i < tempJogadores.size(); i++) {
            if (nome.equals(tempJogadores.get(i).getName())){
                return i;
            }
        }
        return -1;
    }
}
