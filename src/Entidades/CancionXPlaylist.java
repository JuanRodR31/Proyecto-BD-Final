/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author juanl
 */
public class CancionXPlaylist {
    private int idCancion;
    private String nombreLista;
    private int idPlaylist;
    private int posicion;

    public CancionXPlaylist() {
    }

    public CancionXPlaylist(int idCancion, String nombreLista, int idPlaylist, int posicion) {
        this.idCancion = idCancion;
        this.nombreLista = nombreLista;
        this.idPlaylist = idPlaylist;
        this.posicion = posicion;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
}
