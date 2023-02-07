package GUI;
import Exceptions.InvalidValue;
import Player.Map;


/**
 * @author Daniela Moreira 8210311
 * @author Orlando Pires 8210367
 */
public class GUI{

    public static void main(String[] args) throws InvalidValue {
        Map mapa = new Map();
        EditMapGUI editMapGUI = new EditMapGUI(mapa);
    }

}