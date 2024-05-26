package Entidades;


public class CancionXPlaylistMostrable {
    private int posicion;
    private String nombreCancion;
    private String artista;
    private int duracion;
    private String genero;

    public CancionXPlaylistMostrable() {
    }

    public CancionXPlaylistMostrable(int posicion, String nombreCancion, String artista, int duracion, String genero) {
        this.posicion = posicion;
        this.nombreCancion = nombreCancion;
        this.artista = artista;
        this.duracion = duracion;
        this.genero = genero;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
