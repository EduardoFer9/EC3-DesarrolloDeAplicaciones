package idat.edu.pe.EC3.DesarrolloDeAplicaciones.model;

public class calculadoraModel {

    public double calcularComision(double ventas) {
        if (ventas < 1000) return ventas * 0.03;
        else if (ventas <= 5000) return ventas * 0.05;
        else if (ventas <= 10000) return ventas * 0.07;
        else return ventas * 0.10;
    }

    public int calcularDescuento(int antiguedad) {
        if (antiguedad < 1) return 2;
        else if (antiguedad <= 3) return 5;
        else if (antiguedad <= 5) return 8;
        else return 12;
    }

    public int calcularBonificacion(int dias) {
        if (dias < 7) return 10;
        else if (dias <= 15) return 5;
        else return 0;
    }

    public double calcularImpuesto(String categoria, double precioBase) {
        double impuesto;
        switch (categoria.toLowerCase()) {
            case "electronica":
                impuesto = 0.15;
                break;
            case "alimentos":
                impuesto = 0.05;
                break;
            case "ropa":
                impuesto = 0.08;
                break;
            case "muebles":
                impuesto = 0.10;
                break;
            default:
                impuesto = 0.00;
        }
        return precioBase + (precioBase * impuesto);
    }
}
