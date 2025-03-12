import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccionar tipo de Map que se usara:\n1. HasMap \n2. TreeMap \n3. LinckedHashMap");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        Map<String, Pokemon> MapaPokemon = Factory.crearMapa(opcion);
        Control control = new Control(MapaPokemon);

        try {
            control.leerCsv("pokemon_data_pokeapi.csv"); 
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        while (opcion != 6) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar un Pokémon a tu colección");
            System.out.println("2. Mostrar datos de un Pokemon, ingrese el nombre");
            System.out.println("3. Mostrar Pokemones en tu coleccion por Tipo 1");
            System.out.println("4. Mostrar Pokemones existentes por Tipo 1");
            System.out.println("5. Buscar Pokemon por Habilidad");
            System.out.println("6. Salir");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre del Pokémon:");
                    String nombre1 = scanner.nextLine();
                    control.addPokemonColeccion(nombre1);
                    break;
                case 2:
                    System.out.print("Ingresar nombre:  ");
                    String nombre2 = scanner.nextLine();
                    control.mostrarDatos(nombre2);
                    break;
                
                case 3:
                    System.out.println("Colección del usuario ordenada por Tipo 1:");
                    control.mostrarColeccionTipo1();
                    break;

                case 4:
                    System.out.println("Todos los Pokémon ordenados por tipo 1:");
                    control.mostrarPokemonTipo1();

                    break;

                case 5:
                    System.out.print("Ingresar Habilidad: ");
                    String ability = scanner.nextLine();
                    control.buscarHabilidad(ability);

                    break;

                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }

    }
}