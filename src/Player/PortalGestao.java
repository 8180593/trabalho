package Player;

public class PortalGestao {
    /**
     * Metodo Mais de Um Quarto
     *
     * Calcula se o jogador possui energia suficiente para conquistar
     * @param portal
     * @return
     */
    public double maisUmQuarto(Portal portal, double energiaRetirada){
        double energiaRestante = portal.getEnergiaAtual() - energiaRetirada;
        Math.abs(energiaRestante);

        if(energiaRestante >= (portal.getEnergiaTotal() * 0.25)){
            return energiaRestante;
        }
        return 0;
    }

    public double determinarEstadoAtacado(Portal portal, double energiaRetirada, Player jogador) {
        double energiaRetirarJogador = 0;
        //o numero de energia realmente gasta pelo jogador

        if(energiaRetirada == portal.getEnergiaAtual() || maisUmQuarto(portal, energiaRetirada) == 0){
            portal.setEstado(null);
            Registos registo = new Registos(jogador, Acao.NEUTRALIZOU, energiaRetirada);

            return energiaRetirarJogador = portal.getEnergiaAtual());

        }else if(maisUmQuarto(portal, energiaRetirada) > 0){
            determinarEstadoConquistado(portal, maisUmQuarto(portal, energiaRetirada), jogador);
            //envia o que sobra da energiaRetirada;
            jogador.setEnergia(jogador.getEnergia() - energiaRetirada);

            return energiaRetirarJogador = energiaRetirada;

        }else{
            portal.setEnergiaAtual(portal.getEnergiaAtual()-jogador.getEnergia());
            Registos registo = new Registos(jogador, Acao.ATACOU, energiaRetirada);

            return energiaRetirarJogador = energiaRetirada;
        }
    }

    public void determinarEstadoFortelacido(Portal portal, double energiaDoada, Player jogador){
        //se tivermos limites de torre, temos que retomar o valor que sobra.
        portal.setEnergiaAtual(portal.getEnergiaAtual() + energiaDoada);

        Registos registo = new Registos(jogador, Acao.FORTALECEU, energiaDoada);
        portal.getRegistos().add(registo);
    }

    public void determinarEstadoConquistado(Portal portal, double energiaSobra, Player jogador){
        portal.setEnergiaAtual(energiaSobra);
        Registos registo = new Registos(jogador, Acao.CONQUISTOU, energiaSobra);
        portal.getRegistos().add(registo);
    }
}
