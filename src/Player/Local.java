package Player;

public class Local {
    private int vertice;
    private Long id;
    private double latitude;
    private double longitude;
    private double energiaAtual;

    public Local(Long id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.energiaAtual = 0;
    }

    public Local(){

    }
    public int getVertice() {
        return vertice;
    }

    public void setVertice(int vertice) {
        this.vertice = vertice;
    }

    public Long getId() {
        return Long.valueOf(id);
    }

    public void setId(Long id) {
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

    public double getEnergiaAtual() {
        return energiaAtual;
    }

    public void setEnergiaAtual(double energiaAtual) {
        this.energiaAtual = energiaAtual;
    }

    public String toString(){
        return "Id: " + id + " Latitude: " + latitude + " Longitude: " + longitude + " Energia: " + energiaAtual;
    }
}
