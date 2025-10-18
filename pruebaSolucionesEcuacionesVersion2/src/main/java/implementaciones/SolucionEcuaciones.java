package implementaciones;

/**
 * Clase que implementa metodos numericos para resolver sistemas de ecuaciones
 * Metodos: Eliminacion de Gauss y Gauss-Jordan con pivoteo parcial
 */
public class SolucionEcuaciones {
    
   
    // metodo 1: eliminacion de gauss con pivoteo

    
    /**
     * Resuelve un sistema de ecuaciones usando Eliminacion de Gauss con pivoteo
     * @param a Matriz ampliada del sistema de ecuaciones
     * @return Arreglo con la solucion del sistema
     */
    public double[] eliminacionGauss(double[][] a) {
        int n = a.length;
        
        // Etapa 1: Eliminacion hacia adelante
        eliminacionAdelante(a);
        
        // Etapa 2: Sustitucion hacia atras
        double[] x = new double[n];
        return sustitucionAtras(a, x);
    }
    
    /**
     * Hace la eliminacion hacia adelante con pivoteo parcial
     * Convierte la matriz en triangular superior
     * @param a Matriz ampliada del sistema
     */
    public void eliminacionAdelante(double[][] a) {
        int n = a.length;
        
        for (int i = 0; i < n - 1; i++) {
            // Aplicar pivoteo parcial
            pivotea(a, i);
            
            // Verificar que el pivote no sea cero
            if (Math.abs(a[i][i]) < 1e-10) {
                throw new ArithmeticException("Sistema singular");
            }
            
            // Hacer ceros debajo del pivote
            for (int j = i + 1; j < n; j++) {
                double factor = a[j][i] / a[i][i];
                
                for (int k = i; k <= n; k++) {
                    a[j][k] = a[j][k] - factor * a[i][k];
                }
            }
        }
    }
    
    /**
     * Busca el elemento mas grande en la columna y lo pone como pivote
     * Esto mejora la estabilidad numerica del metodo
     * @param a Matriz ampliada
     * @param i Fila actual
     */
    public void pivotea(double[][] a, int i) {
        int n = a.length;
        int filaPivote = i;
        double maxValor = Math.abs(a[i][i]);
        
        // Buscar el elemento mas grande en la columna
        for (int k = i + 1; k < n; k++) {
            if (Math.abs(a[k][i]) > maxValor) {
                maxValor = Math.abs(a[k][i]);
                filaPivote = k;
            }
        }
        
        // Intercambiar filas si se encontro uno mas grande
        if (filaPivote != i) {
            double[] temp = a[i];
            a[i] = a[filaPivote];
            a[filaPivote] = temp;
        }
    }
    
    /**
     * Resuelve el sistema triangular superior usando sustitucion hacia atras
     * Calcula los valores de las incognitas desde la ultima hasta la primera
     * @param a Matriz triangular superior
     * @param x Arreglo donde se guarda la solucion
     * @return Solucion del sistema
     */
    public double[] sustitucionAtras(double[][] a, double[] x) {
        int n = a.length;
        
        // Verificar que el ultimo pivote no sea cero
        if (Math.abs(a[n-1][n-1]) < 1e-10) {
            throw new ArithmeticException("Sistema singular");
        }
        
        // Calcular la ultima variable
        x[n - 1] = a[n - 1][n] / a[n - 1][n - 1];
        
        // Calcular las demas variables de abajo hacia arriba
        for (int i = n - 2; i >= 0; i--) {
            double suma = 0.0;
            
            for (int j = i + 1; j < n; j++) {
                suma += a[i][j] * x[j];
            }
            
            x[i] = (a[i][n] - suma) / a[i][i];
        }
        
        return x;
    }
    

