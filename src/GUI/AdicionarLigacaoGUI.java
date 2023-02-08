package GUI;

import Player.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarLigacaoGUI implements ActionListener {
    private final JFrame frame = new JFrame("Adicionar Ligação");
    private final JLabel idLocal = new JLabel("Digite o Id do Local:");
    private final JTextField fieldIdLocal = new JTextField();
    private final JLabel idLocal1 = new JLabel("Digite o Id do Local:");
    private final JTextField fieldIdLocal1 = new JTextField();
    private final JButton buttonAdicionarLigacao = new JButton("Adicionar Ligação");
    private int idValidade;
    private int idValidade1;
    private Map tempMapa;

    public AdicionarLigacaoGUI(Map mapa) {
        buttonAdicionarLigacao.setBounds(250, 150, 100, 20);
        buttonAdicionarLigacao.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(idLocal);
        panel.add(fieldIdLocal);
        panel.add(idLocal1);
        panel.add(fieldIdLocal1);
        panel.add(buttonAdicionarLigacao);

        frame.setSize(500, 500);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("8210311 Daniela Moreira // 8210367 Orlando Pires");
        frame.pack();
        frame.setVisible(true);

        tempMapa = mapa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonAdicionarLigacao){
            idValidade = tempMapa.procurarLocal(Long.parseLong(fieldIdLocal.getText()));
            idValidade1 = tempMapa.procurarLocal(Long.parseLong(fieldIdLocal1.getText()));

            if(idValidade == -1 || idValidade1 == -1){
                System.out.println("Um ou ambos os locais não existem!");
            }
            if(idValidade != -1 && idValidade1 != -1){
                tempMapa.addEdge(idValidade, idValidade1);
                System.out.println("A ligação foi adicionada com sucesso!");
            }
        }
    }
}
