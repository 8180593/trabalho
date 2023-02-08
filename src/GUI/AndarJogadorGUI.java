package GUI;

import ClassImplementation.LinkedList;
import Player.AcaoPlayer;
import Player.Local;
import Player.Map;
import Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class AndarJogadorGUI implements ActionListener {
    private final JFrame frame = new JFrame("Andar Jogador");
    private final JButton buttonProximoLocal = new JButton("Proximo Local");
    private final JLabel idLocal = new JLabel("Digite o Id do Local:");
    private final JTextField fieldIdLocal = new JTextField();
    private final JButton buttonCaminhoCurto = new JButton("Caminho Mais Curto");
    private int idValidade;
    private Map tempMapa;
    private Player tempJogador;
    Iterator<Local> locais;
    double tamanhoCaminho;
    AcaoPlayer acaoPlayer = new AcaoPlayer();
    LinkedList<Integer> resultado = new LinkedList<Integer>();

    public AndarJogadorGUI(Map mapa, Player jogador){
        buttonProximoLocal.setBounds(250, 150, 100, 20);
        buttonProximoLocal.addActionListener(this);

        idLocal.setBounds(100,100, 100,20);
        fieldIdLocal.setBounds(150, 100, 100, 10);

        buttonCaminhoCurto.setBounds(250, 150, 100, 20);
        buttonCaminhoCurto.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(buttonProximoLocal);
        panel.add(idLocal);
        panel.add(fieldIdLocal);
        panel.add(buttonCaminhoCurto);

        frame.setSize(500, 500);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("8210311 Daniela Moreira // 8210367 Orlando Pires");
        frame.pack();
        frame.setVisible(true);

        tempMapa = mapa;
        tempJogador = jogador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonProximoLocal){
            idValidade = tempMapa.procurarLocal(Long.parseLong(fieldIdLocal.getText()));

            if (idValidade == -1) {
                System.out.println("Este local não existe!");
            } else {
                resultado = acaoPlayer.proximaLocalizacao(tempMapa,tempJogador);
                if(!acaoPlayer.andar(tempJogador, idValidade, resultado)){
                    System.out.println("Este local não tem conexão!");
                    System.out.println("Eis os que têm: ");
                    for(int i = 0; i < resultado.size(); i++){
                        resultado.get(i);
                    }
                } else {
                    System.out.println("Andou com sucesso!");
                }
            }
        }

        if(e.getSource() == buttonCaminhoCurto){
            idValidade = tempMapa.procurarLocal(Long.parseLong(fieldIdLocal.getText()));

            if (idValidade == -1) {
                System.out.println("Este local não existe!");
            } else {
                locais = tempMapa.getNetwork().iteratorShortestPath(tempJogador.getLocalAtual(), idValidade);
                tamanhoCaminho = tempMapa.getNetwork().shortestPathWeight(tempJogador.getLocalAtual(), idValidade);

                System.out.println("Custo do caminho: " + tamanhoCaminho);

                System.out.println("Rota do caminho: ");
                while (locais.hasNext()){
                    System.out.println(locais.next().getId());
                }
            }
        }
    }
}
