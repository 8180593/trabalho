package Player;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */

import ClassImplementation.LinkedList;

public class Connector extends Local{
    private long intervaloTempo;
    private LinkedList<ConnectorHistorico> players;

    public Connector(String id, double latitude, double longitude, long intervaloTempo) {
        super(id, latitude, longitude);
        this.intervaloTempo = intervaloTempo;
        this.players = new LinkedList<>();
    }

    public double getIntervaloTempo() {
        return intervaloTempo;
    }

    public void setIntervaloTempo(long intervaloTempo) {
        this.intervaloTempo = intervaloTempo;
    }

    public LinkedList<ConnectorHistorico> getPlayers() {
        return this.players;
    }

    public void setPlayers(LinkedList<ConnectorHistorico> player) {
        players = player;
    }
}
