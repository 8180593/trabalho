package Player;
/**
 * @author 8210311 Daniele Moreira
 * @author 8210367 Orlando Pires
 */
import ClassImplementation.LinkedList;

public class Connector {
    private String id;
    private double Longitude;
    private double latitude;
    private double energia;
    private double intervaloTempo;
    private LinkedList<ConnectorHistorico> players;

    public Connector(String id, double longitude, double latitude, double energia, double intervaloEnergia) {
        this.id = id;
        Longitude = longitude;
        this.latitude = latitude;
        this.energia = energia;
        this.intervaloTempo = intervaloTempo;
        this.players = new LinkedList<>();
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

    public void setIntervaloTempo(double intervaloTempo) {
        this.intervaloTempo = intervaloTempo;
    }

    public LinkedList<ConnectorHistorico> getPlayers() {
        return players;
    }

    public void setPlayers(ConnectorHistorico player) {
        players.add(player);
    }
}
