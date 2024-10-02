import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        ViveroDAO viveroDAO = new ViveroDAO();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        
        while (!salir) {
            System.out.println("Menú:");
            System.out.println("1. Listar empleados");
            System.out.println("2. Obtener información de un empleado por ID");
            System.out.println("3. Insertar nuevo empleado");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            try {
                switch (opcion) {
                    case 1:
                        viveroDAO.listaEmpleados();
                        break;
                    case 2:
                        System.out.print("Ingrese el ID del empleado: ");
                        int idEmpleado = scanner.nextInt();
                        viveroDAO.infoEmpleadoID(idEmpleado);
                        break;
                    case 3:

                        System.out.print("Ingrese el nombre del empleado: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Ingrese el apellido del empleado: ");
                        String apellido = scanner.nextLine();

                        System.out.print("Ingrese el email: ");
                        String email = scanner.nextLine();

                        System.out.print("Ingrese el puesto del empleado: ");
                        String puesto = scanner.nextLine();
                        viveroDAO.insertarEmpleado(nombre,apellido, email ,puesto);
                        break;
                    case 4:
                        // Salir
                        salir = true;
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    
}
