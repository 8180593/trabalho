package Test;

import Player.AcaoPlayer;
import Player.Connector;
import Player.Player;
import Player.Equipas;
import Player.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class AcaoJogadorTeste {
    AcaoPlayer acaoPlayer = new AcaoPlayer();
    Connector connector = new Connector("1", 1,1,1);
    Player jogador = new Player("Daniela", Equipas.Giants);
    Map mapa = new Map();

    /**
     * Teste de carregamento de energia de um jogador
     */
    @Test
    public void testarAcaoJogador(){
        acaoPlayer.carregarEnergia(connector, jogador);
        assertEquals(50, jogador.getEnergia());
    }
    /**@Test
    public void andarTest(){
        acaoPlayer.andar();

    }*/

    @Test
    void proximaLocalizacaoTest(){
        acaoPlayer.proximaLocalizacao(mapa, jogador);
    }
}
