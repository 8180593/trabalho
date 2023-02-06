package GUI;

import Player.Map;

import javax.swing.*;
import java.awt.*;

public class DrawMap extends JPanel {
    //ideia
    //entao temos as coordenadas a ir de -90 a 90
    //e a -180 a 180
    //se fizermos uma "janela" com tamanho 180 a 360, podemos fazer cada ponto a ser um local
    //no caso de uma ligacao ser efetuada, faz se uma linha desse ponto ao outro

    DrawMap(){
        this.setPreferredSize(new Dimension(180,360));
    }

    public void paint (Graphics graphic, Map map){
        Graphics2D graphic2D = (Graphics2D) graphic;
        int tempLatitude1;
        int tempLongitude1;
        int tempLatitude2;
        int tempLongitude2;

        for(int i = 0; i < map.getLocais().size(); i++){
            tempLatitude1 = (int) map.getLocais().get(i).getLatitude() + 90;
            tempLongitude1 = (int) map.getLocais().get(i).getLongitude() + 180;

            graphic2D.setPaint(Color.blue);
            graphic2D.drawOval(tempLatitude1, tempLongitude1, 2,2);

            for(int j = i; j < map.getLocais().size() - 1; j++){
                if(map.getNetwork().hasEdge(i,j)){

                    tempLatitude2 = (int) map.getLocais().get(j).getLatitude() + 90;
                    tempLongitude2 = (int) map.getLocais().get(j).getLongitude() + 180;

                    graphic2D.setPaint(Color.black);
                    graphic2D.drawLine(tempLatitude1,tempLongitude1,tempLatitude2,tempLongitude2);
                }
            }
        }
    }
}