package GUI;

import ClassImplementation.LinkedList;
import Exceptions.InvalidValue;
import Player.Player;
import Player.Map;
import Player.Connector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddConnectorGUI implements ActionListener {
    private final LinkedList<Player> players = new LinkedList<>();
    private final JFrame frame = new JFrame("JFrame Example");
    private final JButton button = new JButton("Adicionar Connector");
    private final JLabel label = new JLabel(" Adicionar Connector");
    private final JLabel iDconnector = new JLabel("Digite o Id do Portal:");
    private final JTextField fieldIdConnector = new JTextField();
    private final JLabel LatitudeConnector = new JLabel("Digite a Latitude do Connector:");
    private final JTextField fieldLatitudeConnector = new JTextField();
    private final JLabel LongitudeConnector = new JLabel("Digite a Longitude do Connector:");
    private final JTextField fieldLongitudeConnector = new JTextField();
    private final JLabel IntervaloTempoConnector = new JLabel("Digite o Intervalo do Connector:");
    private final JTextField fieldIntervaloTempoConnector = new JTextField();
    private final JLabel EnergiaConnector = new JLabel("Digite a Energia do Connector:");
    private final JTextField fieldEnergiaConnector = new JTextField();
    private boolean idConnectorValidade;
    private boolean latitudeValidade;
    private boolean longitudeValidade;
    private boolean energiaValidade;
    private Connector connector;

    public AddConnectorGUI(Map mapa) throws InvalidValue {
        button.setBounds(250, 150,100,20);
        button.addActionListener(this);
        label.setBounds(100,100, 100,20);
        iDconnector.setBounds(100,100, 100,20);
        fieldIdConnector.setBounds(150, 100, 100, 10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 150, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(iDconnector);
        panel.add(fieldIdConnector);
        panel.add(LatitudeConnector);
        panel.add(fieldLatitudeConnector);
        panel.add(LongitudeConnector);
        panel.add(fieldLongitudeConnector);
        panel.add(EnergiaConnector);
        panel.add(fieldIntervaloTempoConnector);
        panel.add(IntervaloTempoConnector);
        panel.add(fieldEnergiaConnector);
        panel.add(button);

        frame.setSize(500, 500);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("8210311 Daniela Moreira // 8210367 Orlando Pires");
        frame.pack();
        frame.setVisible(true);

        idConnectorValidade = validInputId(fieldIdConnector.getText(), mapa);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button) {

            latitudeValidade = validInputLatitude(Double.parseDouble(fieldLatitudeConnector.getText()));
            longitudeValidade = validInputLongitude(Double.parseDouble(fieldLongitudeConnector.getText()));
            energiaValidade = validInputEnergia(Double.parseDouble(fieldEnergiaConnector.getText()));

            if(!idConnectorValidade){
                System.out.println("O Id já existe!");
            }
            if(!latitudeValidade){
                System.out.println("A latitude só pode ter valores entre -90 e 90 graus!");
            }
            if(!longitudeValidade){
                System.out.println("A longitude só pode ter valores entre -180 e 180 graus!");
            }
            if(!energiaValidade){
                System.out.println("A energia tem de ser positiva!");
            }
            if(idConnectorValidade && latitudeValidade && longitudeValidade && energiaValidade){
                System.out.println("Connector criado com sucesso!");
                //Connector connector = new Connector();
                //Depois como é que adiciono ao mapa??? Nao posso passar pelos parametros
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
     * Metodo Valid Input Energia
     *
     * Verifica se a energia colocada no input é válida.
     * Neste caso, verifica se o valor da energia é um número positivo.
     *
     * @param energia do portal
     * @return true se for válida
     */
    public boolean validInputEnergia(double energia){
        return !(energia < 0);
    }

}
