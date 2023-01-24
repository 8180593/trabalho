package Player;

public class Player {
    private Double energia;
    private String name;
    private Double nivel;
    private Equipas equipa;

    public Player(String name, Equipas equipa) {
        this.energia = 0.0;
        this.name = name;
        this.nivel = 0.0;
        this.equipa = equipa;
    }

    public Double getEnergia() {
        return energia;
    }

    public void setEnergia(Double energia) {
        this.energia = energia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNivel() {
        return nivel;
    }

    public void setNivel(Double nivel) {
        this.nivel = nivel;
    }

    public Equipas getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipas equipa) {
        this.equipa = equipa;
    }
}
