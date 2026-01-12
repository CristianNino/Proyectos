/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package galletas.Conexiondb;

/**
 *
 * @author Sergio
 */
public class galletas {
   int Id;
   String Nombre;
   String Sabor;
   String Marca;
   Float PrecioPaquete;
   int CantidadPaquete;
   int Stock;
   public galletas(){
   
   }

    public galletas(int Id, String Nombre, String Sabor, String Marca, Float PrecioPaquete, int CantidadPaquete, int Stock) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Sabor = Sabor;
        this.Marca = Marca;
        this.PrecioPaquete = PrecioPaquete;
        this.CantidadPaquete = CantidadPaquete;
        this.Stock = Stock;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getSabor() {
        return Sabor;
    }

    public void setSabor(String Sabor) {
        this.Sabor = Sabor;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public Float getPrecioPaquete() {
        return PrecioPaquete;
    }

    public void setPrecioPaquete(Float PrecioPaquete) {
        this.PrecioPaquete = PrecioPaquete;
    }

    public int getCantidadPaquete() {
        return CantidadPaquete;
    }

    public void setCantidadPaquete(int CantidadPaquete) {
        this.CantidadPaquete = CantidadPaquete;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }
   
                            
}
