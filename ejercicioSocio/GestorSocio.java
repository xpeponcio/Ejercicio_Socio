package ejercicioSocio;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorSocio {

    private static final String fichero = "socios.dat";
    private static ArrayList<Socio> socios = new ArrayList<>();
    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("Menu de opciones: ");
            System.out.println("1. Alta");
            System.out.println("2. Baja");
            System.out.println("3. Modificacion");
            System.out.println("4. Listado por DNI");
            System.out.println("5. Listado por antiguedad");
            System.out.println("6. Salir");
            System.out.println("1. Introduce una opcion: ");
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                alta();
                break;
                case 2:
                baja();
                break;
                case 3:
                modificacion();
                break;
                case 4:

                case 5:

                case 6:

                default:
                System.out.println("La opcion introducida no se encuentra disponible");
            }
        }while(opcion != 6);
    }

    private static void alta(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el DNI: ");
        String dni = sc.next();
        System.out.println("Introduce el nombre: ");
        String nombre = sc.next();
        LocalDate fechaAlta = LocalDate.now();
        Socio socio = new Socio(dni, nombre, fechaAlta);
    }

    private static void baja(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el DNI para dar de baja: ");
        String dni = sc.next();
        Socio socio = new Socio(dni, "", LocalDate.now());
        System.out.println("Se ha dado de baja");
    }

    private static void modificacion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("");
    }

}
