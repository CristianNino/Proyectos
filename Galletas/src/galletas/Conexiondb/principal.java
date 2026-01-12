/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package galletas.Conexiondb;


import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class principal {
    Conexionbd conectar = new Conexionbd();
    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;
    ResultSet rs1;
    
    
    public int agregarf(fideos f){
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
            ps.executeUpdate();
            
        } catch (SQLException e) {
        }
        return 1;
   }
    public int agregarg(galletas g){
    String sql;
        sql = "INSERT INTO galletas(Nombre, Sabor, Marca,PrecioPaquete,CantidadPaquete,CantidadPaquetesStock) VALUES (?, ?, ?, ?, ?,?)";
        try {
            conexion = conectar.getConnection();
            ps=conexion.prepareStatement(sql);
            ps.setString(1, g.Nombre);
            ps.setString(2, g.Sabor);
            ps.setString(3, g.Marca);
            ps.setFloat(4, g.PrecioPaquete);
            ps.setInt(5, g.CantidadPaquete);
            ps.setInt(6, g.Stock);
            ps.executeUpdate();
            
        } catch (SQLException e) {
        }
        return 1;
    
    

    }
    
    public List listarf(){
     List<fideos>datos=new ArrayList<>();
     String sql="select * from fideos";
        try {
            conexion=conectar.getConnection();
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
            fideos f=new fideos();
            f.setId(rs.getInt(1));
            f.setTipo(rs.getString(2));
            f.setMarca(rs.getString(3));
            f.setPesoPaquete(rs.getFloat(4));
            f.setPrecioPaquete(rs.getFloat(5));
            f.setStock(rs.getInt(6));
            
            datos.add(f);
            }
        } catch (Exception e) {
        }
     return datos;
    }
    public List listarg(){
     List<galletas>datos1=new ArrayList<>();
     String sql="select * from galletas.galletas";
        try {
            conexion=conectar.getConnection();
            ps=conexion.prepareStatement(sql);
            rs1=ps.executeQuery();
            while(rs1.next()){
            galletas g=new galletas();
            g.setId(rs1.getInt(1));
            g.setNombre(rs1.getString(2));
            g.setSabor(rs1.getString(3));
            g.setMarca(rs1.getString(4));
            g.setPrecioPaquete(rs1.getFloat(5));
            g.setCantidadPaquete(rs1.getInt(6));
            g.setStock(rs1.getInt(7));
         
            datos1.add(g);
            }
        } catch (SQLException e) {
        }
     return datos1;

    }
    public void Eliminarf(int id){
    String sql="DELETE FROM `fideos` WHERE `fideos`.`Id_Fideo` = "+id;
    System.out.println(""+id);
        try {
            conexion=conectar.getConnection();
            ps=conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void Eliminarg(int id){
    String sql="DELETE FROM `galletas` WHERE `galletas`.`Id_Galleta` = "+id;
    System.out.println(""+id);
        try {
            conexion=conectar.getConnection();
            ps=conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public int Actualizarf(fideos f){
      String sql="update fideos set Tipo=?, Marca=?, PrecioPaquete=?,  PesoPaquete=? ,CantidadPaquetesStock=? where Id_Fideo=?";
        try {
            conexion=conectar.getConnection();
            ps=conexion.prepareStatement(sql);
            ps.setString(1, f.Tipo);
            ps.setString(2, f.Marca);
            ps.setFloat(3, f.PrecioPaquete);
            ps.setFloat(4, f.PesoPaquete);
            ps.setInt(5, f.Stock);
            ps.setInt(6, f.Id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return 1;
    }
    
    public int Actualizarg(galletas g){
        String sql="update galletas set Nombre=?, Sabor=?, Marca=?, PrecioPaquete=?, CantidadPaquete=? ,CantidadPaquetesStock=? where Id_Galleta=?";
        try {
            conexion=conectar.getConnection();
            ps=conexion.prepareStatement(sql);
            ps.setString(1,g.Nombre);
            ps.setString(2, g.Sabor);
            ps.setString(3, g.Marca);
            ps.setFloat(4, g.PrecioPaquete);
            ps.setInt(5, g.CantidadPaquete);
            ps.setInt(6, g.Stock);
            ps.setInt(7, g.Id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return 1;
    } 
}
