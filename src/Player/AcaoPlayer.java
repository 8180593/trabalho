package Player;

import ClassImplementation.LinkedList;
import ClassImplementation.Node;

import java.time.Duration;
import java.time.LocalTime;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class AcaoPlayer {

    /**
     * Método Proxima Localização
     *
     * Este método permite calcular as localizações para as quais o jogador
     * pode viajar, pois encontram-se conectadas à sua localização atual.
     * Todas as que verifiquem uma aresta, serão adicionadas à linked list
     * "resultados".
     *
     * @param map o mapa em que o jogador se encontra
     * @param jogador o jogador a querer realizar uma movimentação
     * @return uma linked list com os vertices que possuem uma aresta com
     * a localização atual do jogador
     */
    public LinkedList<Integer> proximaLocalizacao(Map map, Player jogador){
        LinkedList<Integer> resultados = new LinkedList<>();

        for(int i = 0; i < map.getContadorVertices(); i++) {
            if (map.hasEdge(jogador.getIdLocalAtual(), i)) {
                resultados.add(i);
            }
        }
        return resultados;
    }

    //para rever, acho que precisa de ser feita no gui
    public void andar(Player jogador, int escolha, LinkedList<Integer> resultados){
        for (int i = 0; i < resultados.size(); i++){
            if(resultados.get(i) == escolha){
                jogador.setIdLocalAtual(escolha);
                //andou com sucesso
            }
        }
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
                    if (Duration.between(LocalTime.now(), connector.getPlayers().getFront().getElement().getData()).toMinutes() >= connector.getIntervaloTempo()) {
                        jogador.setEnergia(jogador.getEnergia() + connector.getEnergiaAtual());
                        connector.getPlayers().getFront().getElement().setData(LocalTime.now());
                    }
                }
                current = current.getNext();
                i++;
            } while (current != null);

            if(i == connector.getPlayers().size()){
                ConnectorHistorico historico = new ConnectorHistorico(jogador, LocalTime.now());
                connector.getPlayers().add(historico);

                if (Duration.between(LocalTime.now(), historico.getData()).toMinutes() >= connector.getIntervaloTempo()) {
                    jogador.setEnergia(jogador.getEnergia() + connector.getEnergiaAtual());
                }
            }
        }else{
            ConnectorHistorico historico = new ConnectorHistorico(jogador, LocalTime.now());
            connector.getPlayers().add(historico);

            if (Duration.between(LocalTime.now(), historico.getData()).toMinutes() >= connector.getIntervaloTempo()) {
                jogador.setEnergia(jogador.getEnergia() + connector.getEnergiaAtual());
            }
        }
    }
}
