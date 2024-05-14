
package modelo;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    
    public String encriptarConSHA256(String texto) {
        try {
            // Crear una instancia de MessageDigest con el algoritmo SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Calcular el resumen de mensaje (hash) de los bytes de la cadena de entrada
            byte[] hashBytes = md.digest(texto.getBytes());
            
            // Convertir el resumen de mensaje (hash) de bytes a una representación hexadecimal
            BigInteger hashNum = new BigInteger(1, hashBytes);
            String hashString = hashNum.toString(16);
            
            // Asegurarse de que la cadena resultante tenga 64 caracteres (para SHA-256)
            while (hashString.length() < 64) {
                hashString = "0" + hashString;
            }
            
            return hashString;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
