package Player;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class Player {
    private Double energia;
    private String name;
    private int nivel;
    private double experiencia;
    private Equipas equipa;
    private int localAtual;
    private double expParaProximoNivel;
    private final int X = 4;
    private final int Y = 2;
    private double energiaCapacidade;
    /**
     * Construtor da classe Player
     * @param name nome do jogador
     * @param equipa equipa do jogador
     */
    public Player(String name, Equipas equipa) {
        this.energia = 0.0;
        this.name = name;
        this.nivel = 1;
        this.equipa = equipa;
        this.experiencia = 0.0;
        this.expParaProximoNivel = 100;
        this.energiaCapacidade = nivel + 49;
        this.localAtual = 0;
    }
    /**
     * Construtor da classe Player
     * @param energia energia do jogador
     * @param name nome do jogador
     * @param nivel nivel do jogador
     * @param experiencia experiencia do jogador
     * @param equipa equipa do jogador
     */
    public Player(Double energia, String name, int nivel, double experiencia, Equipas equipa) {
        this.energia = energia;
        this.name = name;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.equipa = equipa;
        this.expParaProximoNivel = 100;
        this.energiaCapacidade = nivel + 49;
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

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getExperiencia(){ return this.experiencia; }

    public void setExperiencia(double experiencia){ this.experiencia = experiencia; }

    public double getExpParaProximoNivel(){ return this.expParaProximoNivel;}

    public void setExpParaProximoNivel(double expParaProximoNivel){ this.expParaProximoNivel = expParaProximoNivel; }

    public Equipas getEquipa() {
        return this.equipa;
    }

    public void setEquipa(Equipas equipa) {
        this.equipa = equipa;
    }

    public int getLocalAtual() {
        return localAtual;
    }

    public void setLocalAtual(int localAtual) {
        this.localAtual = localAtual;
    }

    /**
     * Metodo para mudar o jogador para o proximo nivel
     * Este metodo verifica se o jogador tem a experiencia necessaria para subir de nivel
     */
    public void mudarProximoNivel(){
        while(getExperiencia() > getExpParaProximoNivel()){
            int tempNivel = getNivel();
            tempNivel++;
            setNivel(tempNivel);

            double tempExp = getExpParaProximoNivel();
            tempExp += tempExp * Math.pow((tempNivel/X), Y);

            setExpParaProximoNivel(tempExp);
        }
    }

    public double getEnergiaCapacidade() {
        return energiaCapacidade;
    }
}
