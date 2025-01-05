package cpjlaboratoriofinal;

import java.util.Scanner;

public class CPJLaboratorioFinal {
    public static void main(String[] args) {
        System.out.println("Cine pepito \n1.- Iniciar Catalogo de peliculas \n2.-Agregar peliculas \n3.- Listar Peliculas \n4.- Buscar Pelicula \n0.- Salir");        
        
        Scanner scanner = new Scanner(System.in);
        int eleccion1 = 0;
        boolean entradaValida= false;
        
        while (!entradaValida) {            
            System.out.println("Eliga una opcion: ");
            try {
                eleccion1 = Integer.parseInt(scanner.next());
                entradaValida=true;
            }catch(NumberFormatException e){
            System.out.println("Por favor ingrese un numero");
            scanner.next();
        }
        }
        
        
        switch (eleccion1) {
            case 1:
                //crear archivo
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 0:
                System.out.println("Cerrando...");
                System.exit(0);
                break;
            default:
                throw new AssertionError();
        }
    }
}
