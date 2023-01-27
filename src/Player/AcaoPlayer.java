package Player;

import ClassImplementation.Node;
import Exceptions.InvalidEnergy;

import java.time.Duration;
import java.time.LocalTime;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class AcaoPlayer {
    //O que é que os jogadores podem fazer?

    //Podem andar - uma funçao void que da set
    //Podem carregar a sua energia nos connectors
    //Podem dar energia ao seu portal
    //Podem tirar energia ao portal da outra equipa

    /**
     *
     */
    public void andar(){
        //verifica que portals/connectors tem ligação com o local atual do jogador
        //^ Este metodo se calhar ficaria bem no Map

        //da a opção para o jogador escolher o local escolhido
        //^ Este metodo se calhar ficaria bem no GUI
        //fazer o set do localAtual para esse local (atraves do id)
    }

    /**
     * Falta testar
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
                    if (Duration.between(LocalTime.now(), connector.getPlayers().getFront().getElement().getData()).toMinutes() >= connector.getIntervaloTempo()) {
                        jogador.setEnergia(jogador.getEnergia() + connector.getEnergia());
                    }
                }
                current = current.getNext();
                i++;
            } while (current != null);

            if(i == connector.getPlayers().size()){
                ConnectorHistorico historico = new ConnectorHistorico(jogador);
                connector.getPlayers().add(historico);

                if (Duration.between(LocalTime.now(), historico.getData()).toMinutes() >= connector.getIntervaloTempo()) {
                    jogador.setEnergia(jogador.getEnergia() + connector.getEnergia());
                }
            }
        }else{
            ConnectorHistorico historico = new ConnectorHistorico(jogador);
            connector.getPlayers().add(historico);

            if (Duration.between(LocalTime.now(), historico.getData()).toMinutes() >= connector.getIntervaloTempo()) {
                jogador.setEnergia(jogador.getEnergia() + connector.getEnergia());
            }
        }
    }
}
