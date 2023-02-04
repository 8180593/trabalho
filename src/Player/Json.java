package Player;

import ClassImplementation.LinkedList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Json {
    public void criarJsonConnectorHistorico(LinkedList<ConnectorHistorico> connectors){
        JSONObject obj = new JSONObject();
        int i;
        for(i = 0; i < connectors.size(); i++){
            obj.put("Name", connectors.get(i).getPlayer().getName());
            obj.put("Data", connectors.get(i).getData());
        }
        writeJSONToFile(obj, "ConnectorHistorico.json");
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
        writeJSONToFile(obj, "Players.json");
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
        writeJSONToFile(obj, "Connectors.json");
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
        writeJSONToFile(obj, "Portals.json");
    }

    public void writeJSONToFile(JSONObject obj, String fileName) {
        try(FileWriter file = new FileWriter(fileName)) {
            file.write(obj.toJSONString());
            file.flush();
            file.close();
            System.out.println("Copiado com sucesso para o ficheiro JSON...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void importarJson(String nomeFicheiro) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(nomeFicheiro));
        JSONObject jsonObject = (JSONObject) obj;
        String id = (String) jsonObject.get("id");
        String type = (String) jsonObject.get("type");
        if(type == "Portal"){
            //Portal portal = new Portal((String) jsonObject.get("id"), (double) jsonObject.get("latitude"), (double) jsonObject.get("longitude"), (double) jsonObject.get("energia"), (double) jsonObject.get("energiaMax"));
        }
    }
}
