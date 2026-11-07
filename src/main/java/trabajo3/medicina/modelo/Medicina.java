package trabajo3.medicina.modelo;

import java.util.Stack;
import java.util.function.Function;

public class Medicina {

    private String nombre;
    private double precio;
    private String laboratorio;
    private EnumMedicina tipo;
    private Categoria categoria;
    // El Stack conteo sirve para contar las unidades dispensadas en cada entrega
    private Stack<Integer> conteo = new Stack<>();

    public Medicina() {
    }

    public Medicina(String nombre, double precio, String laboratorio, EnumMedicina tipo, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.laboratorio = laboratorio;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public void setTipo(EnumMedicina tipo) {
        this.tipo = tipo;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setConteo(Stack<Integer> conteo) {
        this.conteo = conteo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public EnumMedicina getTipo() {
        return tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Stack<Integer> getConteo() {
        return conteo;
    }

    // Metodo para agregar los datos al Stack de numeros llamado conteo
    public void registrarConteo(int dato) {
        conteo.push(dato);
    }

    // Metodo del PUNTO5 que recibe la funcion del PUNTO4 y muestra el total
    public String verTotales(Function<Medicina, Integer> totalizar) {
        return "El total de unidades de la medicina " + nombre + " es: " + totalizar.apply(this);
    }

    @Override
    public String toString() {
        return nombre + ", $" + precio + ", " + laboratorio + ", " + tipo + ", " + categoria + ", conteo=" + conteo;
    }

}
