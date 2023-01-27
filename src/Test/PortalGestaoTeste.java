package Test;

import Player.Equipas;
import Player.Player;
import Player.Portal;
import Player.PortalGestao;
import Player.Connector;
import Player.AcaoPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class PortalGestaoTeste {
    PortalGestao portalGestao = new PortalGestao();
    Connector connector = new Connector("1", 1,1,50, 0);
    AcaoPlayer acaoJogador = new AcaoPlayer();

    /**
     * Teste de verificação da neutralização de um portal
     */
    @Test
    void destruirPortaltestEstadoNull(){
        Portal portal = new Portal("0", 1,1,10, Equipas.Giants);
        Player jogador = new Player("Duarte", Equipas.Sparks);
        acaoJogador.carregarEnergia(connector, jogador);
        portalGestao.destruirPortal(portal, 10, jogador);
        assertEquals(null, portal.getEstado());
    }

    /**
     * Teste de verificação da conquista de um portal
     */
    @Test
    void destruirPortaltestEstadoSparks(){
        Portal portal = new Portal("0", 1,1,10, Equipas.Giants);
        Player jogador = new Player("Duarte", Equipas.Sparks);
        acaoJogador.carregarEnergia(connector, jogador);
        portalGestao.destruirPortal(portal, 12.5, jogador);
        assertEquals(Equipas.Sparks, portal.getEstado());
    }

    /**
     * Teste de enfraqueciemento de um portal
     * Atenção quando não existe energia suficiente para neutralizar o portal o jogador está a gastar toda a sua enrgia
     */
    @Test
    void destruirPortaltestEnfraquecer(){
        Portal portal = new Portal("0", 1,1,10, Equipas.Giants);
        Player jogador = new Player("Duarte", Equipas.Sparks);
        Connector connectorFraco = new Connector("1", 1,1,4, 0);
        acaoJogador.carregarEnergia(connectorFraco, jogador);
        portalGestao.destruirPortal(portal, 2, jogador);
        assertEquals(6, portal.getEnergiaAtual());
    }
}
