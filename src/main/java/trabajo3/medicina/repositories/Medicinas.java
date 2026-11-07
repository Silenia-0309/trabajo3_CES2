package trabajo3.medicina.repositories;

import trabajo3.medicina.modelo.Categoria;
import trabajo3.medicina.modelo.EnumMedicina;
import trabajo3.medicina.modelo.Medicina;
import trabajo3.medicina.modelo.Tratamientos;

import java.util.Stack;

public class Medicinas {

    // Los 5 objetos Medicina, todos con los mismos tipos de enum
    public static final Medicina medicina1 = new Medicina("Amoxicilina", 12000, "Genfar", EnumMedicina.ANTIBIOTICO, Categoria.ORAL);
    public static final Medicina medicina2 = new Medicina("Azitromicina", 18000, "MK", EnumMedicina.ANTIBIOTICO, Categoria.ORAL);
    public static final Medicina medicina3 = new Medicina("Cefalexina", 15000, "La Sante", EnumMedicina.ANTIBIOTICO, Categoria.ORAL);
    public static final Medicina medicina4 = new Medicina("Doxiciclina", 9000, "Tecnoquimicas", EnumMedicina.ANTIBIOTICO, Categoria.ORAL);
    public static final Medicina medicina5 = new Medicina("Penicilina", 7000, "Pfizer", EnumMedicina.ANTIBIOTICO, Categoria.ORAL);

    // Stack con los 5 objetos
    public static final Stack<Medicina> medicinas = new Stack<>();

    // Objeto de la clase de la columna F, con los mismos tipos de enum
    public static final Tratamientos tratamiento =
            new Tratamientos("Tratamiento respiratorio", "Silenia", EnumMedicina.ANTIBIOTICO, Categoria.ORAL);

    static {
        // Se llena el Stack conteo de cada objeto con varios datos enteros
        medicina1.registrarConteo(2);
        medicina1.registrarConteo(3);

        medicina2.registrarConteo(4);
        medicina2.registrarConteo(4);
        medicina2.registrarConteo(4);

        medicina3.registrarConteo(7);

        medicina4.registrarConteo(1);
        medicina4.registrarConteo(2);
        medicina4.registrarConteo(3);
        medicina4.registrarConteo(4);

        // medicina5 queda sin datos en el Stack conteo

        // Se crea el Stack con los 5 objetos
        medicinas.push(medicina1);
        medicinas.push(medicina2);
        medicinas.push(medicina3);
        medicinas.push(medicina4);
        medicinas.push(medicina5);

        // Se agregan los 5 objetos al Deque del tratamiento
        tratamiento.agregarMedicina(medicina1);
        tratamiento.agregarMedicina(medicina2);
        tratamiento.agregarMedicina(medicina3);
        tratamiento.agregarMedicina(medicina4);
        tratamiento.agregarMedicina(medicina5);
    }

}
