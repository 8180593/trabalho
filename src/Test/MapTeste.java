package Test;

import Exceptions.InvalidValue;
import Player.Equipas;
import Player.AcaoPlayer;
import Player.Map;
import Player.Portal;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class MapTeste {
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
    }*/

    /**
     * Teste de edição de um portal
     * Alteração da latitude de 1 para 2
     */
    @Test
    void edtiProtalTestPass() throws InvalidValue {
        Portal portal =new Portal(1l, 1,1, Equipas.Sparks, 1);
        mapa.editLocal(portal, 2, 1);
        assertEquals(2, portal.getLatitude());
    }

    /**
     * Teste de edição de um portal
     * Forçar o metodo a lançar a exceção por causa da latitude
     */
    @Test
    void EditPortalTestFailLatitudeInferior() throws InvalidValue {
        Portal portal =new Portal(1l, 1,1, Equipas.Sparks, 1);
        assertThrows("Latitude fora dos limites", InvalidValue.class, () -> {
            mapa.editLocal(portal, -91, 1);
        });
    }

    /**
     * Teste de edição de um portal
     * Forçar o metodo a lançar a exceção por causa da latitude
     */
    @Test
    void EditPortalTestFailLatitudeSuperior() throws InvalidValue {
        Portal portal =new Portal(1l, 1,1, Equipas.Sparks, 1);
        assertThrows("Latitude fora dos limites", InvalidValue.class, () -> {
            mapa.editLocal(portal, 91, 1);
        });
    }

    /**
     * Teste de edição de um portal
     * Forçar o metodo a lançar a exceção por causa da longitude
     */
    @Test
    void EditPortalTestFailLongitudeInferior() throws InvalidValue {
        Portal portal =new Portal(1l, 1,1, Equipas.Sparks, 1);
        assertThrows("Longitude fora dos limites", InvalidValue.class, () -> {
            mapa.editLocal(portal, 1, -181);
        });
    }

    /**
     * Teste de edição de um portal
     * Forçar o metodo a lançar a exceção por causa da longitude
     */
    @Test
    void EditPortalTestFailLongitudeSuperior() throws InvalidValue {
        Portal portal =new Portal(1l, 1,1, Equipas.Sparks, 1);
        assertThrows("Longitude fora dos limites", InvalidValue.class, () -> {
            mapa.editLocal(portal, 1, 181);
        });
    }

    /**
     * Teste de edição de um portal
     * Alteração da Energia de 1 para 2
     */
    @Test
    void EditPortalEnergyTest() throws InvalidValue {
        Portal portal =new Portal(1l, 1,1, Equipas.Sparks, 1);
        mapa.editLocal(portal, 2);
        assertEquals(2, portal.getEnergiaAtual());
    }

    /**
     * Teste de edição de um portal
     * Forçar o metodo a lançar a exceção por causa da energia
     */
    @Test
    void EditPortalEnergyTestFail() throws InvalidValue {
        Portal portal =new Portal(1l, 1,1, Equipas.Sparks, 1);
        assertThrows("Energia fora dos limites", InvalidValue.class, () -> {
            mapa.editLocal(portal, -1);
        });
    }
}
