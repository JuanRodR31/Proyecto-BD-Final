package Entidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    public Connection getConnection(){
        try{
            con = DriverManager.getConnection(Constantes.THINCONN, Constantes.USERNAME, Constantes.PASSWORD);
            return con;
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
}
