package implementaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

public class RaicesFunciones {
    // contador de iteraciones realizadas en el metodo
    private int iteraciones;

    /**
     * Devuelve el numero de iteraciones realizadas
     * @return cantidad de iteraciones
     */
    public int getIteraciones() {
        return iteraciones;
    }

    /**
     * Metodo de Biseccion para encontrar una raiz de la funcion f
     * @param f funcion a evaluar
     * @param xi valor inicial del intervalo
     * @param xf valor final del intervalo
     * @param eamax error maximo permitido
     * @return raiz aproximada de la funcion
     */
    public double biseccion(DoubleUnaryOperator f, double xi, double xf, double eamax) {
        iteraciones = 0;
        double xr = 0, ea = 100;

        // mientras el error sea mayor al maximo permitido
        while (ea > eamax) {
            double xrPrev = xr;
            // se calcula el punto medio
            xr = (xi + xf) / 2.0;
            double fxr = f.applyAsDouble(xr);
            double fxi = f.applyAsDouble(xi);

            // se revisa en que subintervalo esta la raiz
            if (fxr * fxi < 0) {
                xf = xr;
            } else {
                xi = xr;
            }

            iteraciones++;
            // se calcula el error aproximado
            if (iteraciones > 1) {
                ea = Math.abs((xr - xrPrev) / xr) * 100;
            }
        }
        return xr;
    }

    /**
     * Metodo de la Regla Falsa para encontrar una raiz de la funcion f
     * @param f funcion a evaluar
     * @param xi valor inicial del intervalo
     * @param xf valor final del intervalo
     * @param eamax error maximo permitido
     * @return raiz aproximada de la funcion
     */
    public double reglaFalsa(DoubleUnaryOperator f, double xi, double xf, double eamax) {
        iteraciones = 0;
        double xr = 0, ea = 100;

        // mientras el error sea mayor al maximo permitido
        while (ea > eamax) {
            double xrPrev = xr;
            double fxi = f.applyAsDouble(xi);
            double fxf = f.applyAsDouble(xf);

            // formula de la regla falsa
            xr = xf - (fxf * (xi - xf)) / (fxi - fxf);
            double fxr = f.applyAsDouble(xr);

            // se revisa en que subintervalo esta la raiz
            if (fxi * fxr < 0) {
                xf = xr;
            } else {
                xi = xr;
            }

            iteraciones++;
            // se calcula el error aproximado
            if (iteraciones > 1) {
                ea = Math.abs((xr - xrPrev) / xr) * 100;
            }
        }
        return xr;
    }


    /**
     * Metodo de Biseccion que devuelve todas las iteraciones
     */
    public List<Object[]> biseccionTabla(DoubleUnaryOperator f, double xi, double xf, double eamax) {
        List<Object[]> tabla = new ArrayList<>();
        iteraciones = 0;
        double xr = 0, ea = 100;

        while (ea > eamax) {
            double xrPrev = xr;
            xr = (xi + xf) / 2.0;

            double fxi = f.applyAsDouble(xi);
            double fxf = f.applyAsDouble(xf);
            double fxr = f.applyAsDouble(xr);

            if (fxr * fxi < 0) {
                xf = xr;
            } else {
                xi = xr;
            }

            iteraciones++;
            if (iteraciones > 1) {
                ea = Math.abs((xr - xrPrev) / xr) * 100;
            }

            // guardar fila: Iteración, Xi, Xf, Xr, f(Xi), f(Xf), f(Xr), Error
            tabla.add(new Object[]{
                iteraciones, xi, xf, xr, fxi, fxf, fxr, ea
            });
        }
        return tabla;
    }

    /**
     * Metodo de la Regla Falsa que devuelve todas las iteraciones
     */
    public List<Object[]> reglaFalsaTabla(DoubleUnaryOperator f, double xi, double xf, double eamax) {
        List<Object[]> tabla = new ArrayList<>();
        iteraciones = 0;
        double xr = 0, ea = 100;

        while (ea > eamax) {
            double xrPrev = xr;
            double fxi = f.applyAsDouble(xi);
            double fxf = f.applyAsDouble(xf);

            xr = xf - (fxf * (xi - xf)) / (fxi - fxf);
            double fxr = f.applyAsDouble(xr);

            if (fxi * fxr < 0) {
                xf = xr;
            } else {
                xi = xr;
            }

            iteraciones++;
            if (iteraciones > 1) {
                ea = Math.abs((xr - xrPrev) / xr) * 100;
            }

            // guardar fila: Iteración, Xi, Xf, Xr, f(Xi), f(Xf), f(Xr), Error
            tabla.add(new Object[]{
                iteraciones, xi, xf, xr, fxi, fxf, fxr, ea
            });
        }
        return tabla;
    }
}
