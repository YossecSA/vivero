import java.sql.SQLException;

public class ViveroDAO extends DAO{

    public void infoEmpleadoID(int idEmpleado) throws Exception { //devuelve un valor
        try {
            connectarDataBase();
            
            String sql = "SELECT * FROM empleado WHERE id_empleado = ?"; 
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, idEmpleado);
            
            resultSet = preparedStatement.executeQuery(); 
            
           // Verifica si hay un resultado
            if (resultSet.next()) {
                System.out.println("Empleado ID: " + resultSet.getInt("id_empleado"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Puesto: " + resultSet.getString("puesto"));
                System.out.println("----------");
            } else {
                System.out.println("No se encontró ningún empleado con ID: " + idEmpleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            desconectarDataBase();  // Asegurar que se desconecte después de la operación
        }
    }

    public void listaEmpleados() throws Exception {
        try {
            connectarDataBase(); 
    
            String sql = "SELECT * FROM empleado"; 
            preparedStatement = conexion.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(); 
            
            if (!resultSet.isBeforeFirst()) { 
                System.out.println("No hay empleados en la base de datos.");
            } else {
                while (resultSet.next()) {
                    System.out.println("Empleado ID: " + resultSet.getInt("id_empleado"));
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Puesto: " + resultSet.getString("puesto"));
                    System.out.println("----------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e; 
        } finally {
            desconectarDataBase();
        }
    }

    public void updateEmpleado(int idEmpleado, String nuevoNombre, String nuevoPuesto) throws Exception {
        try {
            connectarDataBase(); 
    
            String sql = "UPDATE empleado SET nombre = ?, puesto = ? WHERE id_empleado = ?";
            preparedStatement = conexion.prepareStatement(sql);
            
            preparedStatement.setString(1, nuevoNombre);
            preparedStatement.setString(2, nuevoPuesto);
            preparedStatement.setInt(3, idEmpleado);

            int filasActualizadas = preparedStatement.executeUpdate(); 
            
            if (filasActualizadas > 0) {
                System.out.println("Empleado modificado con éxito.");
            } else {
                System.out.println("No se encontró un empleado con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            throw e; 
        } finally {
            desconectarDataBase();
        }
    }

    public void insertarEmpleado(String nombre, String apellido, String email ,String puesto) throws Exception {
        try {
            connectarDataBase();
    
            String sql = "INSERT INTO `empleado` (`nombre`, `apellido`, `email`, `puesto`) VALUES (?, ?, ?, ?)";
            preparedStatement = conexion.prepareStatement(sql);
            
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, puesto);
            
            int filasInsertadas = preparedStatement.executeUpdate(); 
            
            if (filasInsertadas > 0) {
                System.out.println("Empleado insertado con éxito.");
            } else {
                System.out.println("No se pudo insertar el empleado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            desconectarDataBase();
        }
    }
}
