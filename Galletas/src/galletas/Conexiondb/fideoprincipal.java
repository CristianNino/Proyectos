/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package galletas.Conexiondb;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sergio
 */
public class fideoprincipal {
    Conexionbd conectar = new Conexionbd();
    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public int agregar(fideos f){
        String sql;
        sql = "INSERT INTO galletas.fideos (Tipo, Marca, PrecioPaquete, PesoPaquete, CantidadPaquetesStock) VALUES (?, ?, ?, ?, ?)";
        try {
            conexion = conectar.getConnection();
            ps=conexion.prepareStatement(sql);
            ps.setString(1, f.Tipo);
            ps.setString(2, f.Marca);
            ps.setFloat(3, f.PrecioPaquete);
            ps.setFloat(4, f.PesoPaquete);
            ps.setInt(5, f.Stock);
            System.out.println(f.Tipo+f.Marca+f.PrecioPaquete+f.PesoPaquete+f.Stock);
            ps.executeUpdate();
            
        } catch (SQLException e) {
        }
        return 1;
   }
}
