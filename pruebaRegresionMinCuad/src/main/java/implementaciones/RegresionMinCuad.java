package implementaciones;

/**
 * Clase que implementa metodos de regresion con minimos cuadrados
 */
public class RegresionMinCuad {
    
    /**
     * Despliega una tabla con las coordenadas de los puntos
     * @param puntos Arreglo bidimensional con las coordenadas (x, y) de los puntos
     * @return String con la tabla formateada
     */
    public static String despliegaPuntos(double[][] puntos) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n┌────────────┬────────────┐\n");
        sb.append("│     x      │     y      │\n");
        sb.append("├────────────┼────────────┤\n");
        
        for (double[] punto : puntos) {
            sb.append(String.format("│ %10.6f │ %10.6f │\n", punto[0], punto[1]));
        }
        
        sb.append("└────────────┴────────────┘\n");
        return sb.toString();
    }
    
    /**
     * Obtiene los coeficientes del polinomio de grado n que mejor se ajusta a los puntos
     * @param puntos Arreglo bidimensional con las coordenadas de los puntos
     * @param n Grado del polinomio
     * @return Arreglo con los coeficientes del polinomio [a0, a1, a2, ..., an]
     */
    public static double[] regresionPolinomial(double[][] puntos, int n) {
        int m = puntos.length;
        double[] sx = new double[2 * n + 1];
        double[] sxy = new double[n + 1];
        
        // Crear sumatorias
        creaSumatorias(puntos, sx, sxy, n);
        
        // Crear matriz ampliada
        double[][] ms = creaMatrizSumatorias(sx, sxy, n);
        
        // Resolver sistema de ecuaciones
        return SolucionEcuaciones.gaussJordan(ms);
    }
    
    /**
     * Calcula las sumatorias necesarias para la regresion polinomial
     * Calcula: Σ(x^0), Σ(x^1), Σ(x^2), ..., Σ(x^2n)
     * y Σ(y), Σ(xy), Σ(x²y), ..., Σ(x^n*y)
     * @param puntos Arreglo con los puntos
     * @param sx Arreglo donde se almacenan las sumatorias de x^i
     * @param sxy Arreglo donde se almacenan las sumatorias de y*x^i
     * @param n Grado del polinomio
     */
    public static void creaSumatorias(double[][] puntos, double[] sx, double[] sxy, int n) {
        int m = puntos.length;
        
        // Inicializar sumatorias
        for (int i = 0; i < 2 * n + 1; i++) {
            sx[i] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            sxy[i] = 0;
        }
        
        // Calcular sumatorias
        for (int i = 0; i < m; i++) {
            double x = puntos[i][0];
            double y = puntos[i][1];
            
            // Calcular Σ(x^j) para j = 0, 1, 2, ..., 2n
            double xPow = 1.0;
            for (int j = 0; j <= 2 * n; j++) {
                sx[j] += xPow;
                xPow *= x;
            }
            
            // Calcular Σ(y*x^j) para j = 0, 1, 2, ..., n
            xPow = 1.0;
            for (int j = 0; j <= n; j++) {
                sxy[j] += y * xPow;
                xPow *= x;
            }
        }
    }
    
    /**
     * Genera la matriz ampliada del sistema de ecuaciones normales
     * @param sx Arreglo con las sumatorias de x^i
     * @param sxy Arreglo con las sumatorias de y*x^i
     * @param n Grado del polinomio
     * @return Matriz ampliada del sistema
     */
    public static double[][] creaMatrizSumatorias(double[] sx, double[] sxy, int n) {
        double[][] ms = new double[n + 1][n + 2];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                ms[i][j] = sx[i + j];
            }
            ms[i][n + 1] = sxy[i];
        }
        
        return ms;
    }
    
    /**
     * Despliega el polinomio de grado n
     * @param a Arreglo con los coeficientes del polinomio
     * @return String con el polinomio formateado
     */
    public static String despliegaPolinomio(double[] a) {
        StringBuilder sb = new StringBuilder();
        int n = a.length - 1;

        sb.append("\nPolinomio de grado ").append(n).append(":\n");
        sb.append("y = ");

        for (int i = 0; i < a.length; i++) {
            // Para el primer termino, siempre se muestra el valor
            if (i == 0) {
                sb.append(String.format("%.6f", a[i]));
            } else {
                // Para terminos siguientes, manejar el signo correctamente
                if (a[i] >= 0) {
                    sb.append(" + ").append(String.format("%.6f", a[i]));
                } else {
                    sb.append(" - ").append(String.format("%.6f", Math.abs(a[i])));
                }

                // Agregar la variable x con su exponente
                if (i == 1) {
                    sb.append("x");
                } else {
                    sb.append("x^").append(i);
                }
            }
        }

        sb.append("\n");
        return sb.toString();
    }
    
    /**
     * Despliega una tabla con las coordenadas de los puntos para regresion lineal multiple
     * @param puntos Arreglo con los puntos [x1, x2, ..., xn, y]
     * @return String con la tabla formateada
     */
    public static String despliegaPuntosRLM(double[][] puntos) {
        if (puntos.length == 0) return "";
        
        int n = puntos[0].length - 1;
        StringBuilder sb = new StringBuilder();
        
        sb.append("\n┌");
        for (int i = 0; i < n + 1; i++) {
            sb.append("────────────┬");
        }
        sb.setCharAt(sb.length() - 1, '┐');
        sb.append("\n│");
        
        for (int i = 0; i < n; i++) {
            sb.append(String.format("    x%-2d     │", i + 1));
        }
        sb.append("     y      │\n");
        
        sb.append("├");
        for (int i = 0; i < n + 1; i++) {
            sb.append("────────────┼");
        }
        sb.setCharAt(sb.length() - 1, '┤');
        sb.append("\n");
        
        for (double[] punto : puntos) {
            sb.append("│");
            for (double val : punto) {
                sb.append(String.format(" %10.6f │", val));
            }
            sb.append("\n");
        }
        
        sb.append("└");
        for (int i = 0; i < n + 1; i++) {
            sb.append("────────────┴");
        }
        sb.setCharAt(sb.length() - 1, '┘');
        sb.append("\n");
        
        return sb.toString();
    }
    
    /**
     * Obtiene los coeficientes de la funcion lineal multiple
     * @param puntos Arreglo con los puntos [x1, x2, ..., xn, y]
     * @return Arreglo con los coeficientes [a0, a1, a2, ..., an]
     */
    public static double[] regresionLinealMultiple(double[][] puntos) {
        double[][] ms = creaMatrizSumatoriasRLM(puntos);
        return SolucionEcuaciones.gaussJordan(ms);
    }
    
    /**
     * Crea la matriz ampliada del sistema de ecuaciones normales para RLM
     * @param puntos Arreglo con los puntos [x1, x2, ..., xn, y]
     * @return Matriz ampliada del sistema
     */
    public static double[][] creaMatrizSumatoriasRLM(double[][] puntos) {
        int m = puntos.length;
        int n = puntos[0].length - 1;
        
        double[][] ms = new double[n + 1][n + 2];
        
        ms[0][0] = m;
        
        for (int j = 0; j < n; j++) {
            double sum = 0;
            for (int i = 0; i < m; i++) {
                sum += puntos[i][j];
            }
            ms[0][j + 1] = sum;
            ms[j + 1][0] = sum;
        }
        
        double sumY = 0;
        for (int i = 0; i < m; i++) {
            sumY += puntos[i][n];
        }
        ms[0][n + 1] = sumY;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                double sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += puntos[k][i - 1] * puntos[k][j - 1];
                }
                ms[i][j] = sum;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            double sum = 0;
            for (int k = 0; k < m; k++) {
                sum += puntos[k][i - 1] * puntos[k][n];
            }
            ms[i][n + 1] = sum;
        }
        
        return ms;
    }
    
    /**
     * Despliega la funcion lineal multiple
     * @param a Arreglo con los coeficientes
     * @return String con la funcion formateada
     */
    public static String despliegaFuncionLineal(double[] a) {
        StringBuilder sb = new StringBuilder();
        int n = a.length - 1;

        sb.append("\nFuncion lineal de ").append(n).append(" variable");
        if (n > 1) sb.append("s");
        sb.append(":\n");
        sb.append("y = ");

        // Termino independiente (a0)
        sb.append(String.format("%.6f", a[0]));

        // Terminos con variables
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= 0) {
                sb.append(" + ").append(String.format("%.6f", a[i]));
            } else {
                sb.append(" - ").append(String.format("%.6f", Math.abs(a[i])));
            }
            sb.append("x").append(i);
        }

        sb.append("\n");
        return sb.toString();
    }
}