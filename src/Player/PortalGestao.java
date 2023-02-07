package Player;

import Exceptions.InvalidValue;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class PortalGestao {
    private final int BONUS_NEUTRALIZAR = 100;
    private final int BONUS_CONQUISTAR = 250;
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
        double tempEnergiaSobra = energiaRetirada - portal.getEnergiaAtual();

        if(tempEnergiaSobra >= 0 && tempEnergiaSobra < portal.getEnergiaMaxima() * 0.25){
            portal.setEstado(Equipas.Neutro);
            jogador.setEnergia(jogador.getEnergia()-portal.getEnergiaAtual());

            jogador.setExperiencia(jogador.getExperiencia() + portal.getEnergiaAtual() + BONUS_NEUTRALIZAR);
            jogador.mudarProximoNivel();

            portal.setEnergiaAtual(0);
            portal.setNomeJogador(null);

            Registos registo = new Registos(jogador, Acao.NEUTRALIZOU, energiaRetirada - tempEnergiaSobra);
            portal.getRegistos().push(registo);

        }else if(tempEnergiaSobra >= 0 && tempEnergiaSobra > portal.getEnergiaMaxima() * 0.25){
            determinarEstadoConquistado(portal, tempEnergiaSobra, jogador);
            jogador.setEnergia(jogador.getEnergia() - energiaRetirada);

            jogador.setExperiencia(jogador.getExperiencia() + energiaRetirada + BONUS_CONQUISTAR);
            jogador.mudarProximoNivel();

            portal.setEstado(jogador.getEquipa());
            portal.setNomeJogador(jogador.getName());

        }else{
            portal.setEnergiaAtual(portal.getEnergiaAtual()-energiaRetirada);
            Registos registo = new Registos(jogador, Acao.ATACOU, energiaRetirada);
            portal.getRegistos().push(registo);

            jogador.setExperiencia(jogador.getExperiencia() + energiaRetirada);
            jogador.mudarProximoNivel();

            jogador.setEnergia(jogador.getEnergia() - energiaRetirada);
        }
    }

    /**
     * Se a energia doada for superior à energia do jogador, o jogador não consegue
     * Aumentar a energia do portal.
     * Criar um registo de fortalecimento do portal.
     * @param portal portal a ser fortalecido
     * @param energiaDoada energia doada pelo jogador
     * @param jogador jogador que vai doar energia
     */
    public void fortalecerPortal(Portal portal, double energiaDoada, Player jogador) throws InvalidValue {
        if(energiaDoada > jogador.getEnergia()) {
            throw new InvalidValue("Não tem energia suficiente para fortalecer o portal");
        }
        if(portal.getEnergiaAtual() == portal.getEnergiaMaxima()) {
            throw new InvalidValue("Este portal já se encontra com a capacidade máxima.");
        }

        if(portal.getEnergiaAtual() + energiaDoada > portal.getEnergiaMaxima()){
            double tempEnergiaSobra = portal.getEnergiaMaxima() - portal.getEnergiaAtual() - energiaDoada;
            portal.setEnergiaAtual(portal.getEnergiaMaxima());

            jogador.setEnergia(jogador.getEnergia() - (energiaDoada-tempEnergiaSobra));
            jogador.setExperiencia(jogador.getExperiencia() + (energiaDoada-tempEnergiaSobra));
            jogador.mudarProximoNivel();

            Registos registo = new Registos(jogador, Acao.FORTALECEU, (energiaDoada-tempEnergiaSobra));
            portal.getRegistos().push(registo);

        } else {
            portal.setEnergiaAtual(portal.getEnergiaAtual() + energiaDoada);

            jogador.setEnergia(jogador.getEnergia() - energiaDoada);
            jogador.setExperiencia(jogador.getExperiencia() + energiaDoada);
            jogador.mudarProximoNivel();

            Registos registo = new Registos(jogador, Acao.FORTALECEU, energiaDoada);
            portal.getRegistos().push(registo);
        }
    }

    /**
     * Metodo de registo de ações
     * @param portal portal a ser conquistado
     * @param energiaSobra energia a ser adicionada ao portal
     * @param jogador jogador a realizar a ação
     */
    public void determinarEstadoConquistado(Portal portal, double energiaSobra, Player jogador){
        portal.setEnergiaAtual(energiaSobra);
        Registos registo = new Registos(jogador, Acao.CONQUISTOU, energiaSobra);
        portal.getRegistos().push(registo);
    }
}
