package Player;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class Player {
    private Double energia;
    private String name;
    private Double nivel;
    private Equipas equipa;
    //private String localAtual;
    //^ desta forma so basta uma variavel, mas perderemos tempo em pesquisa
    //alternativamente:
    //private Portal portalAtual;
    //private Connector connectorAtual;

    public Player(String name, Equipas equipa) {
        this.energia = 0.0;
        this.name = name;
        this.nivel = 0.0;
        this.equipa = equipa;
    }

    public Double getEnergia() {
        return energia;
    }

    public void setEnergia(Double energia) {
        if(energia < 0){
            this.energia = 0.0;
        }
        this.energia = energia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNivel() {
        return nivel;
    }

    public void setNivel(Double nivel) {
        this.nivel = nivel;
    }

    public Equipas getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipas equipa) {
        this.equipa = equipa;
    }

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

    public void carregarEnergia(Connector connector){
        //permite ao jogador escolher se deseja carregar energia (assumindo que se encontra num connector)
        //^ Este metodo se calhar ficaria bem no GUI

        //verifica o cooldown do connector
        //^ Este metodo se calhar ficaria bem no Connector

        //fazer set da energia (ter talvez atenção à capacidade maxima de energia que pode armazenar)
    }

    public void fortificarPortal(Portal portal){
        //permite ao jogador escolher se deseja carregar energia (assumindo que se encontra num seu Portal)
        //ter cuidado com a quantidade da energia doada para não ser superior à existente
        //^ Este metodo se calhar ficaria bem no GUI

        //fazer set da energia (energia - energiaDoada)
        //fazer set da energia do portal (energia + energiaDoada)

        //Talvez aqui ficaria a invocação do método da classe Portal
    }

    public void destruirPortal(Portal portal){
        //permite ao jogador escolher se deseja descarregar energia (assumindo que se encontra num Portal enimigo)
        //ter cuidado com a quantidade da energia usada para não ser superior à existente
        //^ Este metodo se calhar ficaria bem no GUI

        //invocar o método determinarEstado(portal, energiaUsada, equipa);
        //fazer set da energia (energia - energiaUsada)
    }
}
