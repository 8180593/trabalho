package Player;

import ClassImplementation.*;
import Exceptions.InvalidValue;
import Interfaces.MapInterface;
import Interfaces.NetworkADT;

/**
 *
 * @author Daniela Moreira 8210311
 * @author Orlando Pires 8210367
 */
public class Map extends Network<String> implements MapInterface{
    private static int contadorVertices;
    private Network<Local> network;
    private LinkedList<Local> locais;

    public Map(){
        this.contadorVertices = 0;
        this.network = new Network<Local>();
        this.locais = new LinkedList<Local>();
    }

    public LinkedList<Local> getLocais() {
        return locais;
    }

    public Network<Local> getNetwork() {
        return network;
    }

    public int getContadorVertices(){
        return contadorVertices;
    }

    /**
     * Adicionar um portal ao mapa
     * @param portal novo portal a ser adicionado
     */
    @Override
    public void addLocal(Portal portal) {
        network.addVertex(portal);
        locais.add(portal);
        contadorVertices++;
    }

    @Override
    public void addLocal(Connector connector) {
        network.addVertex(connector);
        locais.add(connector);
        contadorVertices++;
    }

    /**
     *  Editar a localização de um portal
     *  1-Verifica se a latitude e longitude estão dentro dos limites, caso não estjam lança uma exceção
     * @param portal portal a ser alterado
     * @param latitude latitude a ser alterada
     * @param longitude longitude a ser alterada
     * @throws InvalidValue exceção retornada quando o valor e invalido
     */
    @Override
    public void editLocal(Portal portal, double latitude, double longitude) throws InvalidValue {
        if(latitude < -90 || latitude > 90)
            throw new InvalidValue("Latitude fora dos limites");
        else
            portal.setLatitude(latitude);
        if(longitude < -180 || longitude > 180)
            throw new InvalidValue("Longitude fora dos limites");
        else
            portal.setLongitude(longitude);
   }
    /**
     * Editar o nível de energia de um portal
     * @param portal portal a ser editado
     * @param energia nova energia do portal
     */
    @Override
    public void editLocal(Portal portal, double energia) throws InvalidValue{
        if(energia >= 0)
            portal.setEnergiaAtual(energia);
        else
            throw new InvalidValue("Energia não pode ser negativa");
    }
    /**
     * Editar o estado de um portal
     * @param portal portal a ser editado
     * @param estado novo estado do portal
     */
    @Override
    public void editLocal(Portal portal, Equipas estado){
        portal.setEstado(estado);
    }

    /**
     * Remover um portal
     * @param portal portal a ser leminado
     */
    @Override
    public void removeLocal(Portal portal) {
        network.removeVertex(portal);
    }

    @Override
    public void removeLocal(Connector connector) {
        network.removeVertex(connector);
    }

    /**
     *
     * @param connector
     * @param energia
     * @throws InvalidValue
     */
    @Override
    public void editLocal(Connector connector, double energia) throws InvalidValue{
        if(energia >= 0)
            connector.setEnergiaAtual(energia);
        else
            throw new InvalidValue("Energia não pode ser negativa");
    }

    /**
     * @param connector
     * @param latitude
     * @param longitude
     * @throws InvalidValue
     */
    @Override
    public void editLocal(Connector connector, double latitude, double longitude) throws InvalidValue{
        if(latitude < -90 || latitude > 90)
            throw new InvalidValue("Latitude fora dos limites");
        else
            connector.setLatitude(latitude);
        if(longitude < -180 || longitude > 180)
            throw new InvalidValue("Longitude fora dos limites");
        else
            connector.setLongitude(longitude);
    }
}
