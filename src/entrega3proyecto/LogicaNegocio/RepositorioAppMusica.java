package entrega3proyecto.LogicaNegocio;

import modelo.Constantes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Date;

public class RepositorioAppMusica {
    public void agregarArtista(int idInterprete, String nombre, String nombreArtistico, int idPais) {
        String SQL = "INSERT INTO INTERPRETE (ID, NOMBRE, NOMBREARTISTICO, PAIS_ID) VALUES (?, ?, ?, ?)";
        try (Connection conex = DriverManager.getConnection(Constantes.THINCONN, Constantes.USERNAME, Constantes.PASSWORD);
             PreparedStatement pstmt = conex.prepareStatement(SQL)) {
            pstmt.setInt(1, idInterprete);
            pstmt.setString(2, nombre);
            pstmt.setString(3, nombreArtistico);
            pstmt.setInt(4, idPais);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Intérprete agregado exitosamente con ID: " + idInterprete);
            } else {
                System.out.println("No se pudo agregar el intérprete.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar el intérprete: " + ex.toString());
            ex.printStackTrace();
        }
    }
    public void agregarAlbumOEp(int idAlbum, String titulo, Date fechaLanzamiento, int empresaDiscograficaId, String albumOEP) {
        String SQL = "INSERT INTO ALBUM (IDALBUM, TITULO, FECHALANZAMIENTO, EMPRESADISCOGRAFICA_ID) VALUES (?, ?, ?, ?)";
        try (Connection conex = DriverManager.getConnection(Constantes.THINCONN, Constantes.USERNAME, Constantes.PASSWORD);
             PreparedStatement pstmt = conex.prepareStatement(SQL)) {
            pstmt.setInt(1, idAlbum);
            pstmt.setString(2, titulo);
            pstmt.setDate(3, fechaLanzamiento);
            pstmt.setInt(4, empresaDiscograficaId);
            pstmt.setString(5,albumOEP);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Álbum agregado exitosamente con ID: " + idAlbum);
            } else {
                System.out.println("No se pudo agregar el álbum.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar el álbum: " + ex.toString());
        }
    }
    public void crearCancion (){
        
    }
    public void asociarCancionYAlbum (int idCancion, int idAlbum){
        
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
