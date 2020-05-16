

/*
 2-. Una agencia de llamadas necesita saber el precio por las llamadas telefónicas realizadas por sus clientes y así poder
calcular el monto a pagar. Para ello se solicita realizar un programa en Java que determine el monto a pagar por una
llamada telefónica y que luego diga la cantidad de billetes y monedas a pagar por el cliente teniendo en cuenta lo siguiente:
Una llamada que dura hasta 3 minutos tiene un costo de 20 centavos, por cada minuto adicional que dura la llamada
se le sumará un monto de 0.5 centavos adicionales, por lo tanto se debe leer el tiempo de la llamada.
El programa deberá de imprimir el número de billetes y de monedas que el usuario debe de pagar por el servicio de la llamada
realizada. Por ejemplo si el usuario tiene que pagar $15.50

el programa deberá de imprimir lo siguiente: 1 billete de diez dólares, un billete de cinco dólares y dos monedas de
veinticinco centavos.
Monedas: 1, 5,10 y 25 centavos
Billetes: 1, 5, 10, 20 dólares
Considere que debe darse la menor cantidad de billetes y monedas posibles.
El nombre de la clase creada será: BilletesYMonedas.
 */

package ejemplos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class BilletesYMonedas {
    
    public static void main(String[] args) {
        // Instancia para lectura desde teclado
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        // Variables
        try {
            System.out.println("Digite la duracion de la llamada: ");
            int duracion = Integer.parseInt(leer.readLine());
            double costo = 0.20;
            
            numeroDeBillete(duracion, costo); //Llamado de metodo
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void numeroDeBillete(int duracion, double costo){
        
        NumberFormat formato = new DecimalFormat();
        
        double total = 0;
        if (duracion <= 3) {
        total = costo*duracion;
            System.out.println("el costo de la llamada es: $"+formato.format(total));
        
        }else if(duracion > 3){
            total = costo + 0.5 * duracion;
            System.out.println("El costo de la llamada es: $"+formato.format(total));
    }
        System.out.println("===================================================");
        // variable que contendra el valor a devolver
        double importe=0;
        
        do{
            try{
                importe = total;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        
        while(importe<=0);
 
        calcular(importe);
    }
 
    public static void calcular(double importe)
    {
        // Indicamos todas las monedas posibles
        double [] monedas={20, 10, 5, 1, 0.25, 0.10, 0.05, 0.01};
 
        // Este array contendra las monedas a devolver
        double [] devolver={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
 
        // Recorremos todas las monedas
        for(int i=0;i<monedas.length;i++)
        {
            // Si el importe actual, es superior a la moneda
            if(importe>=monedas[i])
            {
                // obtenemos cantidad de monedas
                devolver[i]=Math.floor(importe/monedas[i]);
 
                // actualizamos el valor del importe que nos queda por didivir
                importe=importe-(devolver[i]*monedas[i]);
            }
        }
 
        // Bucle para mostrar el resultado
        for(int i=0;i<monedas.length;i++)
        {
            if(devolver[i]>0)
            {
                if(monedas[i]>2)
                {
                    // Indica billetes
                    System.out.println("Seran "+devolver[i]+" billetes de: $"+monedas[i]+" dolar");
                }else{
                    // Indica monedas
                    System.out.println("Seran "+devolver[i]+" monedas de: $"+monedas[i]+" dolar");
                }
            }
        }
    }
    
}