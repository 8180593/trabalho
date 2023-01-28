package Interfaces;

import Exceptions.InvalidValue;
import Player.Connector;
import Player.Equipas;
import Player.Portal;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public interface MapInterface {
    public void addProtal(Portal portal);
    public void removePortal(Portal portal);
    public void editPortal(Portal portal, double energia) throws InvalidValue;
    public void editPortal(Portal portal, double latitude, double longitude) throws InvalidValue;
    public void removerRegistosConnector(Connector connector);
    public void editPortal(Portal portal, Equipas estado);
}
