package Player;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class Registos {
    private final Player jogador;
    private final Acao acao;
    private final double energia;

    /**
     *
     * @param jogador
     * @param acao
     * @param energia
     */
    public Registos(Player jogador, Acao acao, double energia){
        this.jogador = jogador;
        this.acao = acao;
        this.energia = energia;
    }
}
