package Player;

import ClassImplementation.LinkedList;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class Equipa {
    /**
     * Equipa do jogador
     */
    private Equipas equipa;
    /**
     * Lista de jogadores pertencentes a essa equipa
     */
    private LinkedList<Player> jogadores;

    public Equipas getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipas equipa) {
        this.equipa = equipa;
    }

    public LinkedList<Player> getJogadores() {
        return jogadores;
    }

    public void setJogadores(LinkedList<Player> jogadores) {
        this.jogadores = jogadores;
    }
}
