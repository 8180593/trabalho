package Test;

import Exceptions.InvalidValue;
import Player.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class PortalGestaoTeste {
    PortalGestao portalGestao = new PortalGestao();
    Connector connector = new Connector(1l, 1,1,50, 10);
    AcaoPlayer acaoJogador = new AcaoPlayer();

    /**
     * Teste de verificação da neutralização de um portal
     */
    @Test
    void destruirPortaltestEstadoNull(){
        Portal portal = new Portal(0l, 1,1, Equipas.Giants, 10);
        Player jogador = new Player("Duarte", Equipas.Sparks);

        portal.setEnergiaAtual(5);
        jogador.setEnergia(10.0);

        portalGestao.destruirPortal(portal, 6, jogador);

        assertEquals(portal.getEstado(), null);
        assertEquals(jogador.getEnergia(), 5);
        assertEquals(jogador.getExperiencia(), 105);
        assertEquals(jogador.getNivel(), 4);
        assertEquals(portal.getEnergiaAtual(), 0);
        assertEquals(portal.getNomeJogador(), null);
    }

    /**
     * Teste de verificação da conquista de um portal
     */
    @Test
    void destruirPortaltestEstadoSparks(){
        Portal portal = new Portal(0l, 1,1, Equipas.Giants, 10);
        Player jogador = new Player("Duarte", Equipas.Sparks);

        portal.setEnergiaAtual(5);
        jogador.setEnergia(10.0);

        portalGestao.destruirPortal(portal, 9, jogador);

        assertEquals(portal.getEstado(), Equipas.Sparks);
        assertEquals(jogador.getEnergia(), 1);
        assertEquals(jogador.getExperiencia(), 259);
        assertEquals(jogador.getNivel(), 5);
        assertEquals(portal.getEnergiaAtual(), 4);
        assertEquals(portal.getNomeJogador(), "Duarte");
    }

    /**
     * Teste de enfraqueciemento de um portal
     */
    @Test
    void destruirPortaltestEnfraquecer(){
        Portal portal = new Portal(0l, 1,1, Equipas.Giants, 10);
        Player jogador = new Player("Duarte", Equipas.Sparks);

        portal.setEnergiaAtual(5);
        jogador.setEnergia(10.0);

        portalGestao.destruirPortal(portal, 1, jogador);

        assertEquals(portal.getEstado(), Equipas.Giants);
        assertEquals(jogador.getEnergia(), 9);
        assertEquals(jogador.getExperiencia(), 1);
        assertEquals(jogador.getNivel(), 1);
        assertEquals(portal.getEnergiaAtual(), 4);
        assertEquals(portal.getNomeJogador(), null);
    }

    /**
     * Teste de fortalecimento de um portal
     * @throws InvalidValue
     */
    @Test
    void fortalecerPortalTest() throws InvalidValue {
        Portal portal = new Portal(0l, 1,1, Equipas.Giants, 10);
        Player jogador = new Player("Duarte", Equipas.Giants);

        portal.setEnergiaAtual(5);
        jogador.setEnergia(10.0);

        portalGestao.fortalecerPortal(portal, 1, jogador);

        assertEquals(portal.getEstado(), Equipas.Giants);
        assertEquals(jogador.getEnergia(), 9);
        assertEquals(jogador.getExperiencia(), 1);
        assertEquals(jogador.getNivel(), 1);
        assertEquals(portal.getEnergiaAtual(), 6);
        assertEquals(portal.getNomeJogador(), null);
    }

    /**
     * Teste de fortalecimento de um portal com energia superior a do jogador
     * @throws InvalidValue
     */
    @Test
    void fortalecerPortalTestExcecao() throws InvalidValue {
        Portal portal = new Portal(0l, 1,1,Equipas.Giants,10);
        Player jogador = new Player("Duarte", Equipas.Giants);
        Connector connectorFraco = new Connector(1l, 1,1,10,10);
        acaoJogador.carregarEnergia(connectorFraco, jogador);
        assertThrows("Não tem energia suficiente para fortalecer o portal", InvalidValue.class,()-> portalGestao.fortalecerPortal(portal,12, jogador));
    }
}
