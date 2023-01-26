package GUI;

import ClassImplementation.LinkedList;
import ClassImplementation.Node;
import Player.Equipas;
import Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Daniela Moreira 8210311
 * @author Orlando Pires 8210367
 */
public class GUI implements ActionListener {
    private LinkedList<Player> players = new LinkedList<>();
    private JFrame frame = new JFrame("JFrame Example");
    private JButton button = new JButton("Adicionar Jogador");
    private JLabel label = new JLabel(" Adicionar Jogadores");
    private JLabel jogador = new JLabel("Digite o nome do Jogador:");
    private JTextField fieldName = new JTextField();
    private Checkbox Sparks = new Checkbox("Sparks");
    private Checkbox Giants = new Checkbox("Giants");
    public GUI(){
        button.setBounds(250, 150,100,20);
        button.addActionListener(this);
        label.setBounds(100,100, 100,20);
        jogador.setBounds(100,100, 100,20);
        fieldName.setBounds(150, 100, 100, 10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(jogador);
        panel.add(fieldName);
        panel.add(Sparks);
        panel.add(Giants);
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
            if(addPlayer())
                JOptionPane.showMessageDialog(null, "Jogador adicionado com sucesso");
    }
    public boolean addPlayer(){
        if(!Sparks.getState() && Giants.getState() && !fieldName.getText().isEmpty()){
            Player jogador = new Player(fieldName.getText(), Equipas.Giants);
            if(!verificaJogador(jogador)){
                players.add(jogador);
                return true;
            }
            return false;
        }
        else if(Sparks.getState() && !Giants.getState() && !fieldName.getText().isEmpty()){
            Player jogador = new Player(fieldName.getText(), Equipas.Giants);
            if(!verificaJogador(jogador)){
                players.add(jogador);
                return true;
            }
            return false;
        }
        else if(Sparks.getState() && Giants.getState() && !fieldName.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "So pode selecionar uma equipa");
            return false;
        }
        else if(Sparks.getState() && Giants.getState() && fieldName.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite o nome do jogador e Selecione apenas uma equipa");
            return false;
        }
        else if(!Sparks.getState() && !Giants.getState() && !fieldName.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione uma equipa");
            return false;
        }
        else if(Sparks.getState() && !Giants.getState() && fieldName.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite o nome do Jogador");
            return false;
        }
        else if(!Sparks.getState() && Giants.getState() && fieldName.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite o nome do Jogador");
            return false;
        }
        else{
            JOptionPane.showMessageDialog(null, "Digite o nome do jogador e Selecione uma Equipa");
            return false;
        }
    }
    public static void main(String[] args) {
        new GUI();
    }
    public boolean verificaJogador(Player player){
        Node<Player> current = players.getFront();
        int i = 0;
        do{
            if(current.getElement().equals(player)){
                JOptionPane.showMessageDialog(null, "Jogador ja existe");
                return true;
            }
            current = current.getNext();
        }while(current != null);
        return false;
    }
}