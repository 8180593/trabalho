package Player;

import Exceptions.InvalidValue;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class PortalGestao {
    /**
     * Metodo Determinar Estado Atacado
     *
     * Quando um jogador decide atacar o portal de outra equipa, três resultados possíveis
     * podem ocorrer.
     * 1 - A energia retirada é superior ou igual ao número de energia existente
     * no portal, mas é inferior ao valor necessário para conquistar um portal.
     * Se esta situação se se verificar, o portal ficará neutro.
     * 2 - A quantidade de energia retirada é suficiente para conquistar um portal.
     * O estado do portal irá ser alterado para o mesmo da equipa do jogador.
     * 3 - A quantidade de energia retirada é inferior à energia existente no portal.
     * Ser-se-ão retirados esses pontos mas o portal continuará a pertencer à equipa oposta.
     *
     * @param portal portal a ser atacado
     * @param energiaRetirada quantidade de energia do jogador escolhida
     * @param jogador jogador a realizar o ataque
     */
    public void destruirPortal(Portal portal, double energiaRetirada, Player jogador) {
        if(energiaRetirada >= portal.getEnergiaAtual() && energiaRetirada < portal.getEnergiaAtual()*1.25){
            portal.setEstado(null);
            jogador.setEnergia(jogador.getEnergia()-portal.getEnergiaAtual());



            Registos registo = new Registos(jogador, Acao.NEUTRALIZOU, energiaRetirada);
            portal.getRegistos().push(registo);

        }else if(energiaRetirada >= portal.getEnergiaAtual() * 1.25){
            double energiaSobra = energiaRetirada - portal.getEnergiaAtual();

            determinarEstadoConquistado(portal, energiaSobra, jogador);
            jogador.setEnergia(jogador.getEnergia() - energiaRetirada);

            portal.setEstado(jogador.getEquipa());
            Registos registo = new Registos(jogador, Acao.CONQUISTOU, energiaRetirada);
            portal.getRegistos().push(registo);

        }else{
            portal.setEnergiaAtual(portal.getEnergiaAtual()-energiaRetirada);
            Registos registo = new Registos(jogador, Acao.ATACOU, energiaRetirada);
            portal.getRegistos().push(registo);

            jogador.setEnergia(jogador.getEnergia() - energiaRetirada);
        }
    }

    /**
     * Se a energia doada for superior à energia do jogador, o jogador não consegue
     * Aumentar a energia do portal.
     * Criar um registo de fortalecimento do portal.
     * @param portal
     * @param energiaDoada
     * @param jogador
     */
    public void fortalecerPortal(Portal portal, double energiaDoada, Player jogador) throws InvalidValue {
        if(energiaDoada > jogador.getEnergia()) {
            throw new InvalidValue("Não tem energia suficiente para fortalecer o portal");
        }
        portal.setEnergiaAtual(portal.getEnergiaAtual() + energiaDoada);

        Registos registo = new Registos(jogador, Acao.FORTALECEU, energiaDoada);
        portal.getRegistos().push(registo);
    }

    /**
     *
     * @param portal
     * @param energiaSobra
     * @param jogador
     */
    public void determinarEstadoConquistado(Portal portal, double energiaSobra, Player jogador){
        portal.setEnergiaAtual(energiaSobra);
        Registos registo = new Registos(jogador, Acao.CONQUISTOU, energiaSobra);
        portal.getRegistos().push(registo);
    }
}
