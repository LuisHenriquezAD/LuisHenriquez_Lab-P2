package lab1p2_luishenriquez;

import java.util.Scanner;

public class Lab1P2_LuisHenriquez {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = true;

        while (salir == true) {
            System.out.println("Ingrese cual ejercicio quiere hacer");
            System.out.println("{1} El método numérico de Newton-Raphson");
            System.out.println("{2} Serie de Taylor");
            System.out.println("1 o 2");
            System.out.println("{3} PARA SALIR");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el valor de A (NO PUEDE SER CERO)");
                    double a = leer.nextInt();

                    while (a == 0) {
                        System.out.println("Ingreso cero");
                        System.out.println("Ingrese el valor de A (NO PUEDE SER CERO)");
                        a = leer.nextInt();
                    }
                    System.out.println("Ingrese el valor de B");
                    double b = leer.nextInt();
                    System.out.println("Ingrese el valor de C");
                    double c = leer.nextInt();

                    double vertices = -b / (2 * a);
                    double desplazamienton = vertices - 200;
                    double desplazamientop = vertices + 200;
                    int cien = 0;

                    double solucion = negativo(a, b, c, desplazamienton, cien);
                    System.out.println("RAIZ NEGATIVO: " + solucion);

                    solucion = positivo(a, b, c, desplazamientop, cien);
                    System.out.println("RAIZ POSITIVO: " + solucion);

                    break;

                case 2:

                    System.out.println("Ingrese su valor limite : ");
                    double lim = leer.nextDouble();

                    System.out.println("Ingrese su valor a evaluar : ");
                    double eva = leer.nextDouble();
                    
                    double conta = 0;
                    double resp = 0;
                    
                    
                    double resen = sen(lim , eva, conta, resp);
                    System.out.println("SEN X :"+resen );
                    
                    double rescos = cos(lim , eva, conta, resp);
                    System.out.println("COS X :"+rescos );
                    
                    double restan = tan(lim , eva, conta, resp);
                    System.out.println("TAN X :"+restan);
                    
                    break;

                case 3:
                    salir = false;
                    break;

                default:
                    System.out.println("OPCION INVALIDA");
                    break;
            }
        }

    }

    public static double negativo(double a, double b, double c, double desplazamienton, int verificar) {
        if (verificar < -100) {
            return desplazamienton;
        } else {
            double f = a * (desplazamienton * desplazamienton) + (b * desplazamienton) + c;
            double f2 = 2 * (a * desplazamienton) + b;
            double dividir = f / f2;
            desplazamienton -= dividir;
            return negativo(a, b, c, desplazamienton, verificar - 1);
        }

    }

    public static double positivo(double a, double b, double c, double desplazamientop, int verificar) {

        if (verificar > 100) {
            return desplazamientop;
        } else {
            double F11 = a * (desplazamientop * desplazamientop) + (b * desplazamientop) + c;
            double f2 = 2 * (a * desplazamientop) + b;
            double dividir = F11 / f2;
            desplazamientop += dividir;
            return positivo(a, b, c, desplazamientop, verificar + 1);
        }

    }

    public static double sen(double n, double x, double conta, double resp) {
        if(conta == n){
            return resp;
        }
        else{
        double arriba = Math.pow(-1, conta);
        double abajo = (2 * conta) + 1;
        double factorial = factorial(abajo);
        double total = arriba / factorial;
        double lado = Math.pow(x, (2 * conta + 1));
        resp += total * lado;
        return sen(n , x, conta+1, resp);
        }
    }

    public static double cos(double n, double x, double conta, double resp) {
         if(conta == n){
            return resp;
        }
        else{
           double arriba = Math.pow(-1, conta);
           double abajo = 2 * conta;
           double factorial = factorial(abajo);
           double total = arriba / factorial;
           double lado = Math.pow(x, (2*conta));
           double respuesta = total * lado;
           resp += respuesta;
           return cos(n , x, conta+1, resp);  
         }
    }
    
    public static double tan(double n, double x, double conta, double resp) {
         if(conta == n){
            return resp;
        }
        else{
         double arriba = (2 * conta) * ((Math.pow(-4, conta)*(1 * (Math.pow(-4, conta)))));
         double abajo = 2 * conta;
         double factorial = factorial(abajo);
         double total = arriba / factorial;
         double lado = Math.pow(x, (2*conta)+1);
         double respuesta = total * lado;
         resp += respuesta;
         return tan(n , x, conta+1, resp);      
         }
    }
    
    
    public static double factorial(double x) {

        double factorial = 1;
        for (int i = 1; i <= x; i++) {
            factorial = i * factorial;
        }
    return factorial;
    }
}
