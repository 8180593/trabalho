package Player;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */

import ClassImplementation.LinkedList;
/**
 * Classe que representa um Connector
 */
public class Connector extends Local{
    private long intervaloTempo;
    private LinkedList<ConnectorHistorico> players;
    /**
     * Construtor de um Connector
     * @param id id do Connector
     * @param latitude latitude do Connector
     * @param longitude longitude do Connector
     * @param intervaloTempo intervalo de tempo do Connector
     * @param energia energia do Connector
     */
    public Connector(Long id, double latitude, double longitude, long intervaloTempo, double energia) {
        super(id, latitude, longitude, energia);
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
