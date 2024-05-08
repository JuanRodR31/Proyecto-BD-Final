/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entrega3proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author estudiante
 */
public class RepositorioAppMusica {
    public void ConsultarLibros() {
        String SQL = "SELECT BOOK_ID, TITLE, AUTHOR_LAST_NAME, AUTHOR_FIRST_NAME, RATING FROM books";
        try (Connection conex = DriverManager.getConnection(Constantes.THINCONN, Constantes.USERNAME, Constantes.PASSWORD);
             Statement stmt = conex.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                System.out.println("BOOK_ID:" + rs.getString("BOOK_ID"));
                System.out.println("TITLE:" + rs.getString("TITLE"));
                System.out.println("AUTHOR_LAST_NAME:" + rs.getString("AUTHOR_LAST_NAME"));
                System.out.println("AUTHOR_FIRST_NAME:" + rs.getString("AUTHOR_FIRST_NAME"));
                System.out.println("RATING:" + rs.getBigDecimal("RATING"));
            }
        } catch (SQLException ex) {
            System.out.println("Error de conexión: " + ex.toString());
            ex.printStackTrace();
        }
    }

    public void agregarArtista(){
        
    }
    public void agregarAlbumOep(){
        
    }
    public void suscribirse(){
        
    }
    public void iniciarSesion(){
        
    }
    public void buscarCancion(){
        
    }
    public void agregarCancionAListaDeReproduccion(){
        
    }
    public void modificarListaDeReproduccion(){
        
    }
    public void simularReproducirCancion(){
        
    }
    public void auditoria(){
        
    }
}
