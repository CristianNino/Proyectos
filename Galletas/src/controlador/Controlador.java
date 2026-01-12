/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import galletas.Conexiondb.principal;
import galletas.Conexiondb.fideos;
import Vista.*;
import galletas.Conexiondb.galletas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener{
    principal  fideo= new principal();
    principal  galleta = new principal();
    fideos f=new fideos();
    galletas g= new galletas();
    VistaFideos vista=new VistaFideos();
    VistaGalletas vista1=new VistaGalletas();
    DefaultTableModel modelo= new DefaultTableModel();
    DefaultTableModel modelo1= new DefaultTableModel();
    
    
public Controlador (VistaFideos v){
      this.vista = v;
      this.vista.BotonAgregarF.addActionListener(this);
      this.vista.Listarf.addActionListener(this);
      this.vista.BotonEliminarf.addActionListener(this);
      this.vista.botoneditarf.addActionListener(this);
      this.vista.botonEnviarf.addActionListener(this);
    
}    
public Controlador (VistaGalletas vi){
      this.vista1 = vi;
      this.vista1.Guardar.addActionListener(this);
      this.vista1.Listarg.addActionListener(this);
      this.vista1.BotonEliminarg.addActionListener(this);
      this.vista1.Editarg.addActionListener(this);
      this.vista1.Enviarg.addActionListener(this);
    
}       
    
    
    
    @Override
   
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.BotonAgregarF){
           agregarf();
           limpiartablaf();
           listarf(vista.tablaf);
        }
        if(e.getSource()==vista1.Guardar){
           agregarg();
           limpiartablag();
           listarg(vista1.tablag);
        }
        if(e.getSource()==vista.Listarf){
           limpiartablaf();
           listarf(vista.tablaf);
        }
        if(e.getSource()==vista1.Listarg){
           limpiartablag();
           listarg(vista1.tablag);
        }
        if(e.getSource()==vista.BotonEliminarf){
           int fila=vista.tablaf.getSelectedRow();
           if(fila==-1){
             JOptionPane.showMessageDialog(vista,"Seleccione Id");
           }else{
             int id=Integer.parseInt((String)vista.tablaf.getValueAt(fila, 0).toString());
             fideo.Eliminarf(id);
             JOptionPane.showMessageDialog(vista,"Se elimino Fideos");
           }
           limpiartablaf();
           listarf(vista.tablaf);
        }
        if(e.getSource()==vista1.BotonEliminarg){
            System.out.println("ola");
           int fila=vista1.tablag.getSelectedRow();
           if(fila==-1){
             JOptionPane.showMessageDialog(vista1,"Seleccione Id");
           }else{
             int id=Integer.parseInt((String)vista1.tablag.getValueAt(fila, 0).toString());
             galleta.Eliminarg(id);
             JOptionPane.showMessageDialog(vista1,"Se elimino Fideos");
           }
           limpiartablag();
           listarg(vista1.tablag);
        }
        if(e.getSource()==vista.botoneditarf){
          int fila=vista.tablaf.getSelectedRow();
          if(fila==1){
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un Id");
            
          }else{
             int id=Integer.parseInt((String)vista.tablaf.getValueAt(fila, 0).toString());
             String Tipo=(String)vista.tablaf.getValueAt(fila, 1);
             String Marca=(String)vista.tablaf.getValueAt(fila, 2);
             Float PrecioPaquete=Float.parseFloat((String)vista.tablaf.getValueAt(fila, 3).toString());
             Float PesoPaquete=Float.parseFloat((String)vista.tablaf.getValueAt(fila, 4).toString());
             int Stock=Integer.parseInt((String)vista.tablaf.getValueAt(fila, 5).toString());
             vista.ID_Fideo.setText(""+id);
             vista.Tipo.setText(Tipo);
             vista.Marca.setText(Marca);
             vista.PrecioPaquete.setText(""+PrecioPaquete);
             vista.PesoPaquete.setText(""+PesoPaquete);
             vista.CantidadPaquetesStock.setText(""+Stock);
          }
          limpiartablaf();
          listarf(vista.tablaf);
        }
        if(e.getSource()==vista.botonEnviarf){
          actualizarf();
          limpiartablaf();
          listarf(vista.tablaf);
        }
        if(e.getSource()==vista1.Editarg){
        int fila=vista1.tablag.getSelectedRow();
          if(fila==1){
            JOptionPane.showMessageDialog(vista1, "Debe seleccionar un Id");
            
          }else{
             int id=Integer.parseInt((String)vista1.tablag.getValueAt(fila, 0).toString());
             String Nombre=(String)vista1.tablag.getValueAt(fila, 1);
             String Sabor=(String)vista1.tablag.getValueAt(fila, 2);
             String Marca=(String)vista1.tablag.getValueAt(fila, 3);
             Float PrecioPaquete=Float.parseFloat((String)vista1.tablag.getValueAt(fila, 4).toString());
             int CantidadPaquete=Integer.parseInt((String)vista1.tablag.getValueAt(fila, 5).toString());
             int Stock=Integer.parseInt((String)vista1.tablag.getValueAt(fila, 6).toString());
             vista1.ID_Galleta.setText(""+id);
             vista1.Nombre.setText(Nombre);
             vista1.Sabor.setText(Sabor);
             vista1.Marca.setText(Marca);
             vista1.PrecioPaquete.setText(""+PrecioPaquete);
             vista1.CantidadPaquete.setText(""+CantidadPaquete);
             vista1.CantidadPaquetesStock.setText(""+Stock);
          }
         limpiartablag();
         listarg(vista1.tablag);
        }
        if(e.getSource()==vista1.Enviarg){
          actualizarg();
          limpiartablag();
          listarg(vista1.tablag);
        }
    }
    
    public void agregarf(){
        
        String Tipo=vista.Tipo.getText();
        String Marca=vista.Marca.getText();
        Float  PrecioPaquete=Float.valueOf(vista.PrecioPaquete.getText());
        Float  PesoPaquete = Float.valueOf(vista.PesoPaquete.getText());
        int    Stock = Integer.parseInt(vista.CantidadPaquetesStock.getText());
           f.setMarca(Marca);
           f.setTipo(Tipo);
           f.setPesoPaquete(PesoPaquete);
           f.setStock(Stock);
           f.setPrecioPaquete(PrecioPaquete);
           System.out.println(Tipo+Marca+PrecioPaquete+PesoPaquete+Stock);
        int r=fideo.agregarf(f);
        if(r==1){
           JOptionPane.showMessageDialog(vista,"Fideo Agregado con Exito");
        }else{
          JOptionPane.showMessageDialog(vista,"Error");
        }
        
        
    }
    public void agregarg(){
        String Nombre=vista1.Nombre.getText();
        String Sabor=vista1.Sabor.getText();
        String Marca=vista1.Marca.getText();
        Float PrecioPaquete=Float.valueOf(vista1.PrecioPaquete.getText());
        int CantidadPaquete= Integer.parseInt(vista1.CantidadPaquete.getText());
        int Stock=Integer.parseInt(vista1.CantidadPaquetesStock.getText());
           g.setNombre(Nombre);
           g.setSabor(Sabor);
           g.setMarca(Marca);
           g.setPrecioPaquete(PrecioPaquete);
           g.setCantidadPaquete(CantidadPaquete);
           g.setStock(Stock);
           int r=galleta.agregarg(g);
           if(r==1){
              JOptionPane.showMessageDialog(vista1,"Galleta Agregada con Exito");
           }else{
              JOptionPane.showMessageDialog(vista1,"Error");
           }
        
    }
    
    public void listarf(JTable tablaf){
        modelo=(DefaultTableModel)tablaf.getModel();
        List<fideos>lista=fideo.listarf();
        Object[]object=new Object[6];
        for(int i=0; i<lista.size();i++){
        object[0]=lista.get(i).getId();
        object[1]=lista.get(i).getTipo();
        object[2]=lista.get(i).getMarca();
        object[3]=lista.get(i).getPesoPaquete();
        object[4]=lista.get(i).getPrecioPaquete();
        object[5]=lista.get(i).getStock();
        modelo.addRow(object);
        }
        vista.tablaf.setModel(modelo);
    }
    public void listarg(JTable tablag){
        modelo1=(DefaultTableModel)tablag.getModel();
        List<galletas>lista1=galleta.listarg();
        Object[]object1=new Object[7];
        for(int x=0; x<lista1.size();x++){
        object1[0]=lista1.get(x).getId();
        object1[1]=lista1.get(x).getNombre();
        object1[2]=lista1.get(x).getSabor();
        object1[3]=lista1.get(x).getMarca();
        object1[4]=lista1.get(x).getPrecioPaquete();
        object1[5]=lista1.get(x).getCantidadPaquete();
        object1[6]=lista1.get(x).getStock();
        modelo1.addRow(object1);
        }
        vista1.tablag.setModel(modelo1);
    }

    private void actualizarf() {
        int id=Integer.parseInt(vista.ID_Fideo.getText());
        String Tipo=vista.Tipo.getText();
        String Marca=vista.Marca.getText();
        Float  PrecioPaquete=Float.valueOf(vista.PrecioPaquete.getText());
        Float  PesoPaquete = Float.valueOf(vista.PesoPaquete.getText());
        int    Stock = Integer.parseInt(vista.CantidadPaquetesStock.getText());
        f.setId(id);
        f.setTipo(Tipo);
        f.setMarca(Marca);
        f.setPrecioPaquete(PrecioPaquete);
        f.setPesoPaquete(PesoPaquete);
        f.setStock(Stock);
        int r=fideo.Actualizarf(f);
        if(r==1){
           JOptionPane.showMessageDialog(vista,"Modificado con Exito");
           }else{
              JOptionPane.showMessageDialog(vista,"Error");
           }
    }
    private void actualizarg(){
        int id=Integer.parseInt(vista1.ID_Galleta.getText());
        String Nombre=vista1.Nombre.getText();
        String Sabor=vista1.Sabor.getText();
        String Marca=vista1.Marca.getText();
        Float PrecioPaquete=Float.valueOf(vista1.PrecioPaquete.getText());
        int CantidadPaquete= Integer.parseInt(vista1.CantidadPaquete.getText());
        int Stock=Integer.parseInt(vista1.CantidadPaquetesStock.getText());
           g.setId(id);
           g.setNombre(Nombre);
           g.setSabor(Sabor);
           g.setMarca(Marca);
           g.setPrecioPaquete(PrecioPaquete);
           g.setCantidadPaquete(CantidadPaquete);
           g.setStock(Stock);
      int r=galleta.Actualizarg(g);
        if(r==1){
           JOptionPane.showMessageDialog(vista1,"Modificado con Exito");
           }else{
              JOptionPane.showMessageDialog(vista1,"Error");
           }
    }
    void limpiartablaf(){
      for(int i = 0;i<vista.tablaf.getRowCount();i++){
        modelo.removeRow(i);
        i=i-1;
       }
    }
    void limpiartablag(){
      for(int i = 0;i<vista1.tablag.getRowCount();i++){
        modelo1.removeRow(i);
        i=i-1;
       }
    }
}
