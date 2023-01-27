package Player;

public class Registos {
    private Player jogador;
    private Acao acao;
    private double energia;

    public Registos(Player jogador, Acao acao, double energia){
        this.jogador = jogador;
        this.acao = acao;
        this.energia = energia;
    }
}
