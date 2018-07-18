package conexiones;

import java.sql.*;
import javax.swing.*;

public class ConexionBase {
    
    public static Connection conexion = null;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "programadoresisi";
    private static final String password = "isi111mil";
    private static final String url = "jdbc:mysql://db4free.net:3306/bdcolegio";
    
    public ConexionBase(){
        //Este metodo es para verificar si se realizo una conexion nada mas
        //conn=null; public ConexionRemota(){
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url,user,password);
            if(conexion!=null){
                JOptionPane.showMessageDialog(null,"Conexion Establecida");
            }
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Error de conexion"+e);
        }
    }
    //el siguiente metodo retorna la conecion
    public Connection getConnection(){
        return conexion;
    }
    //con el siguiente metodo nos desconectamos de la base de datos
    public void desconectar(){
        conexion=null;
        if(conexion==null){
            JOptionPane.showMessageDialog(null,"Conexion Terminada");
        }
    }
}
