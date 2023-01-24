package Player;
/**
 * @author 8210311 Daniele Moreira
 * @author 8210367 Orlando Pires
 */
public class Portal {
    private String id;
    private double latitude;
    private double longitude;
    private double energia;
    private Equipa estado;

    public Portal(String id, double latitude, double longitude, double energia, Equipa estado) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.energia = energia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public Equipa getEstado() {
        return estado;
    }

    public void setEstado(Equipa estado) {
        this.estado = estado;
    }
}
