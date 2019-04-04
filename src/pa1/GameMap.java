package pa1;


import pa1.ministers.Economist;
import pa1.ministers.Minister;
import pa1.ministers.Scientist;
import pa1.ministers.WarGeneral;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Holds the necessary components for running the game
 */
public class GameMap {
    private List<Player> players;
    private Map<Integer, Cell> cityLocations;
    private Map<Integer, List<Integer>> connectedCities;
    private int width, height;

    /**
     * Load the map from a text file
     * The outline of the map format is given in the assignment description
     *
     * You should instantiate cityLocations and connectedCities here
     *
     * @param filename
     * @throws IOException
     */
    public void loadMap(String filename) throws IOException {
        // TODO DONE
        cityLocations = new HashMap<>();
        connectedCities = new HashMap<>();

        Scanner sc = new Scanner(new File(filename));
        width = sc.nextInt();
        height = sc.nextInt();

        int numCities = sc.nextInt();

        for (int i = 0; i < numCities; i++) {
            Integer cityID = sc.nextInt();
            String coordinates = sc.next();
            String[] tokens = coordinates.split(",");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            cityLocations.put(cityID, new Cell(x, y));
        }

        for (int i = 0; i < numCities; i++) {
            Integer cityID = sc.nextInt();
            String neighbors = sc.next();
            String[] tokens = neighbors.split(",");
            List<Integer> Neighbors = new ArrayList<>();
            for (String id : tokens) Neighbors.add(Integer.parseInt(id));
            connectedCities.put(cityID, Neighbors);
        }
        sc.close();
    }

    /**
     * Loads player data from text file
     * The outline of the player file format is given in the assignment description
     *
     * You should instantiate the member variable players here
     *
     * @param filename
     * @throws IOException
     */
    public void loadPlayers(String filename) throws IOException {
        // TODO DONE
        players = new ArrayList<>();

        Scanner sc = new Scanner(new File(filename));
        int numPlayers = sc.nextInt();
        for (int i = 0; i < numPlayers; i++) {
            Player player =new Player(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            players.add(player);
            int numCities = sc.nextInt();
            int numMinister = sc.nextInt();
            for (int j = 0; j < numCities; j++) {
                player.getCities().add(new City(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
            }
            for (int k = 0; k < numMinister; k++) {
                String type = sc.next();
                Minister mis = null;
                switch (type) {
                    case "Economist": mis = new Economist(sc.nextInt(), sc.nextInt(), sc.nextInt()); break;
                    case "Scientist": mis = new Scientist(sc.nextInt(), sc.nextInt(), sc.nextInt()); break;
                    case "WarGeneral": mis = new WarGeneral(sc.nextInt(), sc.nextInt(), sc.nextInt()); break;
                    default: throw new IOException("Invalid Minister Type: " + type);
                }
                if (mis != null) player.getMinisters().add(mis);
            }
        }
        sc.close();
    }

    /**
     * @return list of all cities from every player
     */
    public List<City> getAllCities() {
        // TODO DONE
        List<City> allCities = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            allCities.addAll(players.get(i).getCities());
        }
        return allCities;
    }

    /**
     * @param city
     * @return Cell object representing the city's location on the game map
     */
    public Cell getCityLocation(City city) {
        // TODO DONE
        return cityLocations.get(city.getId());
    }

    public City getCityById(int id) {
        return getAllCities().stream()
                .filter(city -> city.getId() == id)
                .findAny()
                .orElse(null);
    }

    public Player getCityOwner(City city) {
        return getPlayers().stream()
                .filter(p -> p.hasCity(city))
                .findFirst()
                .orElse(new Player("", 0, 0, 0));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<City> getNeighboringCities(City city) {
        List<Integer> neighborIds = connectedCities.get(city.getId());
        return neighborIds.stream()
                .map(this::getCityById)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private void drawLine(char map[][], Cell a, Cell b) {
        if (a.getX() == b.getX()) {
            int minY = Math.min(a.getY(), b.getY());
            int maxY = Math.max(a.getY(), b.getY());

            for (int i = minY; i < maxY; i++) map[i][a.getX()] = '|';
        } else if (a.getY() == b.getY()) {
            int minX = Math.min(a.getX(), b.getX());
            int maxX = Math.max(a.getX(), b.getX());

            Arrays.fill(map[a.getY()], minX, maxX, '-');
        }
    }

    @Override
    public String toString() {
        char[][] map = new char[height][width];
        char[] vertSeparator = new char[width + 2];
        Arrays.fill(vertSeparator, '#');
        for (int i = 0; i < height; i++) Arrays.fill(map[i], ' ');

        for (int cityIdA : connectedCities.keySet()) {
            for (int cityIdB : connectedCities.get(cityIdA)) {
                Cell a = cityLocations.get(cityIdA);
                Cell b = cityLocations.get(cityIdB);
                drawLine(map, a, b);
            }
        }

        for (City city : getAllCities()) {
            Cell location = getCityLocation(city);
            int x = location.getX();
            int y = location.getY();

            char[] line = map[y];
            String cityText = city.getMapRepresentation(getCityOwner(city).getName());
            System.arraycopy(cityText.toCharArray(), 0, line, x - 3, cityText.length());
        }

        StringBuilder sb = new StringBuilder().append(vertSeparator).append('\n');
        for (char[] line : map) sb.append('#').append(line).append('#').append('\n');
        return sb.append(vertSeparator).toString();
    }


}
