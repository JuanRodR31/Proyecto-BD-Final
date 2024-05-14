package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn= new Conexion();
    
    public Login log(String nickname, String password) {
        Login l = new Login();
        RegistroDAO reg= new RegistroDAO();
        password= reg.encriptarConSHA256(password);
        String sql = "SELECT * FROM USUARIO WHERE nickname = ? AND contrasena = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nickname);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                l.setNickname(rs.getString("nickname"));
                l.setContrasena(rs.getString("contrasena"));
                l.setRol(rs.getString("rol"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }
}
