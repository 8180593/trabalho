package GUI;

import ClassImplementation.LinkedList;
import Exceptions.InvalidValue;
import Player.Player;
import Player.Map;
import Player.Portal;
import Player.Equipas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPortalGUI implements ActionListener {
    private final LinkedList<Player> players = new LinkedList<>();
    private final JFrame frame = new JFrame("JFrame Example");
    private final JButton button = new JButton("Adicionar Portal");
    private final JLabel label = new JLabel("Adicionar Portal");
    private final JLabel iDportal = new JLabel("Digite o Id do Portal:");
    private final JTextField fieldIdPortal = new JTextField();
    private final JLabel LatitudePortal = new JLabel("Digite a Latitude do Portal:");
    private final JTextField fieldLatitudePortal = new JTextField();
    private final JLabel LongitudePortal = new JLabel("Digite a Longitude do Portal:");
    private final JTextField fieldLongitudePortal = new JTextField();
    private final JLabel EnergiaPortal = new JLabel("Digite a Energia Máxima do Portal:");
    private final JTextField fieldEnergiaPortal = new JTextField();
    private final Checkbox Sparks = new Checkbox("Sparks");
    private final Checkbox Giants = new Checkbox("Giants");
    private final Checkbox Neutro = new Checkbox("Neutro");
    private boolean idPortalValidade;
    private boolean latitudeValidade;
    private boolean longitudeValidade;
    private int estadoValidade = 0;
    private boolean energiaValidade;
    private Portal portal;
    private Map tempMapa;

    public AddPortalGUI(Map mapa) {
        button.setBounds(250, 150, 100, 20);
        button.addActionListener(this);
        label.setBounds(100, 100, 100, 20);
        iDportal.setBounds(100, 100, 100, 20);
        fieldIdPortal.setBounds(150, 100, 100, 10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(iDportal);
        panel.add(fieldIdPortal);
        panel.add(LatitudePortal);
        panel.add(fieldLatitudePortal);
        panel.add(LongitudePortal);
        panel.add(fieldLongitudePortal);
        panel.add(EnergiaPortal);
        panel.add(fieldEnergiaPortal);
        panel.add(Sparks);
        panel.add(Giants);
        panel.add(Neutro);

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
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == button) {
            if(Sparks.getState() && !Giants.getState() && !Neutro.getState()){
                estadoValidade = 1;
            }
            if(!Sparks.getState() && Giants.getState() && !Neutro.getState()){
                estadoValidade = 2;
            }
            if(!Sparks.getState() && !Giants.getState() && Neutro.getState()){
                estadoValidade = 3;
            }

            idPortalValidade = validInputId(fieldIdPortal.getText(), tempMapa);
            latitudeValidade = validInputLatitude(Double.parseDouble(fieldLatitudePortal.getText()));
            longitudeValidade = validInputLongitude(Double.parseDouble(fieldLongitudePortal.getText()));
            energiaValidade = validInputPositivo(Double.parseDouble(fieldEnergiaPortal.getText()));

            if (!idPortalValidade) {
                System.out.println("O Id já existe!");
            }
            if (!latitudeValidade) {
                System.out.println("A latitude só pode ter valores entre -90 e 90 graus!");
            }
            if (!longitudeValidade) {
                System.out.println("A longitude só pode ter valores entre -180 e 180 graus!");
            }
            if (estadoValidade == 0) {
                System.out.println("Tem de selecionar apenas uma das opções de estado!");
            }
            if (!energiaValidade) {
                System.out.println("A energia tem de ser positiva!");
            }
            if (idPortalValidade && latitudeValidade && longitudeValidade && estadoValidade==1 && energiaValidade) {
                System.out.println("Portal criado com sucesso!");

                portal = new Portal(Long.parseLong(fieldIdPortal.getText()),
                        Double.parseDouble(fieldLatitudePortal.getText()),
                        Double.parseDouble(fieldLongitudePortal.getText()),
                        Equipas.Sparks,
                        Double.parseDouble(fieldEnergiaPortal.getText()));

                tempMapa.addLocal(portal);
            }
            if (idPortalValidade && latitudeValidade && longitudeValidade && estadoValidade==2 && energiaValidade) {
                System.out.println("Portal criado com sucesso!");

                portal = new Portal(Long.parseLong(fieldIdPortal.getText()),
                        Double.parseDouble(fieldLatitudePortal.getText()),
                        Double.parseDouble(fieldLongitudePortal.getText()),
                        Equipas.Giants,
                        Double.parseDouble(fieldEnergiaPortal.getText()));

                tempMapa.addLocal(portal);
            }
            if (idPortalValidade && latitudeValidade && longitudeValidade && estadoValidade==3 && energiaValidade) {
                System.out.println("Portal criado com sucesso!");

                portal = new Portal(Long.parseLong(fieldIdPortal.getText()),
                        Double.parseDouble(fieldLatitudePortal.getText()),
                        Double.parseDouble(fieldLongitudePortal.getText()),
                        Equipas.Neutro,
                        Double.parseDouble(fieldEnergiaPortal.getText()));

                tempMapa.addLocal(portal);
            }
        }
    }

    /**
     * Metodo Input Id
     *
     * Verifica se o id colocado no input é válido.
     * Neste caso, verifica se existe algum id igual.
     *
     * @param id colocado como input pelo utilizador
     * @param mapa do jogo
     * @return true se o input for válido
     */
    public boolean validInputId(String id, Map mapa){
        for(int i = 0; i < mapa.getLocais().size(); i++){
            if(mapa.getLocais().get(i).getId().equals(id)){
                return false;
            }
        }
        return true;
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

    /**
     * Metodo Valid Input Positivo
     *
     * Verifica se a energia/intervaloTempo colocada no input é válida.
     * Neste caso, verifica se o valor da energia/intervaloTempo é um número positivo.
     *
     * @param positivo do portal
     * @return true se for válida
     */
    public boolean validInputPositivo(double positivo){
        return !(positivo < 0);
    }
}
