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


public class Conexionbd {

    static final String URL = "jdbc:mysql://localhost:3306/galletas";
    static final String USUARIO = "root";
    static final String CONTRASENA = "";
    Connection conexion ;
    public Connection getConnection() {
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión exitosa a la base de datos");

        } catch (Exception e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    return conexion;
    }

    
}
