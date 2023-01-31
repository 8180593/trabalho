package Test;

import ClassImplementation.LinkedList;
import ClassImplementation.LinkedQueue;
import Player.Connector;
import Player.ConnectorHistorico;
import Player.Equipas;
import Player.Player;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author 8210311 Daniele Moreira
 * @author 8210367 Orlando Pires
 */
public class ConnectorTeste {
    /**
     * Teste de adicionar um jogador a um connector
     */
    @Test
    void connectorTeste() {
        Connector connector = new Connector("1", 1, 1, 1, 1,1);
        Player jogador = new Player("João", Equipas.Sparks);
        ConnectorHistorico historico = new ConnectorHistorico(jogador, LocalTime.now());
        LinkedList<ConnectorHistorico> historicoJogador = new LinkedList<>();
        historicoJogador.add(historico);
        connector.setPlayers(historicoJogador);
        assertEquals(connector.getPlayers().getFront().getElement().getPlayer(), jogador);
    }
}
