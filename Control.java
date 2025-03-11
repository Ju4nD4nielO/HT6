import java.util.*;
import java.io.*;

public class Control {

    private Map<String, Pokemon> MapaPokemon;
    private Set<Pokemon> uColeccion;

    public Control(Map<String, Pokemon> MapaPokemon) {
        this.MapaPokemon = MapaPokemon;
        this.uColeccion = new HashSet<>();

    }

    public void leerCsv(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Pokemon pokemon = new Pokemon(
                    data[0], Integer.parseInt(data[1]), data[2], data[3],
                    data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6]),
                    data[7], Integer.parseInt(data[8]), Boolean.parseBoolean(data[9]));
                MapaPokemon.put(pokemon.getNombre(), pokemon);
            }
        }
    }

    public void addPokemonColeccion(String nombre) {
        Pokemon pokemon = MapaPokemon.get(nombre);
        if (pokemon == null) {
            System.out.println("El Pokemon no esta en la lista");
        } 
        
        else if (uColeccion.contains(pokemon)) {
            System.out.println("Ya tienes al pokemon en tu coleccion");
        } 
        
        else {
            uColeccion.add(pokemon); 
            System.out.println(pokemon.getNombre() + " Se agrego exitosamente l Pokemon a tu coleccion.");
        }
    }
    
}

