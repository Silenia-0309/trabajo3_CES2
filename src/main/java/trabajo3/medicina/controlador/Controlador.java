package trabajo3.medicina.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;

import trabajo3.medicina.modelo.EnumMedicina;
import trabajo3.medicina.modelo.Medicina;
import trabajo3.medicina.repositories.Medicinas;

@Controller
public class Controlador {

    private List<String> resultado = new ArrayList<>();

    // PUNTO1: mostrar los 5 objetos, el Stack y el tratamiento con su Deque
    @GetMapping("peticion1")
    public String peticion1(Model model) {

        resultado.clear();

        resultado.add("PUNTO 1");

        resultado.add("Stack con los 5 objetos de tipo Medicina:");
        resultado.add("Medicinas.medicinas: " + Medicinas.medicinas.toString());

        resultado.add("Objeto Tratamientos (columna F): " + Medicinas.tratamiento.getNombre());
        resultado.add("Deque de medicinas del tratamiento: " + Medicinas.tratamiento.getMedicinas().toString());

        model.addAttribute("resultado", resultado);

        return "resultado";
    }

    // PUNTO2: ListIterator sobre el Stack e Iterator sobre el Deque
    @GetMapping("peticion2")
    public String peticion2(Model model) {

        resultado.clear();

        resultado.add("PUNTO 2");

        resultado.add("ListIterator con el Stack de los 5 objetos:");

        ListIterator<Medicina> listIterator = Medicinas.medicinas.listIterator();

        while (listIterator.hasNext()) {
            Medicina medicina = listIterator.next();
            resultado.add("Nombre: " + medicina.getNombre() + ", Precio: " + medicina.getPrecio()
                    + ", Laboratorio: " + medicina.getLaboratorio() + ", Tipo: " + medicina.getTipo()
                    + ", Categoria: " + medicina.getCategoria() + ", Conteo: " + medicina.getConteo());
        }

        resultado.add("Iterator con el Deque del tratamiento:");

        Iterator<Medicina> iterator = Medicinas.tratamiento.getMedicinas().iterator();

        while (iterator.hasNext()) {
            Medicina medicina = iterator.next();
            resultado.add("Nombre: " + medicina.getNombre() + ", Precio: " + medicina.getPrecio()
                    + ", Laboratorio: " + medicina.getLaboratorio() + ", Tipo: " + medicina.getTipo()
                    + ", Categoria: " + medicina.getCategoria() + ", Conteo: " + medicina.getConteo());
        }

        model.addAttribute("resultado", resultado);

        return "resultado";
    }

    // PUNTO3: convertir el Stack en Deque y usar programacion funcional sobre el
    // Deque del tratamiento para imprimir los objetos de un enum especifico
    @GetMapping("peticion3")
    public String peticion3(Model model) {

        resultado.clear();

        resultado.add("PUNTO 3");

        Deque<Medicina> deque = new ArrayDeque<>(Medicinas.medicinas);

        resultado.add("Deque<Medicina> deque = new ArrayDeque<>(Medicinas.medicinas): " + deque.toString());

        resultado.add("Objetos del Deque del tratamiento que son de tipo ANTIBIOTICO:");

        List<Medicina> antibioticos = Medicinas.tratamiento.getMedicinas().stream()
                .filter(medicina -> EnumMedicina.ANTIBIOTICO.equals(medicina.getTipo()))
                .toList();

        for (Medicina medicina : antibioticos) {
            resultado.add(medicina.toString());
        }

        model.addAttribute("resultado", resultado);

        return "resultado";
    }

    // PUNTO4: funcion con Function<T,R> que suma los datos del Stack conteo
    static Function<Medicina, Integer> totalizarConteo = medicina -> {
        int suma = 0;
        for (Integer dato : medicina.getConteo()) {
            suma += dato;
        }
        return suma;
    };

    @GetMapping("peticion4")
    public String peticion4(Model model) {

        resultado.clear();

        resultado.add("PUNTO 4");

        int total = totalizarConteo.apply(Medicinas.medicina1);

        resultado.add("Suma de los datos del Stack conteo de medicina1: " + total);

        model.addAttribute("resultado", resultado);

        return "resultado";
    }

    // PUNTO5: llamar al metodo verTotales pasandole la funcion del PUNTO4
    @GetMapping("peticion5")
    public String peticion5(Model model) {

        resultado.clear();

        resultado.add("PUNTO 5");

        resultado.add(Medicinas.medicina1.verTotales(totalizarConteo));

        model.addAttribute("resultado", resultado);

        return "resultado";
    }

}
