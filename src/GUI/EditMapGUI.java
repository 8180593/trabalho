package GUI;

import Exceptions.InvalidValue;
import Player.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditMapGUI implements ActionListener {
    private final JFrame frame = new JFrame("Edit Map");
    private final JButton buttonAdicionarPortal = new JButton("Adicionar Portal");
    private final JButton buttonAdicionarConnector = new JButton("Adicionar Connector");
    private final JButton buttonEditarLocal = new JButton("Editar Local");
    private final JButton buttonRemoverLocal = new JButton("Remover Portal");
    private final JButton buttonAdicionarLigacao = new JButton("Adicionar Ligação");
    private Map tempMapa;

    public EditMapGUI(Map mapa) {
        buttonAdicionarPortal.setBounds(250, 150, 100, 20);
        buttonAdicionarPortal.addActionListener(this);
        buttonAdicionarConnector.setBounds(250, 150, 100, 20);
        buttonAdicionarConnector.addActionListener(this);
        buttonEditarLocal.setBounds(250, 150, 100, 20);
        buttonEditarLocal.addActionListener(this);
        buttonRemoverLocal.setBounds(250, 150, 100, 20);
        buttonRemoverLocal.addActionListener(this);
        buttonAdicionarLigacao.setBounds(250, 150, 100, 20);
        buttonAdicionarLigacao.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(buttonAdicionarPortal);
        panel.add(buttonAdicionarConnector);
        panel.add(buttonEditarLocal);
        panel.add(buttonRemoverLocal);
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
        if (e.getSource() == buttonAdicionarPortal) {
            AddPortalGUI addPortalGUI = new AddPortalGUI(tempMapa);
        }
        if (e.getSource() == buttonAdicionarConnector){
            try {
                AddConnectorGUI addConnectorGUI = new AddConnectorGUI(tempMapa);
            } catch (InvalidValue ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == buttonEditarLocal){
            EditarLocalGUI editarLocalGUI = new EditarLocalGUI(tempMapa);
        }

        if(e.getSource() == buttonRemoverLocal){
            try {
                RemoverLocalGUI removerLocalGUI = new RemoverLocalGUI(tempMapa);
            } catch (InvalidValue ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == buttonAdicionarLigacao){
            AdicionarLigacaoGUI adicionarLigacaoGUI = new AdicionarLigacaoGUI(tempMapa);
        }
    }
}
