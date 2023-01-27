package Test;

import Player.AcaoPlayer;
import Player.Connector;
import Player.Player;
import Player.Equipas;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AcaoJogadorTeste {
    AcaoPlayer acaoPlayer = new AcaoPlayer();
    Connector connector = new Connector("1", 1,1,50, 1);
    Player jogador = new Player("Daniela", Equipas.Giants, 50);
    @Test
    public void testarAcaoJogador(){
        acaoPlayer.carregarEnergia(connector, jogador);
        assertEquals(50, jogador.getEnergia());
    }
}
