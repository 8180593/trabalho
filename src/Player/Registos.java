package Player;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class Registos {
    private Player jogador;
    private Acao acao;
    private double energia;

    /**
     * Construtor da classe Registos
     * @param jogador jogador que realizou a acao
     * @param acao acao realizada
     * @param energia energia do jogador
     */
    public Registos(Player jogador, Acao acao, double energia){
        this.jogador = jogador;
        this.acao = acao;
        this.energia = energia;
    }
}
