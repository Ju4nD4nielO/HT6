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
            br.readLine();

            while ((line = br.readLine()) != null) {
                
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                // Limpia comillas eztra o espacios inecearios
                for (int i = 0; i < data.length; i++) {
                    data[i] = data[i].replaceAll("\"", "").trim();
                }

                // Asignar los valores en el orden correcto
                String nombre = data[0];
                int numero = Integer.parseInt(data[1]);
                String type1 = data[2];
                String type2 = data[3];
                String clasificacion = data[4];
                double altura = Double.parseDouble(data[5]);
                double peso = Double.parseDouble(data[6]);

                // Manejo de habilidades como lista (pueden estar separadas por comas)
                List<String> habilidades = Arrays.asList(data[7].split("\\s*,\\s*")); // Divide y elimina espacios extra

                int gen = Integer.parseInt(data[8]);
                boolean legendario = Boolean.parseBoolean(data[9]);

                // Crear el objeto Pokémon y agregarlo al mapa
                Pokemon pokemon = new Pokemon(nombre, numero, type1, type2, clasificacion, altura, peso, habilidades, gen, legendario);
                MapaPokemon.put(nombre, pokemon);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir un número en el CSV: " + e.getMessage());
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: La línea del CSV no tiene suficientes columnas.");
            e.printStackTrace();
        }
    }

    //Agrega un pokemon a la coleccion del usuario
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

    //Muestra los atributos del pooemon que se haya seleccionado por el nombre
    public void mostrarDatos(String nombre) {
        Pokemon pokemon = MapaPokemon.get(nombre);
        if (pokemon == null) {
            System.out.println("No existe este Pokemon");
        }

        else {
            System.out.println(pokemon);
        }
    }

    // Muestra coleccion del usurio ordenado por Tipo 1
    public void mostrarColeccionTipo1() {
        
        List<Pokemon> listaPokemon = new ArrayList<>(uColeccion);
    
        
        listaPokemon.sort(new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon p1, Pokemon p2) {
                return p1.getType1().compareTo(p2.getType1());
            }
        });
    
        // Mostrar los Pokémon ordenados
        for (Pokemon p : listaPokemon) {
            System.out.println("nombre: " + p.getNombre() + ", Type1: " + p.getType1());
        }
    }

    // Método para mostrar todos los Pokémon ordenados por Type1
    public void mostrarPokemonTipo1() {
        MapaPokemon.values().stream()
            .sorted(Comparator.comparing(Pokemon::getType1))
            .forEach(p -> System.out.println("nombre: " + p.getNombre() + ", Type1: " + p.getType1()));
    }

    // Método para buscar Pokémon por habilidad
    public void buscarHabilidad(String ability) {
        
        for (Pokemon p : MapaPokemon.values()) {
            
            if (p.getHabilidad().contains(ability)) {
                System.out.println("nombre: " + p.getNombre());
            }
        }
    }
    
}

