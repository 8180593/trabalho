package GUI;

import Exceptions.InvalidValue;
import Player.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverLocalGUI implements ActionListener {

    private final JFrame frame = new JFrame("Remover Local");
    private final JButton button = new JButton("Remover Local");
    private final JLabel label = new JLabel("Remover Local");
    private final JLabel idLocal = new JLabel("Digite o Id do Local:");
    private final JTextField fieldIdLocal = new JTextField();
    private int idValidade;
    private Map tempMapa;


    public RemoverLocalGUI(Map mapa) throws InvalidValue {
        button.setBounds(250, 150,100,20);
        button.addActionListener(this);
        label.setBounds(100,100, 100,20);
        idLocal.setBounds(100,100, 100,20);
        fieldIdLocal.setBounds(150, 100, 100, 10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(idLocal);
        panel.add(fieldIdLocal);
        panel.add(button);

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
        if(e.getSource() == button){
            idValidade = tempMapa.procurarLocal(Long.parseLong(fieldIdLocal.getText()));

            if(idValidade == -1){
                System.out.println("Este local não existe!");
            }else{
                tempMapa.removeLocal(tempMapa.getLocais().get(idValidade), idValidade);
                System.out.println("Local removido com sucesso!");
            }
        }
    }
}
