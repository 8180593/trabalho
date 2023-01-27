package Player;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class Player {
    private Double energia;
    private String name;
    private Double nivel;
    private Equipas equipa;
    //private String localAtual;
    //^ desta forma so basta uma variavel, mas perderemos tempo em pesquisa
    //alternativamente:
    //private Portal portalAtual;
    //private Connector connectorAtual;

    public Player(String name, Equipas equipa, double energia) {
        this.energia = energia;
        this.name = name;
        this.nivel = 0.0;
        this.equipa = equipa;
    }

    public Double getEnergia() {
        return energia;
    }

    public void setEnergia(Double energia) {
        if(energia < 0){
            this.energia = 0.0;
        }
        this.energia = energia;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNivel() {
        return this.nivel;
    }

    public void setNivel(Double nivel) {
        this.nivel = nivel;
    }

    public Equipas getEquipa() {
        return this.equipa;
    }

    public void setEquipa(Equipas equipa) {
        this.equipa = equipa;
    }
}
