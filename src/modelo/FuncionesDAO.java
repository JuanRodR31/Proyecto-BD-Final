package modelo;

import Entidades.Login;
import Conexion.Conexion;
import Entidades.Album;
import Entidades.Auditoria;
import Entidades.Cancion;
import Entidades.CancionMostrable;
import Entidades.CancionXPlaylist;
import Entidades.CancionXPlaylistMostrable;
import Entidades.Interprete;
import Entidades.Playlist;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class FuncionesDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn= new Conexion();
    
    //====================================================FUNCIONES LOGIN==========================================================================================
    public Login log(String nickname, String password) {
        Login l = new Login();
        password= encriptarConSHA256(password);
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
    public boolean insertarSuscripcionXUsuarioPremium (String nickname, int tipoSuscripcion, long numeroTarjeta){
        String sql= "INSERT INTO SUSCRIPCIONXUSUARIO VALUES (?,?,?,?,?)";
        try{
            Date fechaHoy = Date.valueOf(LocalDate.now());
            Date fechaProximoMes = Date.valueOf(LocalDate.now().plusMonths(1));
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDate(1, fechaHoy);
            ps.setDate(2, fechaProximoMes);
            ps.setString(3, nickname);
            ps.setInt(4, tipoSuscripcion);
            ps.setLong(5, numeroTarjeta);
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
    //====================================================FUNCIONES RELLENAR TABLAS==========================================================================================
    public List<Auditoria> obtenerListaAuditoria(){
        List<Auditoria> auditorias = new ArrayList<>();
        String sql= "SELECT * FROM auditoria";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Auditoria auditoria = new Auditoria();
                auditoria.setIdItemModificado(rs.getInt("elemento_id"));
                auditoria.setTabla(rs.getString("tabla"));
                auditoria.setTipoModificacion(rs.getString("OPERACION"));
                auditoria.setFechaHora(rs.getTimestamp("FECHA_HORA"));
                auditorias.add(auditoria);
            }  
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return auditorias;
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
                return true;
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
    
    public boolean crearCancionYAsignarTituloYAlbum ( String idiomaTitulo, String titulo,int duracion, String genero,String interpretePrincipal, String album){
        boolean agregoTitulo= false;
        boolean agregoAlbum=false;
        int idIdioma = convertirIdidiomaAID(idiomaTitulo);
        int idInterpretePrincipal = convertirArtistaAID(interpretePrincipal);
        int idAlbum = convertirAlbumAID(album);
        int idGenero = convertirGeneroAID(genero);
        int idCancion = obtenerProximoIdCancion();
        Cancion cancion = new Cancion (idCancion, duracion, idGenero, idInterpretePrincipal);
        System.out.println(cancion);
        boolean agregoCancion= agregarCancion (cancion);
        if (agregoCancion){
            System.out.println("agregocancion");
            agregoTitulo =agregarTituloACancion (idIdioma, idCancion, titulo);
            agregoAlbum = agregarCancionAAlbum (idCancion, idAlbum);
        }
        if (agregoCancion && agregoTitulo && agregoAlbum){
            return true;
        }
        return false;
    }
    
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
    
    public void insertarSuscripcionXUsuario(String nickname, int tipoSuscripcion){
        String sql= "INSERT INTO SUSCRIPCIONXUSUARIO (USUARIO_NICKNAME, SUSCRIPCION_ID) values(?,?)";
        try{
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nickname);
            ps.setInt(2, tipoSuscripcion);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //=============================================================FUNCIONES USUARIO=======================================================================================
    public List<Cancion> obtenerListaCanciones(){
        List<Cancion> canciones = new ArrayList<>();
        String sql= "SELECT * FROM cancion";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cancion c= new Cancion();
                c.setId(rs.getInt("id"));
                c.setDuracion(rs.getInt("duracion"));
                c.setIdGenero(rs.getInt("genero_id"));
                c.setIdInterpretePrincipal(rs.getInt("idinterpreteprincipal"));
                canciones.add(c);
            }  
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return canciones;
    }
    
    
    public List<Integer> obtenerIDsCancionesConTituloLike (String tituloCancion){
        List<Integer> auxIDs= new ArrayList();
        String sql = "SELECT CANCION_ID FROM IDIOMASXCANCION WHERE UPPER(NOMBRECANCION) LIKE ?";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + tituloCancion.toUpperCase() + "%");
            rs = ps.executeQuery();
            while (rs.next()){
                int idCancion = rs.getInt("CANCION_ID");
                auxIDs.add(idCancion);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return auxIDs;
    }
    public List<Cancion> obtenerCancionesPorIds(String tituloCancion) {
        List<Cancion> canciones = new ArrayList<>();
        List<Integer> ids= obtenerIDsCancionesConTituloLike (tituloCancion);
        StringBuilder sql = new StringBuilder("SELECT ID, DURACION, GENERO_ID, IDINTERPRETEPRINCIPAL FROM CANCION WHERE ID IN (");
        for (int i = 0; i < ids.size(); i++) {
            sql.append("?");
            if (i < ids.size() - 1) {
                sql.append(",");
            }
        }
        sql.append(")");

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql.toString());
            for (int i = 0; i < ids.size(); i++) {
                ps.setInt(i + 1, ids.get(i));
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                int duracion = rs.getInt("DURACION");
                int idGenero = rs.getInt("GENERO_ID");
                int idInterpretePrincipal = rs.getInt("IDINTERPRETEPRINCIPAL");
                canciones.add(new Cancion(id, duracion, idGenero, idInterpretePrincipal));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return canciones;
    }
    
    private String convertirIdCancionATitulo(int idCancion){
        String sql = "SELECT nombrecancion FROM idiomasxcancion WHERE cancion_id = ?";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCancion);
            rs = ps.executeQuery();
            if (rs.next()){
                String titulo = rs.getString("nombrecancion");
                return titulo;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
    private String convertirIdGeneroANombre(int idGenero){
        String sql = "SELECT nombre FROM genero WHERE id = ?";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idGenero);
            rs = ps.executeQuery();
            if (rs.next()){
                String nombre = rs.getString("nombre");
                return nombre;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
    private String convertirIdInterpreteAString(int idInterprete){
        String sql = "SELECT nombreArtistico FROM interprete WHERE id = ?";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idInterprete);
            rs = ps.executeQuery();
            if (rs.next()){
                String nombre = rs.getString("nombreArtistico");
                return nombre;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
    
    public List<CancionMostrable> obtenerListaCancionesMostrables(List<Cancion> canciones){
        List<CancionMostrable> ListaAux= new ArrayList<>();
        for (Cancion c: canciones){
            
            String tituloCancion = convertirIdCancionATitulo(c.getId());
            int duracionCancion = c.getDuracion();
            String generoCancion = convertirIdGeneroANombre(c.getIdGenero());
            String artista = convertirIdInterpreteAString(c.getIdInterpretePrincipal());
            CancionMostrable cm= new CancionMostrable(tituloCancion, artista, duracionCancion, generoCancion);
            ListaAux.add(cm);
        }
        return ListaAux;
    }
    
    
    public List<Auditoria> obtenerListaCancionesPlaylist(){
        List<Auditoria> auditorias = new ArrayList<>();
        String sql= "SELECT * FROM auditoria";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Auditoria auditoria = new Auditoria();
                auditoria.setIdItemModificado(rs.getInt("elemento_id"));
                auditoria.setTabla(rs.getString("tabla"));
                auditoria.setTipoModificacion(rs.getString("OPERACION"));
                auditoria.setFechaHora(rs.getTimestamp("FECHA_HORA"));
                auditorias.add(auditoria);
            }  
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return auditorias;
    }
    
    public List <Playlist> bucarPlaylistsUsuario (String nickname){
      List <Playlist> listAux= new ArrayList();
        String sql= "SELECT * FROM LISTAREPRODUCCION WHERE usuario_nickname = ?";
        try {
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nickname);
            rs = ps.executeQuery();
            while (rs.next()) {
                Playlist playlist= new Playlist();
                playlist.setId(rs.getInt("id"));
                playlist.setNombre(rs.getString("nombre"));
                playlist.setTipo(rs.getString("tipo"));
                listAux.add(playlist);
            }  
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return listAux;
    }
    
    public boolean validarLike(String tituloCancion, String username){
        String sql = "SELECT COUNT(*) AS cantidad FROM CANCIONESLIKEXUSUARIO WHERE CANCION_ID = ? AND USUARIO_NICKNAME = ?";
        int cantidad=0;
        try{
            int cancion_id = convertirCancionAID(tituloCancion);
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cancion_id);
            ps.setString(2, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt("cantidad");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cantidad > 0;
    }
    public boolean añadirLikesDelUsuario (String tituloCancion, String username){
        String sql= "INSERT INTO CANCIONESLIKEXUSUARIO VALUES (?,?)";
        try{
            int cancion_id = convertirCancionAID(tituloCancion);
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setInt(2, cancion_id);
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
    public boolean quitarLikeDelUsuario(String tituloCancion, String username){
        String sql = "DELETE FROM CANCIONESLIKEXUSUARIO WHERE CANCION_ID = ? AND USUARIO_NICKNAME = ?";
        try{
            int cancion_id = convertirCancionAID(tituloCancion);
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cancion_id);
            ps.setString(2, username);
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
    public boolean anadirCancionAPlaylist (CancionXPlaylist cancionPlaylist){
        String sql= "INSERT INTO CANCIONESXLISTAS VALUES (?,?,?,?)";
        try{
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cancionPlaylist.getIdCancion());
            ps.setString(2,cancionPlaylist.getNombreLista());
            ps.setInt(3, cancionPlaylist.getIdPlaylist());
            ps.setInt(4, cancionPlaylist.getPosicion());
            System.out.println(cancionPlaylist.getIdPlaylist());
            
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
    public boolean cambiarNombrePlaylist(String nombreNuevo, int idPlaylist){
        String sql = "UPDATE LISTAREPRODUCCION SET NOMBRE = ? WHERE ID = ?";
        try{
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreNuevo);
            ps.setInt(2, idPlaylist);
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
    /*public List<CancionXPlaylistMostrable> obtenerCancionesDeListaReproduccion(String nombreLista, int idLista) {
        List<CancionXPlaylistMostrable> lcxp= new ArrayList<>();
        List<CancionMostrable> ListaAux= new ArrayList<>();
        for (Cancion c: canciones){
            
            String tituloCancion = convertirIdCancionATitulo(c.getId());
            int duracionCancion = c.getDuracion();
            String generoCancion = convertirIdGeneroANombre(c.getIdGenero());
            String artista = convertirIdInterpreteAString(c.getIdInterpretePrincipal());
            CancionMostrable cm= new CancionMostrable(tituloCancion, artista, duracionCancion, generoCancion);
            ListaAux.add(cm);
        }
        return lcxp;
    }*/
    
    public List<CancionXPlaylistMostrable> obtenerCancionesDeListaReproduccion(String nombreUsuario, int idLista) {
        List<CancionXPlaylistMostrable> canciones = new ArrayList<>();
        String sql = "SELECT cl.posicion, ic.nombrecancion AS nombre, i.nombreartistico AS artista, c.duracion, g.nombre AS genero " +
                     "FROM cancionesxlistas cl " +
                     "JOIN cancion c ON cl.cancion_id = c.id " +
                     "JOIN interprete i ON c.idinterpreteprincipal = i.id " +
                     "LEFT JOIN genero g ON c.genero_id = g.id " +
                     "JOIN idiomasxcancion ic ON c.id = ic.cancion_id " +
                     "WHERE cl.listareproduccion_nickname = ? AND cl.listareproduccion_id = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setInt(2, idLista);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int posicion = rs.getInt("posicion");
                String nombreCancion = rs.getString("nombre");
                String artista = rs.getString("artista");
                int duracion = rs.getInt("duracion");
                String genero = rs.getString("genero");
                CancionXPlaylistMostrable cancion = new CancionXPlaylistMostrable(posicion, nombreCancion, artista, duracion, genero);
                canciones.add(cancion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return canciones;
    }
    
    public boolean cambiarPosicionCancion (CancionXPlaylist cancionPlaylist, int nuevaPosicion){
       String sql = "UPDATE CANCIONESXLISTAS SET POSICION = ? WHERE CANCION_ID = ? AND LISTAREPRODUCCION_NICKNAME = ? AND LISTAREPRODUCCION_ID = ?"; 
       try{
            con= cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, nuevaPosicion);
            ps.setInt(2, cancionPlaylist.getIdCancion());
            ps.setString(3, cancionPlaylist.getNombreLista());
            ps.setInt(4, cancionPlaylist.getIdPlaylist());
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
    
    
