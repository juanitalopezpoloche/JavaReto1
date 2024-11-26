import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcionMenu;
        boolean mostrarMenuPrincipal = true;   
        String planetaDestinoUsuario = "";

        // Agregamos información de los planetas (nombre, descripción, distancia)
        Map<String, String[]> planetasDestino = new HashMap<>();        
        planetasDestino.put("Mercurio", new String[]{"Es el planeta más cercano al Sol, con temperaturas extremadamente altas.", "91.7"});
        planetasDestino.put("Venus", new String[]{"Conocido como el gemelo de la Tierra, con una atmósfera densa y cálida.", "41.4"});
        planetasDestino.put("Marte", new String[]{"Conocido como el planeta rojo debido a su superficie oxidada.", "78.3"});
        planetasDestino.put("Júpiter", new String[]{"El planeta más grande del sistema solar, con una atmósfera de gas.", "628.7"});
        planetasDestino.put("Saturno", new String[]{"Famoso por sus impresionantes anillos, es el segundo planeta más grande.", "1200"});
        planetasDestino.put("Urano", new String[]{"Un gigante helado con una atmósfera rica en hidrógeno y helio.", "2660"});
        planetasDestino.put("Neptuno", new String[]{"El planeta más distante del sistema solar, con fuertes vientos.", "4300"});
        
        while (mostrarMenuPrincipal) {

            mostrarMenuPrincipal();
            opcionMenu = scanner.nextInt();

            switch (opcionMenu) {
                case 1:
                  
                    if (!planetaDestinoUsuario.isEmpty()) {
                        System.out.println("\nHas seleccionado un planeta destino. Si eliges otro, el actual(" + planetaDestinoUsuario + ") será reemplazado.");
                    }

                    planetaDestinoUsuario = obtenerPlanetaDestinoUsuario(scanner, planetasDestino);   
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                   break;

                default:
                    System.out.println("\nOpción Inválida");
            }

        }

        scanner.close();
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("\n------------  MENU  ------------");
        System.out.println(" 1. Seleccionar un planeta destino");
        System.out.println(" 2. Seleccionar una nave espacial");
        System.out.println(" 3. Iniciar una simulación espacial");
        System.out.println(" 4. Salir del programa");
        System.out.println("\nDigite una opción (1-4):");
    }

    public static String obtenerPlanetaDestinoUsuario(Scanner scanner, Map<String, String[]> planetasDestino) {
        int index = 1;
        
        // Mostramos la lista de planetas
        System.out.println("\n------------  PLANETAS  ------------");
        for (String planeta : planetasDestino.keySet()) {
            System.out.println(index + ". " + planeta);
            index++;
        }

        System.out.println("\nSeleccione un planeta:");
        int planetaSeleccionado = scanner.nextInt();

        // Si el usuario selecciona un planeta qeu no es valido le mostramos un mensaje y se le da la opción de elegir nuevamente
        while (planetaSeleccionado < 1 || planetaSeleccionado > planetasDestino.size()) {
            System.out.println("\nOpción no válida, elija un destino válido (1 a " + planetasDestino.size() + "): ");
            planetaSeleccionado = scanner.nextInt();
        }

        // Mostramos al usuario el planeta seleccionado, descripción y la distancia
        String planeta = (String) planetasDestino.keySet().toArray()[planetaSeleccionado - 1];
        System.out.println("\nHas seleccionado: " + planeta);
        System.out.println("Descripción: " + planetasDestino.get(planeta)[0]);
        System.out.println("Distancia desde la Tierra: " + planetasDestino.get(planeta)[1] + " millones de Km");

        return planeta;
    }

}
