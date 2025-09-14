package implementaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

/**
 * Clase Tabula
 * Sirve para calcular los valores de una funcion en un intervalo
 * y guardar los puntos (x, y). Tambien obtiene el maximo y minimo
 */
public class Tabula {

    /**
     * Clase interna para representar un punto con valores x y y
     */
    public static class Punto {
        public double x, y;

        public Punto(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Metodo que tabula una funcion f(x) en el rango [xi, xf]
     * usando un incremento incx
     * 
     * @param f funcion matematica
     * @param xi inicio del intervalo
     * @param xf fin del intervalo
     * @param incx incremento en x
     * @return lista de puntos con los valores calculados,
     *         incluyendo al final el maximo y el minimo
     */
    public static List<Punto> tabula(DoubleUnaryOperator f, double xi, double xf, double incx) {
        List<Punto> resultados = new ArrayList<>();

        double x = xi;
        double maxY = Double.NEGATIVE_INFINITY;
        double minY = Double.POSITIVE_INFINITY;
        double maxX = xi, minX = xi;

        // Recorre el intervalo y calcula la funcion en cada x
        while (x <= xf + 1e-9) {
            double y = f.applyAsDouble(x);
            resultados.add(new Punto(x, y));

            // Actualiza maximo
            if (y > maxY) {
                maxY = y;
                maxX = x;
            }
            // Actualiza minimo
            if (y < minY) {
                minY = y;
                minX = x;
            }

            x += incx;
        }

        // Agrega maximo y minimo como los ultimos dos puntos
        resultados.add(new Punto(maxX, maxY)); // maximo
        resultados.add(new Punto(minX, minY)); // minimo

        return resultados;
    }
}