package idat.edu.pe.EC3.DesarrolloDeAplicaciones.controller;

import idat.edu.pe.EC3.DesarrolloDeAplicaciones.model.calculadoraModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class calculadoraController {

    @GetMapping("/calculadora")
    public String mostrarFormulario() {
        return "calculadora";
    }

    @GetMapping("/calcular")
    public String calcular(@RequestParam("tipo") String tipo,
                           @RequestParam(required = false) Double ventas,
                           @RequestParam(required = false) Integer antiguedad,
                           @RequestParam(required = false) Integer dias,
                           @RequestParam(required = false) String categoria,
                           @RequestParam(required = false) Double precio,
                           Model model) {

        calculadoraModel calculadora = new calculadoraModel();
        String resultado = "";

        switch (tipo) {
            case "comision":
                resultado = "Comisión Ganada: $" + calculadora.calcularComision(ventas);
                break;
            case "descuento":
                resultado = "Descuento Aplicado: " + calculadora.calcularDescuento(antiguedad) + "%";
                break;
            case "bonificacion":
                resultado = "Bonificación Aplicada: " + calculadora.calcularBonificacion(dias) + "%";
                break;
            case "impuesto":
                double total = calculadora.calcularImpuesto(categoria, precio);
                resultado = "Total con Impuesto: $" + total;
                break;
        }

        model.addAttribute("resultado", resultado);
        return "calculadora";
    }
}
