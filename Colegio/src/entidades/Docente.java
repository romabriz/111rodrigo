package entidades;

import conexiones.ConexionBase;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

public class Docente {
    //Constructor
    //public Docente(int iddocente, int numlegajo, String titulo, int cantidadhorasasignadas, String estado) {
    //    this.iddocente = iddocente;
    //    this.numlegajo = numlegajo;
    //    this.titulo = titulo;
    //    this.cantidadhorasasignadas = cantidadhorasasignadas;
    //    this.estado = estado;
    //}
    
    //faltarian los atributos de persona

    public Docente(int numlegajo, int cuit, String titulo, int cantidadhorasasignadas, String estado) {
        this.numlegajo = numlegajo;
        this.cuit = cuit;
        this.titulo = titulo;
        this.cantidadhorasasignadas = cantidadhorasasignadas;
        this.estado = estado;
    }
    
    private int iddocente;
    private int numlegajo;
    private int cuit;
    private String titulo;
    private int cantidadhorasasignadas;
    private String estado;
    //se definen estas variables para ahorrar escritura de codigo
    private PreparedStatement ps;
        
    //Getter y Setter
    public int getNumlegajo() {
        return numlegajo;
    }

    public void setNumlegajo(int numlegajo) {
        this.numlegajo = numlegajo;
    }
    
    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantidadhorasasignadas() {
        return cantidadhorasasignadas;
    }

    public void setCantidadhorasasignadas(int cantidadhorasasignadas) {
        this.cantidadhorasasignadas = cantidadhorasasignadas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    //Metodos
    
    public void RegistrarDocente(){
        ConexionBase conectar = new ConexionBase();
        Connection base=conectar.getConnection();
        try{
            ps = base.prepareStatement("INSERT INTO docente (idpersona, numlegajo, cuit, titulo, cantidadhorasasignadas, estado) VALUES(?,?,?,?,?,?,?)");
            //falta la clase persona
            ps.setInt(1, this.persona.getIdpersona);
            ps.setInt(2, numlegajo);
            ps.setString(3, titulo);
            ps.setInt(4, cantidadhorasasignadas);
            ps.setString(5, estado);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Docente guardada");
        } catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e, "Error al guardar Docente",1);
        }
    } 
    
    public void EliminarDocente(){                                           
        ConexionBase conectar = new ConexionBase();
        Connection base=conectar.getConnection();
        try{
            ps = base.prepareStatement("DELETE FROM docente WHERE id=?");
            ps.setInt(1, iddocente);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Docente eliminado");
        } catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e, "Error al eliminar la Docente",1);
        }  
    }
    
    public void ModificaDocente() {                                            
        //Modifica segu el id de la funcion, para otro modificar
        ConexionBase conectar = new ConexionBase();
        Connection base=conectar.getConnection();
        try{
            ps = base.prepareStatement("UPDATE docente SET idpersona=?, numlegajo=?, cuit=?, titulo=?, cantidadhorasasignadas=?, estado=? WHERE iddocente='"+this.iddocente+"'");
            ps.setInt(1, this.persona.getIdpersona);
            ps.setInt(2, numlegajo);
            ps.setString(3, titulo);
            ps.setInt(4, cantidadhorasasignadas);
            ps.setString(5, estado);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos del Docente modificados");      
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e, "Error al modificar el Docente",1);
        }
    }
    
    
    
    
}
