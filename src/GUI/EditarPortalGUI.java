package GUI;

import Player.Map;
import Player.Portal;
import Player.Equipas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarPortalGUI implements ActionListener {
    //tres butoes mas quatro sitios para escrever
    //um edita apenas a energia
    //um edita ambos a latitude e longitude
    //um edita o estado (equipa)

    private final JFrame frame = new JFrame("Editar Portal");
    private final JLabel idLocal = new JLabel("Digite o Id do Local:");
    private final JTextField fieldIdLocal = new JTextField();
    private final JLabel LatitudePortal = new JLabel("Digite a Latitude do Portal:");
    private final JTextField fieldLatitudePortal = new JTextField();
    private final JLabel LongitudePortal = new JLabel("Digite a Longitude do Portal:");
    private final JTextField fieldLongitudePortal = new JTextField();
    private final JButton buttonCoordenadas = new JButton("Editar Coordenadas Portal");
    private final JLabel labelCoordenadas = new JLabel("Editar Coordenadas Portal");
    private final JLabel EnergiaPortal = new JLabel("Digite a Energia Máxima do Portal:");
    private final JTextField fieldEnergiaPortal = new JTextField();
    private final JButton buttonEnergia = new JButton("Editar Energia Portal");
    private final JLabel labelEnergia = new JLabel("Editar Energia Portal");
    private int idValidade;
    private boolean latitudeValidade;
    private boolean longitudeValidade;
    private Map tempMapa;

    public EditarPortalGUI(Map mapa) {
        buttonCoordenadas.setBounds(250, 150, 100, 20);
        buttonCoordenadas.addActionListener(this);
        labelCoordenadas.setBounds(100, 100, 100, 20);

        buttonEnergia.setBounds(250, 150, 100, 20);
        buttonEnergia.addActionListener(this);
        labelEnergia.setBounds(100, 100, 100, 20);

        idLocal.setBounds(100,100, 100,20);
        fieldIdLocal.setBounds(150, 100, 100, 10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 2));

        panel.add(idLocal);
        panel.add(fieldIdLocal);

        panel.add(LatitudePortal);
        panel.add(fieldLatitudePortal);
        panel.add(LongitudePortal);
        panel.add(fieldLongitudePortal);
        panel.add(labelCoordenadas);
        panel.add(buttonCoordenadas);

        panel.add(EnergiaPortal);
        panel.add(fieldEnergiaPortal);
        panel.add(labelEnergia);
        panel.add(buttonEnergia);

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
        if (e.getSource() == buttonCoordenadas) {
            idValidade = tempMapa.procurarLocal(Long.parseLong(fieldIdLocal.getText()));

            if (idValidade == -1) {
                System.out.println("Este local não existe!");
            } else {
                latitudeValidade = validInputLatitude(Double.parseDouble(fieldLatitudePortal.getText()));
                longitudeValidade = validInputLongitude(Double.parseDouble(fieldLongitudePortal.getText()));

                if (!latitudeValidade) {
                    System.out.println("A latitude só pode ter valores entre -90 e 90 graus!");
                }
                if (!longitudeValidade) {
                    System.out.println("A longitude só pode ter valores entre -180 e 180 graus!");
                }
                if(latitudeValidade && longitudeValidade){
                    tempMapa.getLocais().get(idValidade).setLatitude(Double.parseDouble(fieldLatitudePortal.getText()));
                    tempMapa.getLocais().get(idValidade).setLongitude(Double.parseDouble(fieldLongitudePortal.getText()));
                    System.out.println("A longitude e a latitude foram editadas com sucesso!");
                }
            }
        }
        if (e.getSource() == buttonEnergia) {
            idValidade = tempMapa.procurarLocal(Long.parseLong(fieldIdLocal.getText()));

            if (idValidade == -1) {
                System.out.println("Este local não existe!");
            } else {
                if(Double.parseDouble(fieldEnergiaPortal.getText()) < 0){
                    System.out.println("A energia tem de ser positiva!");
                } else {
                    tempMapa.getLocais().get(idValidade).setEnergiaAtual(Double.parseDouble(fieldEnergiaPortal.getText()));
                    System.out.println("A energia foi editada com sucesso!");
                }
            }
        }
    }

        /**
         * Metodo Valid Input Latitude
         *
         * Verifica se a latitude colocada no input é válida.
         * Neste caso, verifica se o valor da latitude se encontra entre os -90 e os 90 graus.
         *
         * @param latitude coordenadas da latitude
         * @return true se for válida
         */
        public boolean validInputLatitude(double latitude){
            return !(latitude < -90) && !(latitude > 90);
        }

        /**
         * Metodo Valid Input Longitude
         *
         * Verifica se a longitude colocada no input é válida.
         * Neste caso, verifica se o valor da longitude se encontra entre os -180 e os 180 graus.
         *
         * @param longitude coordenadas da longitude
         * @return true se for válida
         */
        public boolean validInputLongitude(double longitude){
            return !(longitude < -180) && !(longitude > 180);
        }
}
