
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn= new Conexion();
    
    public boolean registrarUsuario(int codigoPais, String nombres, String apellidos,String nickname, String rol, String contrasena) {
    String sql = "INSERT INTO usuario (pais_id, nombre, apellido, nickname, rol, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, codigoPais);
        ps.setString(2, nombres);
        ps.setString(3, apellidos);
        ps.setString(4, nickname);
        ps.setString(5, rol);
        ps.setString(6, contrasena);

        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
