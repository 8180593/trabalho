package Player;

import ClassImplementation.ArrayUnorderedList;
import ClassImplementation.LinkedList;
import Interfaces.UnorderedListADT;
import org.json.simple.JSONArray;
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
        UnorderedListADT<Local> locais = new ArrayUnorderedList<>();
        UnorderedListADT<Player> jogadores = new ArrayUnorderedList<>();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("map.json"));

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray locals = (JSONArray) jsonObject.get("locals");
        JSONArray players = (JSONArray) jsonObject.get("players");
        JSONArray routes = (JSONArray) jsonObject.get("routes");


        for (Object local : locals) {
            Local local1 = new Local();
            JSONObject localJson = (JSONObject) local;
            Long id = (Long) localJson.get("id");

            JSONObject coordinates = (JSONObject) localJson.get("coordinates");
            Double latitude = (Double) coordinates.get("latitude");
            Double longitude = (Double) coordinates.get("longitude");

            JSONObject gameSettings = (JSONObject) localJson.get("gameSettings");
            Long energy = (Long) gameSettings.get("energy");
            Long maxEnergy = (Long) gameSettings.get("maxEnergy");

            local1.setLatitude(latitude);
            local1.setLongitude(longitude);
            local1.setId(id);
            local1.setEnergiaAtual(energy);
            System.out.println(local1.toString());
            locais.addToRear(local1);//adiciona o local ao arraylist
        }
/*
        for (Object player : players) {
            JSONObject playerJson = (JSONObject) player;
            String name = (String) playerJson.get("name");
            String team = (String) playerJson.get("team");
        }
*/
       //sout all the locals
        for (int i = 0; i < locais.size(); i++) {
            System.out.println(locais);
        }
    }
}
