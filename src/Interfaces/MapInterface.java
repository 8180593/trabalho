package Interfaces;

import Player.Connector;
import Player.Portal;

public interface MapInterface {
    public void addProtal(Portal portal);
    public void removePortal(Portal portal);
    public void editPortal(Portal portal);
    public void removerRegistosConnector(Connector connector);
}
