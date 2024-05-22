package modelo;

import Entidades.Login;
import Conexion.Conexion;
import Entidades.Album;
import Entidades.Cancion;
import Entidades.Interprete;
import Entidades.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import javax.swing.JComboBox;

public class FuncionesDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn= new Conexion();
    
    //====================================================FUNCIONES LOGIN==========================================================================================
    public Login log(String nickname, String password) {
        Login l = new Login();
        FuncionesDAO reg= new FuncionesDAO();
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
    //====================================================FUNCIONES REGISTRO==========================================================================================
    
    public boolean registrarUsuario(Usuario usuario) {
    String sql = "INSERT INTO usuario (pais_id, nombre, apellido, nickname, rol, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, usuario.getIdPais());
        ps.setString(2, usuario.getNombre());
        ps.setString(3, usuario.getApellido());
        ps.setString(4, usuario.getNickname());
        ps.setString(5, usuario.getRol());
        ps.setString(6, usuario.getPassword());

        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public String encriptarConSHA256(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(texto.getBytes());
            BigInteger hashNum = new BigInteger(1, hashBytes);
            String hashString = hashNum.toString(16);
            while (hashString.length() < 64) {
                hashString = "0" + hashString;
            }
            return hashString;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    //====================================================FUNCIONES ADMINISTRADOR==========================================================================================
    
    //====================================================FUNCIONES OBTENER SECUENCIAS ID==========================================================================================
    
    public int obtenerProximoIdCancion() {
        int idCancion = -1;
        String sql = "SELECT cancion_seq.NEXTVAL FROM dual";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                idCancion = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idCancion;
    }
    
    public int obtenerProximoIdAlbum() {
        int idAlbum = -1;
        String sql = "SELECT album_seq.NEXTVAL FROM dual";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                idAlbum = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idAlbum;
    }
    
    public int obtenerProximoIdInteprete(){
        int idArtista = -1;
        String sql = "SELECT interprete_seq.NEXTVAL FROM dual";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                idArtista = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idArtista;
    }
    
    //====================================================FUNCIONES OBTENER ID DESDE STRING==========================================================================================
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
    //====================================================FUNCIONES RELLENAR COMBO BOX==========================================================================================
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
    
    //====================================================FUNCIONES INSERTAR DATOS EN BD==========================================================================================
    
    public boolean agregarAlbumOEp(Album album) {
        String sql = "INSERT INTO Album (IdAlbum, Titulo, fechaLanzamiento, EmpresaDiscografica_Id, tipoAlbum) VALUES (?, ?, ?, ?, ?)";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, album.getIdAlbum());
            ps.setString(2, album.getTitulo());
            ps.setDate(3, album.getFechaLanzamiento());
            ps.setInt(4, album.getIdEmpresaDiscografica());
            ps.setString(5, album.getTipoAlbum());
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
    
    
    public boolean agregarArtista(Interprete interprete) {
    String sql= "INSERT INTO interprete (Id, Nombre, NombreArtistico,  Pais_Id) values(cancion_seq.nextval,?,?,?)";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, interprete.getNombre());
        ps.setString(2, interprete.getNombreArtistico());
        ps.setInt(3, interprete.getIdPais());

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
    
    public boolean agregarCancion (Cancion cancion){
        String sql = "INSERT INTO CANCION (ID, DURACION, GENERO_ID, IDINTERPRETEPRINCIPAL) VALUES (?, ?,?,?)";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cancion.getId());
            ps.setInt(2, cancion.getDuracion());
            ps.setInt (3,cancion.getIdGenero());
            ps.setInt(4, cancion.getIdInterpretePrincipal());
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
    
    /*public boolean crearCancionYAsignarTituloYAlbum (Cancion cancion, String idiomaTitulo, String titulo,String genero, String album){
        boolean agregoTitulo= false;
        boolean agregoAlbum=false;
        int idIdioma = convertirIdidiomaAID(idiomaTitulo);
        int idInterpretePrincipal = convertirArtistaAID(cancion.getIdInterpretePrincipal());
        int idAlbum = convertirAlbumAID(album);
        int idGenero = convertirGeneroAID(genero);
        boolean agregoCancion= agregarCancion (cancion);
        if (agregoCancion){
            System.out.println("agregocancion");
            agregoTitulo =agregarTituloACancion (idIdioma, 1, titulo);
            agregoAlbum = agregarCancionAAlbum (1, idAlbum);
        }
        if (agregoCancion && agregoTitulo && agregoAlbum){
            return true;
        }
        return false;
        
    }*/
    
    public boolean agregarInterpretesXCancion(String cancion, String interprete){
        String sql= "INSERT INTO InterpretesXCancion (cancion_id, interprete_id) values(?,?)";
        try{
            int cancion_id = convertirCancionAID(cancion);
            int interprete_id = convertirArtistaAID(interprete);
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cancion_id);
            ps.setInt(2, interprete_id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       return false;
    }
}
    
    
