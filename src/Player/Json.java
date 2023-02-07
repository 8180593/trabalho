package Player;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
import ClassImplementation.LinkedList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Json {
    /**
     * Método que cria um ficheiro JSON com os dados do historico do portal
     * @param connectors lista de historicos do Connector
     */
    public void criarJsonConnectorHistorico(LinkedList<ConnectorHistorico> connectors){
        JSONArray listas = new JSONArray();
        int i;
        for(i = 0; i < connectors.size(); i++){
            JSONObject obj = new JSONObject();
            obj.put("Name", connectors.get(i).getPlayer().getName());
            obj.put("Data", connectors.get(i).getData());
            listas.add(obj);
        }
        writeJSONToFile(listas, "ConnectorHistorico.json");
    }
    /**
     * Método que cria um ficheiro JSON com os jogadores
     * @param players lista de jogadores
     */
    public void criarJsonPlayer(LinkedList<Player> players){
        JSONArray listas = new JSONArray();
        int i;
        for(i = 0; i < players.size(); i++){
            JSONObject obj = new JSONObject();
            obj.put("Name", players.get(i).getName());
            obj.put("Team", players.get(i).getEquipa());
            obj.put("Level", players.get(i).getNivel());
            obj.put("ExperiencePoints", players.get(i).getExperiencia());
            obj.put("MaxEnergy", players.get(i).getEnergiaCapacidade());
            obj.put("CurrentEnergy", players.get(i).getEnergia());
            listas.add(obj);
        }
        writeJSONToFile(listas, "Players.json");
    }
    /**
     * Método que cria um ficheiro JSON com os conectores
     * @param connectors lista de connectores
     */
    public void criarJsonConnector(LinkedList<Connector> connectors){
        JSONArray listas = new JSONArray();
        int i;
        for(i = 0; i < connectors.size(); i++){
            JSONObject obj = new JSONObject();
            obj.put("Id", connectors.get(i).getId());
            obj.put("Type", "Connector");
            obj.put("Latitude", connectors.get(i).getLatitude());
            obj.put("Longitude", connectors.get(i).getLongitude());
            obj.put("IntervaloTempo", connectors.get(i).getIntervaloTempo());
            listas.add(obj);
        }
        writeJSONToFile(listas, "Connectors.json");
    }
    /**
     * Método que cria um ficheiro JSON com os portais
     * @param portals lista de portais
     */
    public void criarJsonPortal(LinkedList<Portal> portals){
        JSONArray listas = new JSONArray();
        int i;
        for(i = 0; i < portals.size(); i++){
            JSONObject obj = new JSONObject();
            obj.put("Id", portals.get(i).getId());
            obj.put("Type", "Portal");
            obj.put("Latitude", portals.get(i).getLatitude());
            obj.put("Longitude", portals.get(i).getLongitude());
            obj.put("Energia", portals.get(i).getEnergiaAtual());
            obj.put("EnergiaMax", portals.get(i).getEnergiaMaxima());
            obj.put("Ownership", portals.get(i).getNomeJogador());
            listas.add(obj);
        }
        writeJSONToFile(listas, "Portals.json");
    }

    /**
     * Método que escreve no ficheiro JSON
     * @param obj objeto Json para escrever no ficheiro
     * @param fileName nome do ficheiro
     */
    public void writeJSONToFile(JSONArray obj, String fileName) {
        try(FileWriter file = new FileWriter(fileName)) {
            file.write(obj.toJSONString());
            file.flush();
            file.close();
            System.out.println("Copiado com sucesso para o ficheiro JSON...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que importa os dados do ficheiro JSON
     * @param nomeFicheiro nome do ficheiro
     * @throws IOException
     * @throws ParseException
     */
    public void importarJson(String nomeFicheiro) throws IOException, ParseException {
        LinkedList<Portal> portais = new LinkedList<>();
        LinkedList<Connector> conectores = new LinkedList<>();
        LinkedList<Player> jogadores = new LinkedList<>();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(nomeFicheiro));

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray locals = (JSONArray) jsonObject.get("locals");
        JSONArray players = (JSONArray) jsonObject.get("players");
        JSONArray routes = (JSONArray) jsonObject.get("routes");


        for (Object local : locals) {
            Local local1;
            JSONObject localJson = (JSONObject) local;
            Long id = (Long) localJson.get("id");
            String type = (String) localJson.get("type");

            if(type.equals("Connector")) {
                JSONObject coordinates = (JSONObject) localJson.get("coordinates");
                Double latitude = (Double) coordinates.get("latitude");
                Double longitude = (Double) coordinates.get("longitude");

                JSONObject gameSettings = (JSONObject) localJson.get("gameSettings");
                Long energy = (Long) gameSettings.get("energy");
                Long intervaloTempo = (Long) gameSettings.get("cooldown");
                local1 = new Connector(id, latitude, longitude, intervaloTempo, energy);
                conectores.add((Connector) local1);

            } else if(type.equals("Portal")){
                String namePortal = (String) localJson.get("name");

                JSONObject coordinates = (JSONObject) localJson.get("coordinates");
                Double latitude = (Double) coordinates.get("latitude");
                Double longitude = (Double) coordinates.get("longitude");

                JSONObject gameSettings = (JSONObject) localJson.get("gameSettings");
                Long energy = (Long) gameSettings.get("energy");
                Long maxEnergy = (Long) gameSettings.get("maxEnergy");

                JSONObject ownership = (JSONObject) gameSettings.get("ownership");
                String name = (String) ownership.get("player");

                Equipas equipa = null;
                if(name != null) {
                    for (int i = 0; i < jogadores.size(); i++) {
                        if (jogadores.get(i).getName().equals(name)) {
                            equipa = jogadores.get(i).getEquipa();
                        }
                    }
                }else{
                    equipa = Equipas.Neutro;
                    name = "None";
                }

                local1 = new Portal(id, latitude, longitude, equipa, maxEnergy, namePortal, energy);
                portais.add((Portal) local1);
            }
        }

        for (Object player : players) {
            JSONObject playerJson = (JSONObject) player;
            String name = (String) playerJson.get("name");
            String teams = (String) playerJson.get("team");
            Equipas team;
            switch(teams){
                case "Sparks":
                    team = Equipas.Sparks;
                case "Giants":
                    team = Equipas.Giants;
                default:
                    team = Equipas.Neutro;
            }
            Long levelLong = (Long) playerJson.get("level");
            int level = levelLong.intValue();
            Long longExperiencePoints = (Long) playerJson.get("experiencePoints");
            Double experiencePoints = longExperiencePoints.doubleValue();
            Long longEnergia = (Long) playerJson.get("currentEnergy");
            Double energia = longEnergia.doubleValue();
            Player player1 = new Player(energia, name, level, experiencePoints, team);
            jogadores.add(player1);
        }
        for(Object routs : routes){
            jsonObject = (JSONObject) routs;
            int from = ((Long) jsonObject.get("from")).intValue();
            int to = ((Long) jsonObject.get("to")).intValue();
        }
    }
}
