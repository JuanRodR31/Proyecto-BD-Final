/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entrega3proyecto;

import java.util.Scanner;

/**
 *
 * @author estudiante
 */
public class PantallaAppMusica {
    public static void main(String[] args){
        RepositorioAppMusica repoAppMusica = new RepositorioAppMusica();
        String opc;
        Scanner scanner = new Scanner(System.in);
        do{
          imprimirMenu();
          opc=scanner.nextLine();
          switch (opc) {
                case "0"->System.out.println("Adios");
                case "1"-> repoAppMusica.agregarArtista();
                case "2"->repoAppMusica.agregarAlbumOep();
                case "3"->repoAppMusica.suscribirse();
                case "4"->repoAppMusica.iniciarSesion();
                case "5"->repoAppMusica.buscarCancion();
                case "6"->repoAppMusica.agregarCancionAListaDeReproduccion();
                case "7"->repoAppMusica.modificarListaDeReproduccion();
                case "8"->repoAppMusica.simularReproducirCancion();
                case "9"-> repoAppMusica.ConsultarLibros();
                default-> System.out.println("opcion no valida");
            }             
        } while (!opc.equals("0"));
        
    }
    
    private static void imprimirMenu(){
        System.out.println ("Bienvenido");
        System.out.println ("1. Agregar artista");
        System.out.println ("2. Agregar álbum/EP completo");
        System.out.println ("3. Suscribirse");
        System.out.println ("4. Iniciar sesión");
        System.out.println ("5. Buscar canción");
        System.out.println ("6. Agregar canción a Lista de Reproducción");
        System.out.println ("7. Modificar Lista de Reproducción");
        System.out.println ("8. Simular reproducir canción");
        System.out.println ("0. Salir");
    }
}
