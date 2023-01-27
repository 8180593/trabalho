package Player;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
import java.time.LocalTime;

/**
 *
 */
public class ConnectorHistorico {
    private Player player;
    private LocalTime data = LocalTime.now();

    public ConnectorHistorico(Player player, LocalTime data) {
        this.player = player;
        this.data = data;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public LocalTime getData() {
        return data;
    }

    public void setData(LocalTime data) {
        this.data = data;
    }
}
