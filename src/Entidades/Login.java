package Entidades;


public class Login {
        private String nickname;
        private String contrasena;
        private String rol;

    public Login() {
    }

    public Login(String nickname, String contrasena, String rol) {
        this.nickname = nickname;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
