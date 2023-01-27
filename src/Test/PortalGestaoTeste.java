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
     * Teste de verificação de conquista do portal
     * Teste falhado não muda a equipa do portal
     */
    @Test
    void destruirPortaltest(){
        Portal portal = new Portal("0", 1,1,10, Equipas.Giants);
        Player jogador = new Player("Duarte", Equipas.Sparks);
        acaoJogador.carregarEnergia(connector, jogador);
        portalGestao.destruirPortal(portal, 0, jogador);
        //assertEquals(50, jogador.getEnergia()); O jogador fica com 50 de energia
        assertEquals(Equipas.Sparks, portal.getEstado());
    }
}
