
package Entidades;


public class CancionMostrable {
    private String tituloCancion;
    private String interptrete;
    private int duracion;
    private String genero;

    public CancionMostrable() {
    }

    public CancionMostrable(String tituloCancion, String interptrete, int duracion, String genero) {
        this.tituloCancion = tituloCancion;
        this.interptrete = interptrete;
        this.duracion = duracion;
        this.genero = genero;
    }

    public String getTituloCancion() {
        return tituloCancion;
    }

    public void setTituloCancion(String tituloCancion) {
        this.tituloCancion = tituloCancion;
    }

    public String getInterptrete() {
        return interptrete;
    }

    public void setInterptrete(String interptrete) {
        this.interptrete = interptrete;
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
