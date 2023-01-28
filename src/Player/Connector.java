package Player;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
import ClassImplementation.LinkedQueue;

public class Connector {
    private final int vertice;
    private String id;
    private double Longitude;
    private double latitude;
    private double energia;
    private long intervaloTempo;
    private LinkedQueue<ConnectorHistorico> players;

    public Connector(String id, double longitude, double latitude, double energia, long intervaloTempo, int vertice) {
        this.id = id;
        Longitude = longitude;
        this.latitude = latitude;
        this.energia = energia;
        this.intervaloTempo = intervaloTempo;
        this.players = new LinkedQueue<>();
        this.vertice = vertice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        if(energia < 0){
            this.energia = 0.0;
        }
        this.energia = energia;
    }

    public double getIntervaloTempo() {
        return intervaloTempo;
    }

    public void setIntervaloTempo(long intervaloTempo) {
        this.intervaloTempo = intervaloTempo;
    }

    public LinkedQueue<ConnectorHistorico> getPlayers() {
        return this.players;
    }

    public void setPlayers(LinkedQueue<ConnectorHistorico> player) {
        players = player;
    }
}