    // metodo 2: gauss-jordan con pivoteo

    
    /**
     * Resuelve un sistema de ecuaciones usando Gauss-Jordan con pivoteo
     * Convierte la matriz en forma diagonal para obtener la solucion directamente
     * @param a Matriz ampliada del sistema de ecuaciones
     * @return Arreglo con la solucion del sistema
     */
    public double[] gaussJordan(double[][] a) {
        int n = a.length;
        
        // Proceso de Gauss-Jordan
        for (int i = 0; i < n; i++) {
            // Aplicar pivoteo parcial
            pivotea(a, i);
            
            // Verificar que el pivote no sea cero
            if (Math.abs(a[i][i]) < 1e-10) {
                throw new ArithmeticException("Sistema singular");
            }
            
            // Normalizar la fila para que el pivote sea igual a 1
            double pivote = a[i][i];
            for (int j = 0; j <= n; j++) {
                a[i][j] = a[i][j] / pivote;
            }
            
            // Hacer ceros arriba y abajo del pivote
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = a[k][i];
                    for (int j = 0; j <= n; j++) {
                        a[k][j] = a[k][j] - factor * a[i][j];
                    }
                }
            }
        }
        
        // Extraer la solucion de la ultima columna
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = a[i][n];
        }
        
        return x;
    }
    

    // Metodos auxiliares

    
    /**
     * Muestra la matriz ampliada con 6 decimales
     * @param a Matriz ampliada
     * @return Texto con la matriz formateada
     */
    public String despliegaMatrizAmpliada(double[][] a) {
        StringBuilder sb = new StringBuilder();
        int n = a.length;
        
        sb.append("Matriz Ampliada:\n");
        for (int i = 0; i < n; i++) {
            sb.append("[ ");
            for (int j = 0; j <= n; j++) {
                if (j == n) {
                    sb.append("| ");
                }
                sb.append(String.format("%10.6f ", a[i][j]));
            }
            sb.append("]\n");
        }
        sb.append("\n");
        
        return sb.toString();
    }
    
    /**
     * Muestra la solucion del sistema con 6 decimales
     * @param x Arreglo con la solucion
     * @return Texto con la solucion formateada
     */
    public String despliegaSolucion(double[] x) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Solucion del sistema:\n");
        for (int i = 0; i < x.length; i++) {
            sb.append(String.format("x%d = %10.6f\n", (i + 1), x[i]));
        }
        sb.append("\n");
        
        return sb.toString();
    }
    
    /**
     * Crea una copia de la matriz para no modificar la original
     * @param original Matriz a copiar
     * @return Copia de la matriz
     */
    public double[][] copiarMatriz(double[][] original) {
        int filas = original.length;
        int columnas = original[0].length;
        double[][] copia = new double[filas][columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                copia[i][j] = original[i][j];
            }
        }
        
        return copia;
    }
    
    
    // metodo 3: inversion de matriz con gauss-jordan
    
    
    /**
     * Invierte una matriz usando el metodo de Gauss-Jordan con pivoteo
     * @param a Matriz a invertir
     * @return Matriz inversa
     */
    public double[][] invierte(double[][] a) {
        int n = a.length;
        
        // Ampliar la matriz con la matriz identidad
        double[][] ampliada = ampliaMatriz(a);
        
        // Proceso de Gauss-Jordan para inversion
        for (int i = 0; i < n; i++) {
            // Aplicar pivoteo parcial
            pivoteaInv(ampliada, i);
            
            // Verificar que el pivote no sea cero
            if (Math.abs(ampliada[i][i]) < 1e-10) {
                throw new ArithmeticException("Matriz singular, no tiene inversa");
            }
            
            // Normalizar la fila para que el pivote sea igual a 1
            double pivote = ampliada[i][i];
            for (int j = 0; j < 2 * n; j++) {
                ampliada[i][j] = ampliada[i][j] / pivote;
            }
            
            // Hacer ceros arriba y abajo del pivote
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = ampliada[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        ampliada[k][j] = ampliada[k][j] - factor * ampliada[i][j];
                    }
                }
            }
        }
        
        // Extraer la matriz inversa (lado derecho de la matriz ampliada)
        double[][] inversa = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inversa[i][j] = ampliada[i][j + n];
            }
        }
        
        return inversa;
    }
    
    /**
     * Amplia una matriz cuadrada con la matriz identidad
     * Crea una matriz [A | I] donde A es la matriz original e I es la identidad
     * @param a Matriz a ampliar
     * @return Matriz ampliada [A | I]
     */
    public double[][] ampliaMatriz(double[][] a) {
        int n = a.length;
        double[][] ampliada = new double[n][2 * n];
        
        // Copiar la matriz original al lado izquierdo
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ampliada[i][j] = a[i][j];
            }
        }
        
        // Agregar la matriz identidad al lado derecho
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    ampliada[i][j + n] = 1.0;
                } else {
                    ampliada[i][j + n] = 0.0;
                }
            }
        }
        
        return ampliada;
    }
    
    /**
     * Busca el elemento mas grande en la columna y lo pone como pivote
     * Version para matrices ampliadas en el proceso de inversion
     * @param ampliada Matriz ampliada [A | I]
     * @param i Fila actual
     */
    public void pivoteaInv(double[][] ampliada, int i) {
        int n = ampliada.length;
        int filaPivote = i;
        double maxValor = Math.abs(ampliada[i][i]);
        
        // Buscar el elemento mas grande en la columna
        for (int k = i + 1; k < n; k++) {
            if (Math.abs(ampliada[k][i]) > maxValor) {
                maxValor = Math.abs(ampliada[k][i]);
                filaPivote = k;
            }
        }
        
        // Intercambiar filas si se encontro uno mas grande
        if (filaPivote != i) {
            double[] temp = ampliada[i];
            ampliada[i] = ampliada[filaPivote];
            ampliada[filaPivote] = temp;
        }
    }
    
    /**
     * Muestra una matriz cuadrada con 6 decimales
     * @param a Matriz a desplegar
     * @return Texto con la matriz formateada
     */
    public String despliegaMatriz(double[][] a) {
        StringBuilder sb = new StringBuilder();
        int n = a.length;
        
        for (int i = 0; i < n; i++) {
            sb.append("[ ");
            for (int j = 0; j < a[i].length; j++) {
                sb.append(String.format("%10.6f ", a[i][j]));
            }
            sb.append("]\n");
        }
        sb.append("\n");
        
        return sb.toString();
    }
}