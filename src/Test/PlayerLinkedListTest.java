package Test;

import Player.Equipas;
import Player.Player;
import Player.PlayerLinkedList;

class PlayerLinkedListTest {
    void addPlayerTest(){
        Player player = new Player("Rui", Equipas.Sparks);
        PlayerLinkedList playerLinkedList = new PlayerLinkedList();
        playerLinkedList.addPlayer(player);
        assertEquals(playerLinkedList.getNext().getPlayer().getName(), "Rui");
    }

    void addPlayerTest(){
        Player player = new Player("Rui", Equipas.Sparks);
        PlayerLinkedList playerLinkedList = new PlayerLinkedList();
        playerLinkedList.removePlayer(player);
        assertNull(playerLinkedList.getNext().getPlayer().getName());
    }
}
