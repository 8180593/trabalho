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
    void addProtal(Portal portal);
    void removePortal(Portal portal);
    void editPortal(Portal portal, double energia) throws InvalidValue;
    void editPortal(Portal portal, double latitude, double longitude) throws InvalidValue;
    void removerRegistosConnector(Connector connector);
    void editPortal(Portal portal, Equipas estado);
}
