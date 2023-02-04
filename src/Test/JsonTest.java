package Test;

import ClassImplementation.LinkedList;
import Player.ConnectorHistorico;
import Player.Equipas;
import Player.Json;
import Player.Player;
import Player.Connector;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class JsonTest {
    @Test
    void testarCriarJsonConnectorHistorico() {
        Player jogador = new Player("Jogador", Equipas.Sparks);
        ConnectorHistorico connectorHistorico = new ConnectorHistorico(jogador, LocalTime.now());
        LinkedList<ConnectorHistorico> listaConnectores = new LinkedList<>();
        listaConnectores.add(connectorHistorico);
        Json json = new Json();
        json.criarJsonConnectorHistorico(listaConnectores);
    }

    @Test
    void testarCriarJsonPlayer() {
        Player jogador = new Player("Jogador", Equipas.Sparks);
        LinkedList<Player> listaJogadores = new LinkedList<>();
        listaJogadores.add(jogador);
        Json json = new Json();
        json.criarJsonPlayer(listaJogadores);
    }

    @Test
    void testarCriarJsonConnector() {
        LinkedList<Connector> listaConnectores = new LinkedList<>();
        Connector connector = new Connector("1", 1, 1, 1, 10);
        listaConnectores.add(connector);
        Json json = new Json();
        json.criarJsonConnector(listaConnectores);
    }
}
