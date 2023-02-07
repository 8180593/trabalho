package Player;

import ClassImplementation.LinkedStack;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class Portal extends Local{
    private Equipas estado;
    private double energiaMaxima;//energia maxima
    private final LinkedStack<Registos> registos;
    private String nomePortal;


    public Portal(long id, double latitude, double longitude, Equipas estado, double energiaMaxima) {
        super(id, latitude, longitude);
        this.estado = estado;
        this.energiaMaxima = energiaMaxima;
        this.nomePortal = null;
        this.registos = new LinkedStack<Registos>();
    }

    public Portal(long id, double latitude, double longitude, Equipas estado, double energiaMaxima, String nomeJogador, double energia) {
        super(id, latitude, longitude, energia);
        this.estado = estado;
        this.energiaMaxima = energiaMaxima;
        this.nomePortal = nomeJogador;
        this.registos = new LinkedStack<Registos>();
    }

    public LinkedStack<Registos> getRegistos() {
        return this.registos;
    }

    public double getEnergiaMaxima() {
        return this.energiaMaxima;
    }

    public void setEnergiaMaxima(double energiaMaxima) {
        this.energiaMaxima = energiaMaxima;
    }

    public Equipas getEstado() {
        return this.estado;
    }

    public void setEstado(Equipas estado) {
        this.estado = estado;
    }

    public String getNomeJogador() {
        return this.nomePortal;
    }

    public void setNomeJogador(String nomePortal) {
        this.nomePortal = nomePortal;
    }

}
