package Player;

import ClassImplementation.LinkedList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Json {
    public void crirJsonPortalHistorico(LinkedList<ConnectorHistorico> connectors){
        JSONObject obj = new JSONObject();
        int i;
        for(i = 0; i < connectors.size(); i++){
            obj.put("Name", connectors.get(i).getPlayer().getName());
            obj.put("Data", connectors.get(i).getData());
        }
    }

    public void criarJsonPlayer(LinkedList<Player> players){
        JSONObject obj = new JSONObject();
        int i;
        for(i = 0; i < players.size(); i++){
            obj.put("Name", players.get(i).getName());
            obj.put("Team", players.get(i).getEquipa());
            obj.put("Level", players.get(i).getNivel());
            obj.put("ExperiencePoints", players.get(i).getExperiencia());
            obj.put("MaxEnergy", players.get(i).getEnergiaCapacidade());
            obj.put("CurrentEnergy", players.get(i).getEnergia());
        }
    }

    public void criarJsonConnector(LinkedList<Connector> connectors){
        JSONObject obj = new JSONObject();
        int i;
        for(i = 0; i < connectors.size(); i++){
            obj.put("Id", connectors.get(i).getId());
            obj.put("Type", "Connector");
            obj.put("Latitude", connectors.get(i).getLatitude());
            obj.put("Longitude", connectors.get(i).getLongitude());
            obj.put("IntervaloTempo", connectors.get(i).getIntervaloTempo());
        }
    }

    public void criarJsonPortal(LinkedList<Portal> portals){
        JSONObject obj = new JSONObject();
        int i;
        for(i = 0; i < portals.size(); i++){
            obj.put("Id", portals.get(i).getId());
            obj.put("Type", "Portal");
            obj.put("Latitude", portals.get(i).getLatitude());
            obj.put("Longitude", portals.get(i).getLongitude());
            obj.put("Energia", portals.get(i).getEnergiaAtual());
            obj.put("EnergiaMax", portals.get(i).getEnergiaMaxima());
            obj.put("Ownership", portals.get(i).getNomeJogador());
        }
    }

    public void importarJson() throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("data.json"));
        JSONObject jsonObject = (JSONObject) obj;
        String id = (String) jsonObject.get("id");
    }
}
