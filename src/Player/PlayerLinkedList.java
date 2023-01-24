package Player;

public class PlayerLinkedList {
    private PlayerLinkedList next;
    private PlayerLinkedList prev;
    private Player player;

    public PlayerLinkedList getNext() {
        return next;
    }

    public void setNext(PlayerLinkedList next) {
        this.next = next;
    }

    public PlayerLinkedList getPrev() {
        return prev;
    }

    public void setPrev(PlayerLinkedList prev) {
        this.prev = prev;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addPlayer(Player player) {
        if (this.next == null) {
            this.next = new PlayerLinkedList();
            this.next.setPrev(this);
        } else {
            this.next.addPlayer(player);
        }
    }

    public void removePlayer(Player player) {
        if (this.next != null) {
            if (this.next.getPlayer().getName().equals(player.getName())) {
                this.next = this.next.getNext();
                this.next.setPrev(this);
            } else {
                this.next.removePlayer(player);
            }
        }
    }

    public void removePlayer(String name) {
        if (this.next != null) {
            if (this.next.getPlayer().getName().equals(name)) {
                this.next = this.next.getNext();
                this.next.setPrev(this);
            } else {
                this.next.removePlayer(name);
            }
        }
    }
}
