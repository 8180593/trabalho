package Player;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
import java.time.LocalDate;

public class ConnectorHistorico {
    private Player player;
    private LocalDate data = LocalDate.now();

    public ConnectorHistorico(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public LocalDate getData() {
        return data;
    }
}
