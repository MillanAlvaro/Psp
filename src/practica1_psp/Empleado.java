
package practica1_psp;

import java.util.*;
public class Empleado {
    private String nombre;
    private float salario;
    private String FechaNac;

    public Empleado(String nombre, String FechaNac, float salario) {
        this.nombre = nombre;
        this.FechaNac = FechaNac;
        this.salario = salario;
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String FechaNac) {
        this.FechaNac = FechaNac;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", salario=" + salario + ", FechaNac=" + FechaNac + '}';
    }
    
    
}
