
package peliculas.negocio;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    
    public void CatalogoPeliculasImpl(){
        
    }

    
    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        File archivo = new File((nombreArchivo));
        try(PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));) {
            salida.println(nombrePelicula);
            System.out.println("se añadio la pelicula");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        var archivo = new File(nombreArchivo);
        try(var entrada = new BufferedReader(new FileReader (archivo));){
            var lectura = entrada.readLine();
            while (lectura != null) {                
                System.out.println("lectura = "+lectura);
                lectura= entrada.readLine();
            }
        } catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        try(BufferedReader entrada = new BufferedReader(new FileReader(nombreArchivo))){
            String pelicula;
            boolean encontrada = false;
            while ((pelicula = entrada.readLine()) != null) {                
                if(pelicula.contains(buscar)){
                    System.out.println("Pelicula encontrada");
                    encontrada = true;
                }
            }
            if(!encontrada){
                System.out.println("La pelicula no esta en cartelera");
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        PrintWriter salida;
        try {
            salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CatalogoPeliculasImpl.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }
    
}
