/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entrega3proyecto.LogicaNegocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author estudiante
 */
public class PantallaAppMusica {
    public static void main(String[] args){
        int codArtista=1000;
        int idAlbum=100;
        
        RepositorioAppMusica repoAppMusica = new RepositorioAppMusica();
        String opc;
        Scanner scanner = new Scanner(System.in);
        do{
          imprimirMenu();
          opc=scanner.nextLine();
          switch (opc) {
                case "0"->System.out.println("Adios");
                case "1"-> agregarArtista(repoAppMusica, codArtista);
                case "2"-> agregarAlbumOep(repoAppMusica, idAlbum);
                case "3"->repoAppMusica.suscribirse();
                case "4"->repoAppMusica.iniciarSesion();
                case "5"->repoAppMusica.buscarCancion();
                case "6"->repoAppMusica.agregarCancionAListaDeReproduccion();
                case "7"->repoAppMusica.modificarListaDeReproduccion();
                case "8"->repoAppMusica.simularReproducirCancion();
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
    private static void agregarArtista (RepositorioAppMusica repo,int codArtista){
         Scanner scanner = new Scanner(System.in);
         System.out.println ("ingrese el nombre del artista:");
         String nombre=scanner.nextLine();
         System.out.println ("ingrese el nombre artistico:");
         String nombreArtistico=scanner.nextLine();
         System.out.println ("ingrese el id del pais del artista:");
         int idPais =Integer.parseInt(scanner.nextLine());
         repo.agregarArtista(codArtista,nombre, nombreArtistico,idPais);
    }
    private static void agregarAlbumOep(RepositorioAppMusica repo, int idAlbum){
        Scanner scanner = new Scanner(System.in);
        System.out.println ("ingrese el titulo del Album o EP: ");
        String titulo=scanner.nextLine();
        System.out.println ("ingrese la fecha de lanzamiento del Album o EP en formato dd-MM-yyyy: ");
        String fechaLanzamiento=scanner.nextLine();
        Date fechaL= convertirFecha (fechaLanzamiento);
        System.out.println ("ingrese id de la empresa discografica: ");
        int idEmpresaDiscografica =Integer.parseInt(scanner.nextLine());
        repo.agregarAlbumOEp(idAlbum, titulo,fechaL,idEmpresaDiscografica);
        
    }
    private static Date convertirFecha(String fechaString) {
        try {
            // Formato de fecha
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

            // Convertir la cadena a un objeto Date
            java.util.Date fechaUtil = formato.parse(fechaString);

            // Convertir de java.util.Date a java.sql.Date
            return new Date(fechaUtil.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}
