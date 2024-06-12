/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package galletas.Conexiondb;

/**
 *
 * @author Sergio
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaConexionBD {

    static final String URL = "jdbc:mysql://localhost:3306/galletas";
    static final String USUARIO = "root";
    static final String CONTRASENA = "";

    public static void main(String[] args) {
        try {
            // Intenta establecer la conexión
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión exitosa a la base de datos");

            // Ahora, puedes realizar algunas operaciones de prueba
            realizarPruebas(conexion);

            // Cierra la conexión al finalizar
            conexion.close();
            System.out.println("Conexión cerrada");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    private static void realizarPruebas(Connection conexion) {
        try {
            // Crea una nueva declaración
            Statement statement = conexion.createStatement();

            // Ejemplo de consulta para obtener información de Fideos
            String consultaFideos = "SELECT * FROM Fideos";
            statement.execute(consultaFideos);
            System.out.println("Consulta de Fideos realizada con éxito");

            // Ejemplo de consulta para obtener información de Galletas
            String consultaGalletas = "SELECT * FROM Galletas";
            statement.execute(consultaGalletas);
            System.out.println("Consulta de Galletas realizada con éxito");

            // Cierra la declaración
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error al realizar pruebas en la base de datos: " + e.getMessage());
        }
    }
}
