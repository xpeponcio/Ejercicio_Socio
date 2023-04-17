package ejercicioSocio;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
                listadoPorDNI();
                break;
                case 5:
                listadoPorAntiguedad();
                case 6:
                guardarFichero();
                break;
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
        System.out.println("Introduce el DNI del socio para modificar:");
        String dni = sc.next();
        Socio socio = new Socio(dni, "",LocalDate.now());
        int indice = socios.indexOf(socio);
        System.out.println("Introduce el nuevo nombre: ");
        String nombre = sc.next();
        socios.get(indice).nombre = nombre;
        System.out.println("Se modifico correctamente.");
    }

    private static void listadoPorDNI() {
        System.out.println("Listado de socios ordenados por DNI:");
        for (Socio socio : socios) {
            System.out.println(socio.toString());
        }
    }

    private static void listadoPorAntiguedad() {
        Comparator<Socio> comparador = new Comparator<Socio>() {
            @Override
            public int compare(Socio s1, Socio s2) {
                return s1.antiguedad() - s2.antiguedad();
            }
        };
        Collections.sort(socios, comparador);
        System.out.println("Listado de socios ordenados por antigüedad:");
        for (Socio socio : socios) {
            System.out.println(socio.toString());
        }
    }

    private static void leerFichero() {
        File fichero_socio = new File(fichero);
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fichero))) {
                socios = (ArrayList<Socio>) in.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }

    private static void guardarFichero() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichero))) {
            out.writeObject(socios);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
