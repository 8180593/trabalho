package Test;

import Player.Equipas;
import ClassImplementation.LinkedList;
import Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerLinkedListTest {
    @Test
     void addPlayerTest(){
        Player player = new Player("Rui", Equipas.Sparks);
        LinkedList<Player> playerLinkedList = new LinkedList<Player>();
        playerLinkedList.add(player);
        assertEquals( "Rui", playerLinkedList.get(0).getName());
    }
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
}
