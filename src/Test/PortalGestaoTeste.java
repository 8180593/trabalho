package Test;

import Exceptions.InvalidValue;
import Player.Equipas;
import Player.Player;
import Player.Portal;
import Player.PortalGestao;
import Player.Connector;
import Player.AcaoPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class PortalGestaoTeste {
    PortalGestao portalGestao = new PortalGestao();
    Connector connector = new Connector("1", 1,1,50, 0, 1);
    AcaoPlayer acaoJogador = new AcaoPlayer();

    /**
     * Teste de verificação da neutralização de um portal
     */
    @Test
    void destruirPortaltestEstadoNull(){
        Portal portal = new Portal("0", 1,1,10, Equipas.Giants, 1);
        Player jogador = new Player("Duarte", Equipas.Sparks);
        acaoJogador.carregarEnergia(connector, jogador);
        portalGestao.destruirPortal(portal, 10, jogador);
        assertNull(portal.getEstado());
    }

    /**
     * Teste de verificação da conquista de um portal
     */
    @Test
    void destruirPortaltestEstadoSparks(){
        Portal portal = new Portal("0", 1,1,10, Equipas.Giants,1);
        Player jogador = new Player("Duarte", Equipas.Sparks);
        acaoJogador.carregarEnergia(connector, jogador);
        portalGestao.destruirPortal(portal, 12.5, jogador);
        assertEquals(Equipas.Sparks, portal.getEstado());
    }

    /**
     * Teste de enfraqueciemento de um portal
     */
    @Test
    void destruirPortaltestEnfraquecer(){
        Portal portal = new Portal("0", 1,1,10, Equipas.Giants,1);
        Player jogador = new Player("Duarte", Equipas.Sparks);
        Connector connectorFraco = new Connector("1", 1,1,10, 0,1);
        acaoJogador.carregarEnergia(connectorFraco, jogador);
        portalGestao.destruirPortal(portal, 2, jogador);
        assertEquals(8, portal.getEnergiaAtual());
    }

    /**
     * Teste de fortalecimento de um portal
     * @throws InvalidValue
     */
    @Test
    void fortalecerPortalTest() throws InvalidValue {
        Portal portal = new Portal("0", 1,1,10, Equipas.Giants,1);
        Player jogador = new Player("Duarte", Equipas.Giants);
        Connector connectorFraco = new Connector("1", 1,1,10, 0,1);
        acaoJogador.carregarEnergia(connectorFraco, jogador);
        portalGestao.fortalecerPortal(portal,2, jogador);
        assertEquals(12, portal.getEnergiaAtual());
    }
    /**
     * Teste de fortalecimento de um portal com energia superior a do jogador
     * @throws InvalidValue
     */
    @Test
    void fortalecerPortalTestExcecao() throws InvalidValue {
        Portal portal = new Portal("0", 1,1,10, Equipas.Giants,1);
        Player jogador = new Player("Duarte", Equipas.Giants);
        Connector connectorFraco = new Connector("1", 1,1,10, 0,1);
        acaoJogador.carregarEnergia(connectorFraco, jogador);
        assertThrows("Não tem energia suficiente para fortalecer o portal", InvalidValue.class,()-> portalGestao.fortalecerPortal(portal,12, jogador));
    }
}
