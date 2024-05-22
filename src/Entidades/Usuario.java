package Entidades;

public class Usuario {
    private String nombre;
    private String apellido;
    private String nickname;
    private String password;
    private String rol;
    private int  idPais;

    public Usuario(String nombre, String apellido, String nickname, String password, String rol, int pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname=nickname;
        this.password=password;
        this.rol=rol;
        this.idPais=pais;
    }
    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                ", pais=" + idPais +
                '}';
    }
}
