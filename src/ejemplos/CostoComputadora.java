
package ejemplos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CostoComputadora {
    public static void main(String[] args) {
     // variables
     double precioInicial, IVA = 0.13, descuento = 0.15;
     
     BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
     
     try{
         System.out.println("ingrese Precio de la computadora: ");
         precioInicial = Double.parseDouble(leer.readLine());
         
         // Instanciar o llamado de los metodos
         double montoTotalDescuento = calcularDescuento(precioInicial, IVA, descuento);
         double montoTotalIva = calcularMontoIva(precioInicial, IVA, descuento);
         double costoTotalComputadora = calcularCostoComputadora(precioInicial, IVA, descuento);
         
         //Se imprimen los resultados
         System.out.println("El valor de descuento es: $"+montoTotalDescuento + "\n");
         System.out.println("El monto total de IVA es: $"+montoTotalIva + "\n");
         System.out.println("El valor total de la computadora es: $" +costoTotalComputadora);
         
     }catch (Exception e){
         System.out.println(e.getMessage());
     }
     
    }
    public static double calcularCostoComputadora(double precioInicial, double IVA, double descuento){
    double costoComputadora;
    costoComputadora = precioInicial + (precioInicial * 0.13) - (precioInicial * 0.15);
    return costoComputadora;
    }
    
    public static double calcularDescuento(double precioInicial, double IVA, double descuento){
    double totalDescuento;
    totalDescuento = precioInicial * 0.15;
    return totalDescuento;
    }
    
    public static double calcularMontoIva(double precioInicial, double IVA, double descuento){
    double totalIva;
    totalIva = precioInicial * 0.13;
    return totalIva;
    }
    }