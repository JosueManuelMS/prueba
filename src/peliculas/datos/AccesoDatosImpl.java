package peliculas.datos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import peliculas.domain.Pelicula;
import peliculas.excepciones.*;

public class AccesoDatosImpl implements AccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx{
        var archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx{
        var archivo = new File(nombre);
        List<Pelicula> peliculas = new ArrayList<>();
        
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null){
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: "+ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: "+ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx{
        var archivo = new File(nombreArchivo);
        //Si el segundo parametro es verdadero se escribe al final del archivo
        try(var salida = new PrintWriter(new FileWriter(nombreArchivo,anexar));){
            //Escribiendo en el archivo
            salida.println(pelicula.toString());
            System.out.println("Informacio añadida"+ pelicula);
        } catch(IOException ex){
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al escribir peliculas: "+ex.getMessage());
            }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx{
        var archivo = new File(nombreArchivo);
        String resultado =null;
        try{
            var entrada = new BufferedReader(new FileReader(archivo));
        }catch(FileNotFoundException ex){
            throw new LecturaDatosEx("no se encontro la pelicula");
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
