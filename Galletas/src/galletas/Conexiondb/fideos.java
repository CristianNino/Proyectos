/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package galletas.Conexiondb;

/**
 *
 * @author Sergio
 */
public class fideos {

    int Id;
    String Tipo;
    String Marca;
    Float PrecioPaquete;
    Float PesoPaquete;
    int Stock;

    public fideos() {

    }

    public fideos(int Id, String Tipo, String Marca, Float PrecioPaquete, Float PesoPaquete, int Stock) {
        this.Id = Id;
        this.Tipo = Tipo;
        this.Marca = Marca;
        this.PesoPaquete = PesoPaquete;
        this.PrecioPaquete = PrecioPaquete;
        this.Stock = Stock;
       
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
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

    public Float getPesoPaquete() {
        return PesoPaquete;
    }

    public void setPesoPaquete(Float PesoPaquete) {
        this.PesoPaquete = PesoPaquete;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }
    
}
