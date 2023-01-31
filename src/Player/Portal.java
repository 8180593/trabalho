package Player;

import ClassImplementation.LinkedStack;
import java.util.UUID;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class Portal {
    private final int vertice;
    private String id;
    private double latitude;
    private double longitude;
    private double energiaAtual;
    private Equipas estado;
    private double energiaTotal;
    private final LinkedStack<Registos> registos;

    /**
     *
     * @param id
     * @param latitude
     * @param longitude
     * @param energiaTotal
     * @param estado
     */
    public Portal(String id, double latitude, double longitude, double energiaTotal, Equipas estado, int vertice) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.energiaTotal = energiaTotal;
        this.estado = estado;
        this.registos = new LinkedStack<Registos>();
        this.vertice = vertice;
    }

    public LinkedStack<Registos> getRegistos() {
        return registos;
    }

    public double getEnergiaTotal() {
        return energiaTotal;
    }

    public void setEnergiaTotal(double energiaTotal) {
        this.energiaTotal = energiaTotal;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getEnergiaAtual() {
        return this.energiaAtual;
    }

    public void setEnergiaAtual(double energia) {
        this.energiaAtual = energia;
    }

    public Equipas getEstado() {
        return this.estado;
    }

    public void setEstado(Equipas estado) {
        this.estado = estado;
    }
}
