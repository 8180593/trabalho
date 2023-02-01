package Player;

import ClassImplementation.LinkedStack;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class Portal extends Local{
    private Equipas estado;
    private double energiaMaxima;//energia maxima
    private final LinkedStack<Registos> registos = null;
    private String nomeJogador;


    public Portal(String id, double latitude, double longitude, Equipas estado, double energiaMaxima) {
        super(id, latitude, longitude);
        this.estado = estado;
        this.energiaMaxima = energiaMaxima;
        this.nomeJogador = null;
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
        return this.nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

}
