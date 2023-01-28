package Test;

import Player.Player;
import Player.Equipas;
import Player.Connector;
import Player.AcaoPlayer;
import Player.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**public class MapTeste {
    AcaoPlayer acaoJogador = new AcaoPlayer();
    Map mapa = new Map();

    /**
     * Teste de remoção de registos de um connector
     * 1 jogador
     */
    /**@Test
    void RemoverRegistosConnector(){
        Player jogador = new Player("Orlando", Equipas.Sparks);
        Connector connector = new Connector("1", 1,1,50, 1,1);
        acaoJogador.carregarEnergia(connector, jogador);
        acaoJogador.carregarEnergia(connector, jogador);
        mapa.removerRegistosConnector(connector);
        assertEquals(1, connector.getPlayers().size());
    }
    /**
     * Teste de remoção de registos de um connector
     * 2 jogadores
     * da 3 ao inves de 2
     */
    /**@Test
    void RemoverRegistosConnector2jogadores(){
        Player jogador = new Player("Orlando", Equipas.Sparks);
        Player jogador2 = new Player("Daniela", Equipas.Giants);
        Connector connector = new Connector("1", 1,1,50, 1,1);
        acaoJogador.carregarEnergia(connector, jogador);
        acaoJogador.carregarEnergia(connector, jogador2);
        acaoJogador.carregarEnergia(connector, jogador);
        mapa.removerRegistosConnector(connector);
        assertEquals(2, connector.getPlayers().size());
    }
}*/
