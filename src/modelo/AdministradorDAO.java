/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

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
    
    public void agregarAlbumOEp(int idAlbum, String titulo, Date fechaLanzamiento, int empresaDiscograficaId, String albumOEP) {
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
                System.out.println("Álbum agregado exitosamente con ID: " + idAlbum);
            } else {
                System.out.println("No se pudo agregar el álbum.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar el álbum: " + ex.toString());
        }
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
    public void agregarArtista(int idInterprete, String nombre, String nombreArtistico, int idPais) {
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
                System.out.println("Intérprete agregado exitosamente con ID: " + idInterprete);
            } else {
                System.out.println("No se pudo agregar el intérprete.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar el intérprete: " + ex.toString());
            ex.printStackTrace();
        }
    }
    
}
