package implementaciones;

public class Interpolacion {
    
    /**
     * Muestra una tabla con las coordenadas de los n mas 1 puntos
     * puntos - Arreglo bidimensional con los puntos x e y
     * n - Grado del polinomio de Lagrange
     * Regresa un String con la tabla formateada
     */
    public static String despliegaPuntos(double puntos[][], int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-15s %-15s\n", "X", "Y"));
        sb.append("--------------------------------\n");
        
        // Recorre todos los puntos y los agrega a la tabla
        for (int i = 0; i <= n; i++) {
            sb.append(String.format("%-15.6f %-15.6f\n", puntos[i][0], puntos[i][1]));
        }
        
        return sb.toString();
    }
    
    /**
     * Calcula la interpolacion usando el Metodo de Lagrange
     * puntos - Arreglo bidimensional con los n mas 1 puntos
     * n - Grado del polinomio
     * x - Valor de x donde queremos interpolar
     * Regresa el valor de y interpolado
     */
    public static double interpolacionLagrange(double puntos[][], int n, double x) {
        double resultado = 0.0;
        
        // Suma todos los terminos de Lagrange
        for (int i = 0; i <= n; i++) {
            double termino = puntos[i][1] * multiplicatoria(i, puntos, n, x);
            resultado += termino;
        }
        
        return resultado;
    }
    
    /**
     * Calcula la multiplicatoria del termino i del Metodo de Lagrange
     * i - Indice del termino actual
     * puntos - Arreglo con los n mas 1 puntos
     * n - Grado del polinomio
     * x - Valor de x donde queremos interpolar
     * Regresa el valor de la multiplicatoria calculada
     */
    public static double multiplicatoria(int i, double puntos[][], int n, double x) {
        double producto = 1.0;
        
        // Calcula el producto de los terminos cuando j es diferente de i
        for (int j = 0; j <= n; j++) {
            if (j != i) {
                producto *= (x - puntos[j][0]) / (puntos[i][0] - puntos[j][0]);
            }
        }
        
        return producto;
    }
}