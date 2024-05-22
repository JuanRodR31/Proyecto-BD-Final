/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

public class Interprete {
    private int id;
    private String nombre;
    private String nombreArtistico;
    private int idPais;

    public Interprete(int id, String nombre, String nombreArtistico, int pais) {
        this.id = id;
        this.nombre=nombre;
        this.nombreArtistico=nombreArtistico;
        this.idPais=pais;
    }

    public Interprete() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    @Override
    public String toString() {
        return "Interprete{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nombreArtistico='" + nombreArtistico + '\'' +
                ", pais=" + idPais +
                '}';
    }
}
