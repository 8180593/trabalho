package GUI;
import Exceptions.InvalidValue;
import Player.Map;

import java.awt.event.ActionEvent;

/**
 * @author Daniela Moreira 8210311
 * @author Orlando Pires 8210367
 */
public class GUI{

    public static void main(String[] args) throws InvalidValue {
        Map mapa = new Map();
        AddConnectorGUI connectorGUI = new AddConnectorGUI(mapa);

    }

}