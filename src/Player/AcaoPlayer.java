package Player;

import Exceptions.InvalidEnergy;
import ClassImplementation.Node;

import java.time.Duration;
import java.time.LocalTime;

public class AcaoPlayer {
    //O que é que os jogadores podem fazer?

    //Podem andar - uma funçao void que da set
    //Podem carregar a sua energia nos connectors
    //Podem dar energia ao seu portal
    //Podem tirar energia ao portal da outra equipa

    public void andar(){
        //verifica que portals/connectors tem ligação com o local atual do jogador
        //^ Este metodo se calhar ficaria bem no Map

        //da a opção para o jogador escolher o local escolhido
        //^ Este metodo se calhar ficaria bem no GUI
        //fazer o set do localAtual para esse local (atraves do id)
    }

    public void carregarEnergia(Connector connector, Player jogador) {
        Node<ConnectorHistorico> current = connector.getPlayers().getFront();
        do{
            if(current.getElement().getPlayer() == jogador){
                if(Duration.between(LocalTime.now(), connector.getPlayers().getFront().getElement().getData()).toMinutes() >= connector.getIntervaloTempo()) {
                    jogador.setEnergia(jogador.getEnergia() + connector.getEnergia());
                }
            }
            current = current.getNext();
        }while(current != null);
    }

    public void fortificarPortal(Portal portal, float energia, Player jogador) throws InvalidEnergy{
        //permite ao jogador escolher se deseja carregar energia (assumindo que se encontra num seu Portal)
        //ter cuidado com a quantidade da energia doada para não ser superior à existente
        //^ Este metodo se calhar ficaria bem no GUI

        //fazer set da energia (energia - energiaDoada)
        //fazer set da energia do portal (energia + energiaDoada)

        //Talvez aqui ficaria a invocação do método da classe Portal
        if(energia > 0)
            portal.setEnergiaAtual(portal.getEnergiaAtual() + energia);
        else
            throw new InvalidEnergy("O valor da energia tem de ser positivo");

    }

    public void destruirPortal(Portal portal, float energia, Player jogador) throws InvalidEnergy{
        //permite ao jogador escolher se deseja descarregar energia (assumindo que se encontra num Portal enimigo)
        //ter cuidado com a quantidade da energia usada para não ser superior à existente
        //^ Este metodo se calhar ficaria bem no GUI

        //invocar o método determinarEstado(portal, energiaUsada, equipa);
        //fazer set da energia (energia - energiaUsada)
        PortalGestao portalGestao = new PortalGestao();
        double energiaSobra = portalGestao.determinarEstadoAtacado(portal, energia, jogador);


        if(energia > 0)
            portal.setEnergiaAtual(portal.getEnergiaAtual() + energia);
        else
            throw new InvalidEnergy("O valor da energia tem de ser positivo");
    }

    public void conquistarPortal(){
        //este é so quando o portal esta neutro
        //chamar a função que verifica se tem pelo meno 0.25 do total do portal
    }
}
