package trabajo3.medicina.modelo;

import java.util.ArrayDeque;
import java.util.Deque;

public class Tratamientos {

    private String nombre;
    private String paciente;
    private EnumMedicina tipo;
    private Categoria categoria;
    // Deque para guardar los objetos de la clase Medicina
    private Deque<Medicina> medicinas = new ArrayDeque<>();

    public Tratamientos() {
    }

    public Tratamientos(String nombre, String paciente, EnumMedicina tipo, Categoria categoria) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public void setTipo(EnumMedicina tipo) {
        this.tipo = tipo;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setMedicinas(Deque<Medicina> medicinas) {
        this.medicinas = medicinas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaciente() {
        return paciente;
    }

    public EnumMedicina getTipo() {
        return tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Deque<Medicina> getMedicinas() {
        return medicinas;
    }

    // Metodo para agregar los datos al Deque de objetos Medicina
    public void agregarMedicina(Medicina medicina) {
        medicinas.add(medicina);
    }

}
