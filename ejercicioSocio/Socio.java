package ejercicioSocio;

import java.io.Serializable;
import java.time.LocalDate;

public class Socio implements Serializable{
    
    String dni;
    String nombre;
    LocalDate fechaAlta;

    public Socio(String dni2, String nombre2, LocalDate fechaAlta) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }

    public boolean equals(Object otro){

        Socio otroSocio = (Socio)otro;

        boolean iguales;
        if(this.nombre.equals(otroSocio.nombre) && this.dni.equals(otroSocio.dni) && this.fechaAlta == otroSocio.fechaAlta){
            iguales = true;

        }else{
            iguales = false;
        }
        return iguales;
    }

    public int compareTo(Object otro){
        Socio otroSocio = (Socio)otro;   
        return this.dni.compareTo(otroSocio.dni);
    }

    public int antiguedad(){
        return LocalDate.now().getYear() - fechaAlta.getYear();
    }

    public String toString(){
        return "DNI: "+dni+ " Nombre: "+nombre;
        }
}
