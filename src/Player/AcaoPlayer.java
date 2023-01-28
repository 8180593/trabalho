package Player;

import ClassImplementation.Network;
import ClassImplementation.Node;

import java.time.Duration;
import java.time.LocalTime;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class AcaoPlayer {

    /**
     *
     */
    public void andar(Map map, Player jogador){
        Network network = new Network();
        map.getAdjMatrix();

        //map.iteratorShortestPath(jogador.getIdLocalAtual(),);

        //verifica que portals/connectors tem ligação com o local atual do jogador
        //^ Este metodo se calhar ficaria bem no Map

        //da a opção para o jogador escolher o local escolhido
        //^ Este metodo se calhar ficaria bem no GUI
        //fazer o set do localAtual para esse local (atraves do id)
    }

    /**
     * Verifica se existe jogadores na lista de jogadores do connector
     * Caso exsitam verifica se o jogador já existe na lista
     * Se existir verifica se já passou o tempo de intervalo
     * Caso não existão adiciona o jogador e carrega a energia
     * Caso exista verifica se já passou o tempo de intervalo
     * @param connector
     * @param jogador
     */
    public void carregarEnergia(Connector connector, Player jogador) {
        Node<ConnectorHistorico> current = connector.getPlayers().getFront();
        int i = 0;
        if(current != null) {
            do {
                if (current.getElement().getPlayer() == jogador) {
                    if (Duration.between(LocalTime.now(), connector.getPlayers().first().getData()).toMinutes() >= connector.getIntervaloTempo()) {
                        jogador.setEnergia(jogador.getEnergia() + connector.getEnergia());
                    }
                }
                current = current.getNext();
                i++;
            } while (current != null);

            if(i == connector.getPlayers().size()){
                ConnectorHistorico historico = new ConnectorHistorico(jogador, LocalTime.now());
                connector.getPlayers().enqueue(historico);

                if (Duration.between(LocalTime.now(), historico.getData()).toMinutes() >= connector.getIntervaloTempo()) {
                    jogador.setEnergia(jogador.getEnergia() + connector.getEnergia());
                }
            }
        }else{
            ConnectorHistorico historico = new ConnectorHistorico(jogador, LocalTime.now());
            connector.getPlayers().enqueue(historico);

            if (Duration.between(LocalTime.now(), historico.getData()).toMinutes() >= connector.getIntervaloTempo()) {
                jogador.setEnergia(jogador.getEnergia() + connector.getEnergia());
            }
        }
    }
}
