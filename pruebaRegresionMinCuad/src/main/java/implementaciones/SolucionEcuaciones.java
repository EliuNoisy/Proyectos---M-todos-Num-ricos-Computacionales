package implementaciones;

/**
 * Clase que contiene metodos para resolver sistemas de ecuaciones lineales
 */
public class SolucionEcuaciones {
    
    /**
     * Resuelve un sistema de ecuaciones lineales usando el metodo de Gauss-Jordan
     * @param a Matriz ampliada del sistema de ecuaciones
     * @return Arreglo con la solucion del sistema de ecuaciones
     * @throws ArithmeticException si el sistema es singular o inconsistente
     * @throws IllegalArgumentException si las dimensiones de la matriz son incorrectas
     */
    public static double[] gaussJordan(double[][] a) {
        int n = a.length;
        double[] x = new double[n];
        
        // Validacion inicial
        if (n == 0 || a[0].length != n + 1) {
            throw new IllegalArgumentException("Dimensiones de matriz incorrectas");
        }
        
        // Proceso de eliminacion
        for (int i = 0; i < n; i++) {
            // Pivoteo parcial
            pivotea(a, i);
            
            // Verificar que el pivote no sea cero o muy pequeno
            double pivote = a[i][i];
            if (Math.abs(pivote) < 1e-12) {
                throw new ArithmeticException(
                    "Sistema singular o inconsistente. " +
                    "El pivote en la fila " + (i + 1) + " es muy pequeno: " + pivote
                );
            }
            
            // Normalizar la fila i
            for (int j = i; j <= n; j++) {
                a[i][j] /= pivote;
            }
            
            // Eliminacion hacia adelante y hacia atras
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = a[k][i];
                    for (int j = i; j <= n; j++) {
                        a[k][j] -= factor * a[i][j];
                    }
                }
            }
        }
        
        // Extraer la solucion
        for (int i = 0; i < n; i++) {
            x[i] = a[i][n];
            
            // Verificar si la solucion contiene NaN o Infinito
            if (Double.isNaN(x[i]) || Double.isInfinite(x[i])) {
                throw new ArithmeticException(
                    "La solucion contiene valores no validos (NaN o Infinito)"
                );
            }
        }
        
        return x;
    }
    
    /**
     * Realiza el pivoteo parcial para mejorar la estabilidad numerica
     * @param a Matriz ampliada del sistema
     * @param i Fila actual desde la cual se hace el pivoteo
     * @throws ArithmeticException si no se encuentra un pivote valido
     */
    private static void pivotea(double[][] a, int i) {
        int n = a.length;
        int maxRow = i;
        double maxVal = Math.abs(a[i][i]);
        
        // Buscar el valor maximo en la columna i desde la fila i hacia abajo
        for (int k = i + 1; k < n; k++) {
            double absVal = Math.abs(a[k][i]);
            if (absVal > maxVal) {
                maxVal = absVal;
                maxRow = k;
            }
        }
        
        // Verificar que se encontro un pivote valido
        if (maxVal < 1e-12) {
            throw new ArithmeticException(
                "No se encontro pivote valido en la columna " + (i + 1) + 
                ". El sistema puede ser singular."
            );
        }
        
        // Intercambiar filas si es necesario
        if (maxRow != i) {
            double[] temp = a[i];
            a[i] = a[maxRow];
            a[maxRow] = temp;
        }
    }
}