package Test;

import Player.Player;
import Player.Equipas;
import Player.AcaoPlayer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class PlayerTest {
    private AcaoPlayer acaoJogador = new AcaoPlayer();

    /**
     * Teste de mudança de nível
     * 1 nível
     */
    @Test
    void mudarProximoNivelTest(){
        Player jogador = new Player("Daniela", Equipas.Sparks);
        jogador.setExperiencia(105);
        jogador.mudarProximoNivel();
        assertEquals(2, jogador.getNivel());
    }

     @Test
    void mudarProximoNivelFail(){
        Player jogador = new Player("Daniela", Equipas.Sparks);
        jogador.mudarProximoNivel();
        assertEquals(1, jogador.getNivel());
     }
}
