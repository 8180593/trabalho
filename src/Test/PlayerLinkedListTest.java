package Test;

import Player.Equipas;
import ClassImplementation.LinkedList;
import Player.Player;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author 8210311 Daniele Moreira
 * @author 8210367 Orlando Pires
 * Classe de testes da classe LinkedList
 */
class PlayerLinkedListTest {
    /**
     * Teste de adição de um jogador à lista
     */
    @Test
     void addPlayerTest(){
        Player player = new Player("Rui", Equipas.Sparks);
        LinkedList<Player> playerLinkedList = new LinkedList<Player>();
        playerLinkedList.add(player);
        assertEquals( "Rui", playerLinkedList.get(0).getName());
    }
    /**
     * Teste de adição de dois jogadores à lista e de seguida remoção do jogador com Indice 0
     */
    @Test
    void addPlayerTest1(){
        Player player = new Player("Rui", Equipas.Sparks);
        Player player1 = new Player("Rafa", Equipas.Sparks);
        LinkedList<Player> playerLinkedList = new LinkedList();
        playerLinkedList.add(player);
        playerLinkedList.add(player1);
        playerLinkedList.remove(0);
        assertEquals("Rafa",playerLinkedList.get(0).getName());
    }
    /**
     * Teste de adição de dois jogadores à lista e verificar se o último adicionado
     * fica no fim da lista
     */
    @Test
    void addPlayerTest2(){
        Player player = new Player("Rui", Equipas.Sparks);
        Player player1 = new Player("Rafa", Equipas.Sparks);
        LinkedList<Player> playerLinkedList = new LinkedList();
        playerLinkedList.add(player);
        playerLinkedList.add(player1);
        assertEquals("Rafa",playerLinkedList.get(1).getName());
    }
}
