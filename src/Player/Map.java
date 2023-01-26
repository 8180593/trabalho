package Player;

import ClassImplementation.Network;
import Interfaces.MapInterface;
import Interfaces.NetworkADT;

/**
 *
 * @author Daniela Moreira 8210311
 * @author Orlando Pires 8210367
 */
public class Map implements MapInterface{

    private NetworkADT network = new Network();
    /**
     *
     */
    @Override
    public void addProtal(Portal portal) {
        network.addVertex(portal);
    }

    /**
     *
     */
    @Override
    public void removerRegistosConnector(Connector connector) {
        connector.setPlayers(null);
    }

    /**
     * @param portal
     */
    @Override
    public void editPortal(Portal portal){

    }

    /**
     * @param portal
     */
    @Override
    public void removePortal(Portal portal) {
        network.removeVertex(portal);
    }
}
