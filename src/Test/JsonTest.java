package Test;

import ClassImplementation.LinkedList;
import Player.*;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
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
        Connector connector = new Connector(1l, 1, 1, 1, 10);
        Connector connector1 = new Connector(2l, 44,23,12,12);
        listaConnectores.add(connector);
        listaConnectores.add(connector1);
        Json json = new Json();
        json.criarJsonConnector(listaConnectores);
    }

    @Test
    void testarimportalJson() throws IOException, ParseException {
        Json json = new Json();
        json.importarJson("Map.json");
    }
}
