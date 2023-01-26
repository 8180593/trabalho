package Interfaces;

import Player.Connector;
import Player.Equipa;
import Player.Portal;

public interface MapInterface {
    public void addProtal(Portal portal);
    public void removePortal(Portal portal);
    public void editPortal(Portal portal, double energia);
    public void editPortal(Portal portal, double latitude, double longitude);
    public void removerRegistosConnector(Connector connector);
    public void editPortal(Portal portal, Equipa estado);
}
