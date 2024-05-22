package Entidades;

import java.sql.Date;

public class Album {
    private int idAlbum;
    private String titulo;
    private Date fechaLanzamiento;
    private int idEmpresaDiscografica;
    private String tipoAlbum;

    public Album(int idAlbum, String titulo, Date fechaLanzamiento, int idEmpresaDiscografica, String tipoAlbum) {
        this.idAlbum = idAlbum;
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.idEmpresaDiscografica = idEmpresaDiscografica;
        this.tipoAlbum = tipoAlbum;
    }
    
    

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public java.sql.Date getFechaLanzamiento() {
        return (java.sql.Date) fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public int getIdEmpresaDiscografica() {
        return idEmpresaDiscografica;
    }

    public void setIdEmpresaDiscografica(int idEmpresaDiscografica) {
        this.idEmpresaDiscografica = idEmpresaDiscografica;
    }

    public String getTipoAlbum() {
        return tipoAlbum;
    }

    public void setTipoAlbum(String tipoAlbum) {
        this.tipoAlbum = tipoAlbum;
    }

    

}
