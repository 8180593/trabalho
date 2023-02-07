package Player;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */

/**
 * Classe que representa um local, este local pode dar origem a um Connector ou a um Portal
 */
public class Local {
    private int vertice;
    private Long id;
    private double latitude;
    private double longitude;
    private double energiaAtual;
    /**
     * Construtor da classe Local
     * @param id id do local
     * @param latitude latitude do local
     * @param longitude longitude do local
     */
    public Local(Long id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.energiaAtual = 0;
    }
    /**
     * Construtor da classe Local
     * @param id id do local
     * @param latitude latitude do local
     * @param longitude longitude do local
     * @param energiaAtual energia atual do local
     */
    public Local(Long id, double latitude, double longitude, double energiaAtual) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.energiaAtual = energiaAtual;
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
