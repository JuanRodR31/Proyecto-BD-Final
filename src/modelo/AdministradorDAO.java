/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author juanl
 */
public class AdministradorDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn= new Conexion();
    public void rellenarPaises (JComboBox comboBox){
        String sql= "SELECT * FROM PAIS";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                comboBox.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
    }
    
    public int convertirPaisAID (String nombrePais){
        String sql = "SELECT id FROM pais WHERE nombre = ?";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombrePais);
            rs = ps.executeQuery();
            if (rs.next()){
                int idPais = rs.getInt("id");
                return idPais;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
    public boolean agregarAlbumOEp(int idAlbum, String titulo, Date fechaLanzamiento, int empresaDiscograficaId, String albumOEP) {
        String sql = "INSERT INTO ALBUM (IDALBUM, TITULO, FECHALANZAMIENTO, EMPRESADISCOGRAFICA_ID, tipoalbum ) VALUES (?, ?, ?, ?,?)";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idAlbum);
            ps.setString(2, titulo);
            ps.setDate(3, fechaLanzamiento);
            ps.setInt(4, empresaDiscograficaId);
            ps.setString(5,albumOEP);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar el álbum: " + ex.toString());
        }
        return false;
    }
    
    public void rellenarEmpresasDiscograficas (JComboBox comboBox){
        String sql= "SELECT * FROM EMPRESADISCOGRAFICA";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                comboBox.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public void rellenarIdiomas (JComboBox comboBox){
        String sql= "SELECT * FROM idioma";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                comboBox.addItem(rs.getString("NOMBREIDIOMA"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public void rellenarGeneros (JComboBox comboBox){
        String sql= "SELECT * FROM genero";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                comboBox.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    /*public boolean agregarArtista(int idInterprete, String nombre, String nombreArtistico, int idPais) {
        String sql = "INSERT INTO INTERPRETE (ID, NOMBRE, NOMBREARTISTICO, PAIS_ID) VALUES (?, ?, ?, ?)";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idInterprete);
            ps.setString(2, nombre);
            ps.setString(3, nombreArtistico);
            ps.setInt(4, idPais);

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar el intérprete: " + ex.toString());
            ex.printStackTrace();
        }
        return false;
    }*/
    
    public boolean agregarArtista(String nombre, String nombreArtistico, int idPais) {
    String sql = "INSERT INTO INTERPRETE (NOMBRE, NOMBREARTISTICO, PAIS_ID) VALUES (?, ?, ?)";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // Asegura que se devuelva la clave generada

        ps.setString(1, nombre);
        ps.setString(2, nombreArtistico);
        ps.setInt(3, idPais);

        int filasAfectadas = ps.executeUpdate();
        
        if (filasAfectadas > 0) {
            ResultSet rs = ps.getGeneratedKeys(); // Obtiene las claves generadas
            if (rs.next()) {
                long idInterprete = rs.getLong(1); // Obtiene el ID generado
                System.out.println("ID del intérprete agregado: " + idInterprete);
                return true;
            }
        }
        return false;
    } catch (SQLException ex) {
        System.out.println("Error al agregar el intérprete: " + ex.toString());
        return false;
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.toString());
            e.printStackTrace();
        }
    }
    
    
}

    public void rellenarCanciones(JComboBox comboBox) {
        String sql= "SELECT * FROM idiomasxcancion";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                comboBox.addItem(rs.getString("nombrecancion"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void rellenarArtistas(JComboBox comboBox) {
        String sql= "SELECT * FROM interprete";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                comboBox.addItem(rs.getString("nombreArtistico"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void rellenarAlbumes(JComboBox comboBox) {
        String sql= "SELECT * FROM album";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                comboBox.addItem(rs.getString("titulo"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public int convertirArtistaAID (String nombreArtistico){
        String sql = "SELECT id FROM interprete WHERE nombreArtistico = ?";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreArtistico);
            rs = ps.executeQuery();
            if (rs.next()){
                int idPais = rs.getInt("id");
                return idPais;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    public int convertirAlbumAID (String titulo){
        String sql = "SELECT idalbum FROM album WHERE TITULO = ?";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, titulo);
            rs = ps.executeQuery();
            if (rs.next()){
                int idPais = rs.getInt("idalbum");
                return idPais;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
    public int convertirIdidiomaAID (String nombreIdioma){
        String sql = "SELECT id FROM idioma WHERE nombreIdioma = ?";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreIdioma);
            rs = ps.executeQuery();
            if (rs.next()){
                int idPais = rs.getInt("id");
                return idPais;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    public int convertirCancionAID(String tituloCancion){
        String sql = "SELECT CANCION_ID FROM IDIOMASXCANCION WHERE NOMBRECANCION = ?";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tituloCancion);
            rs = ps.executeQuery();
            if (rs.next()){
                int idCancion = rs.getInt("CANCION_ID");
                return idCancion;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
    public int convertirGeneroAID (String nombreGenero){
        String sql = "SELECT id FROM genero WHERE nombre = ?";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreGenero);
            rs = ps.executeQuery();
            if (rs.next()){
                int idPais = rs.getInt("id");
                return idPais;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    public boolean agregarTituloACancion (int idioma, int idCancion, String tituloCancion){
        String sql = "INSERT INTO IDIOMASXCANCION (IDIOMA_ID, CANCION_ID, NOMBRECANCION) VALUES (?, ?,?)";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idioma);
            ps.setInt(2, idCancion);
            ps.setString (3,tituloCancion);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar el titulo a la cancion: " + ex.toString());
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean agregarCancion (int id, int duracion, int genero, int interpreteprincipal ){
        String sql = "INSERT INTO CANCION (ID, DURACION, GENERO_ID, IDINTERPRETEPRINCIPAL) VALUES (?, ?,?,?)";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, duracion);
            ps.setInt (3,genero);
            ps.setInt(4, interpreteprincipal);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar el la cancion: " + ex.toString());
            ex.printStackTrace();
        }
        return false;
    }
    public void agregarCancionAAlbum(){
        
    }
    public boolean agregarCancionAAlbum(int idcancion, int idAlbum){
        String sql = "INSERT INTO CANCIONESXALBUM (CANCION_ID, IDALBUM) VALUES (?, ?)";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idcancion);
            ps.setInt(2, idAlbum);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar cancion a album: " + ex.toString());
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean crearCancionYAsignarTituloYAlbum (String idiomaTitulo, String titulo, int duracion,String genero, String interPretePrincipal, String album){
        boolean agregoTitulo= false;
        boolean agregoAlbum=false;
        int idIdioma = convertirIdidiomaAID(idiomaTitulo);
        int idInterpretePrincipal = convertirArtistaAID(interPretePrincipal);
        int idAlbum = convertirAlbumAID(album);
        int idGenero = convertirGeneroAID(genero);
        boolean agregoCancion= agregarCancion (1,duracion,idGenero, idInterpretePrincipal);
        if (agregoCancion){
            System.out.println("agregocancion");
            agregoTitulo =agregarTituloACancion (idIdioma, 1, titulo);
            agregoAlbum = agregarCancionAAlbum (1, idAlbum);
        }
        if (agregoCancion && agregoTitulo && agregoAlbum){
            return true;
        }
        return false;
        
    }
    //INSERT INTO interpretesxcancion (cancion_id, interprete_id) VALUES (1, 2);
    public boolean agregarArtistaSecundarioACancion (String tituloCancion, String nombreArtistico){
        String sql = "INSERT INTO interpretesxcancion (cancion_id, interprete_id) VALUES (?, ?)";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            int idCancion = convertirCancionAID(tituloCancion);
            int idArtista = convertirArtistaAID(nombreArtistico);
            ps.setInt(1, idCancion);
            ps.setInt(2, idArtista);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar el intérprete secundario: " + ex.toString());
            ex.printStackTrace();
        }
        return false;
    }
}
