package Test;

import Player.Equipas;
import Player.Player;
import Player.PlayerLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

class PlayerLinkedListTest {
    @Test
    void addPlayerTest(){
        Player player = new Player("Rui", Equipas.Sparks);
        PlayerLinkedList playerLinkedList = new PlayerLinkedList();
        playerLinkedList.addPlayer(player);
        assertEquals(playerLinkedList.getNext().getPlayer().getName(), "Rui");
    }
    @Test
    void addPlayerTest1(){
        Player player = new Player("Rui", Equipas.Sparks);
        PlayerLinkedList playerLinkedList = new PlayerLinkedList();
        playerLinkedList.removePlayer(player);
        assertNull(playerLinkedList.getNext().getPlayer().getName());
    }
}
