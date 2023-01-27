package Test;

import Player.AcaoPlayer;
import Player.Connector;
import Player.Player;
import Player.Equipas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class AcaoJogadorTeste {
    AcaoPlayer acaoPlayer = new AcaoPlayer();
    Connector connector = new Connector("1", 1,1,50, 0);
    Player jogador = new Player("Daniela", Equipas.Giants);

    /**
     * Teste de carregamento de energia de um jogador
     */
    @Test
    public void testarAcaoJogador(){
        acaoPlayer.carregarEnergia(connector, jogador);
        assertEquals(50, jogador.getEnergia());
    }
    @Test
    public void andarTest(){
        acaoPlayer.andar();

    }

}
