package Player;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public class Portal {
    private String id;
    private double latitude;
    private double longitude;
    private double energiaAtual;
    private Equipa estado;
    private double energiaTotal;
    //preferes que os portais tenham todos uma energia total diferente? Se nao, fazemos uma constante.
    private double umQuartoEnergiaTotal;

    public Portal(String id, double latitude, double longitude, double energiaAtual, Equipa estado) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.energiaAtual = energiaAtual;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getEnergiaAtual() {
        return energiaAtual;
    }

    public void setEnergia(double energia) {
        this.energiaAtual = energia;
    }

    public Equipa getEstado() {
        return estado;
    }

    public void setEstado(Equipa estado) {
        this.estado = estado;
    }

    public void determinarEstadoAtacado(Portal portal, float energiaRetirada){
        //retira a energiaRetirada da sua energiaAtual
        //se for menor que 0, faz o abs()
            //

    }

    public void determinarEstadoFortelacido(Portal portal, float energiaDoada){

    }
}
