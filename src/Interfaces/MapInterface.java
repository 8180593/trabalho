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
    void addLocal(Portal portal);
    void removeLocal(Portal portal);
    void editLocal(Portal portal, double energia) throws InvalidValue;
    void editLocal(Portal portal, double latitude, double longitude) throws InvalidValue;
    void editLocal(Portal portal, Equipas estado);

    void addLocal(Connector connector);
    void editLocal(Connector connector, double energia) throws InvalidValue;
    void editLocal(Connector connector, double latitude, double longitude) throws InvalidValue;
    void removeLocal(Connector connector);
}
