package Entidades;

public class Cancion {
    private int id;
    private int duracion;
    private int idGenero;
    private int idInterpretePrincipal;

    public Cancion() {
    }

    public Cancion(int id, int duracion, int idGenero, int idInterpretePrincipal) {
        this.id = id;
        this.duracion = duracion;
        this.idGenero = idGenero;
        this.idInterpretePrincipal = idInterpretePrincipal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdInterpretePrincipal() {
        return idInterpretePrincipal;
    }

    public void setIdInterpretePrincipal(int idInterpretePrincipal) {
        this.idInterpretePrincipal = idInterpretePrincipal;
    }
    
    
}
