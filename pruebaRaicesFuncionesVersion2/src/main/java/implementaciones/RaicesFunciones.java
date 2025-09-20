package implementaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import javax.swing.JOptionPane;

public class RaicesFunciones {
    private int iteraciones;
    private static final int MAX_ITERACIONES = 100; // numero maximo de pasos de seguridad
    private static final double EPSILON = 1e-15; // tolerancia muy pequena para verificar convergencia

    /**
     * devuelve el numero de iteraciones hechas en la ultima ejecucion
     */
    public int getIteraciones() {
        return iteraciones;
    }


    // metodo biseccion

    /**
     * busca una raiz usando el metodo de biseccion
     * f es la funcion
     * xi es el limite inferior
     * xf es el limite superior
     * eamax es el error maximo permitido
     * devuelve la raiz aproximada
     */
    public double biseccion(DoubleUnaryOperator f, double xi, double xf, double eamax) {
        double fxi = f.applyAsDouble(xi);
        double fxf = f.applyAsDouble(xf);

        // si no hay cambio de signo en el intervalo no hay raiz
        if (fxi * fxf > 0) {
            JOptionPane.showMessageDialog(null,
                String.format("el intervalo [%.3f, %.3f] no encierra raiz\nf(%.3f)=%.6f\nf(%.3f)=%.6f", 
                xi, xf, xi, fxi, xf, fxf));
            return Double.NaN;
        }

        iteraciones = 0;
        double xr = 0, ea = 100;

        // repetir hasta que el error sea menor que el permitido o se llegue al maximo de iteraciones
        while (ea > eamax && iteraciones < MAX_ITERACIONES) {
            double xrPrev = xr;
            xr = (xi + xf) / 2.0;
            double fxr = f.applyAsDouble(xr);

            // si f(xr) es muy cercano a cero se termina
            if (Math.abs(fxr) < EPSILON) {
                break;
            }

            // decidir el nuevo intervalo
            if (f.applyAsDouble(xi) * fxr < 0) {
                xf = xr;
            } else {
                xi = xr;
            }

            iteraciones++;
            if (iteraciones > 1) {
                ea = Math.abs((xr - xrPrev) / xr) * 100;
            }
        }

        if (iteraciones >= MAX_ITERACIONES) {
            JOptionPane.showMessageDialog(null, "se alcanzo el maximo de iteraciones sin converger");
        }

        return xr;
    }


    // metodo regla falsa

    /**
     * busca una raiz usando el metodo de regla falsa
     */
    public double reglaFalsa(DoubleUnaryOperator f, double xi, double xf, double eamax) {
        double fxi = f.applyAsDouble(xi);
        double fxf = f.applyAsDouble(xf);

        if (fxi * fxf > 0) {
            JOptionPane.showMessageDialog(null,
                String.format("el intervalo [%.3f, %.3f] no encierra raiz\nf(%.3f)=%.6f\nf(%.3f)=%.6f", 
                xi, xf, xi, fxi, xf, fxf));
            return Double.NaN;
        }

        iteraciones = 0;
        double xr = 0, ea = 100;

        while (ea > eamax && iteraciones < MAX_ITERACIONES) {
            double xrPrev = xr;
            fxi = f.applyAsDouble(xi);
            fxf = f.applyAsDouble(xf);

            // formula de regla falsa
            xr = xf - (fxf * (xi - xf)) / (fxi - fxf);
            double fxr = f.applyAsDouble(xr);

            if (Math.abs(fxr) < EPSILON) {
                break;
            }

            if (fxi * fxr < 0) {
                xf = xr;
            } else {
                xi = xr;
            }

            iteraciones++;
            if (iteraciones > 1) {
                ea = Math.abs((xr - xrPrev) / xr) * 100;
            }
        }

        if (iteraciones >= MAX_ITERACIONES) {
            JOptionPane.showMessageDialog(null, "se alcanzo el maximo de iteraciones sin converger");
        }

        return xr;
    }


    // metodo newton raphson

    /**
     * busca una raiz con newton raphson
     * se necesita la funcion y su derivada
     */
    public double newtonRaphson(DoubleUnaryOperator f, DoubleUnaryOperator df, double xi, double eamax) {
        iteraciones = 0;
        double xr = xi, ea = 100;

        while (ea > eamax && iteraciones < MAX_ITERACIONES) {
            double xrPrev = xr;
            double fxi = f.applyAsDouble(xr);
            double dfxi = df.applyAsDouble(xr);

            // si la derivada es muy pequena no se puede seguir
            if (Math.abs(dfxi) < EPSILON) {
                JOptionPane.showMessageDialog(null,
                    String.format("derivada muy pequena en x=%.6f df=%.6f", 
                    xr, dfxi));
                return Double.NaN;
            }

            if (Math.abs(fxi) < EPSILON) {
                break;
            }

            // formula de newton raphson
            xr = xr - fxi / dfxi;

            iteraciones++;
            if (iteraciones > 1 && Math.abs(xr) > EPSILON) {
                ea = Math.abs((xr - xrPrev) / xr) * 100;
            }
        }

        if (iteraciones >= MAX_ITERACIONES) {
            JOptionPane.showMessageDialog(null, "se alcanzo el maximo de iteraciones sin converger");
        }

        return xr;
    }


    // metodo secante

    /**
     * busca una raiz usando el metodo de la secante
     */
    public double secante(DoubleUnaryOperator f, double x1, double x2, double eamax) {
        iteraciones = 0;
        double xr = 0, ea = 100;

        while (ea > eamax && iteraciones < MAX_ITERACIONES) {
            double fx1 = f.applyAsDouble(x1);
            double fx2 = f.applyAsDouble(x2);

            if (Math.abs(fx1 - fx2) < EPSILON) {
                JOptionPane.showMessageDialog(null,
                    String.format("f(%.6f) casi igual a f(%.6f)\nno se puede aplicar secante", 
                    x1, x2));
                return Double.NaN;
            }

            xr = x2 - (fx2 * (x1 - x2)) / (fx1 - fx2);

            if (Math.abs(f.applyAsDouble(xr)) < EPSILON) {
                break;
            }

            iteraciones++;
            if (iteraciones > 1 && Math.abs(xr) > EPSILON) {
                ea = Math.abs((xr - x2) / xr) * 100;
            }

            x1 = x2;
            x2 = xr;
        }

        if (iteraciones >= MAX_ITERACIONES) {
            JOptionPane.showMessageDialog(null, "se alcanzo el maximo de iteraciones sin converger");
        }

        return xr;
    }


    // tabla biseccion

    /**
     * hace biseccion y devuelve la tabla con datos de cada iteracion
     */
    public List<Object[]> biseccionTabla(DoubleUnaryOperator f, double xi, double xf, double eamax) {
        double fxi = f.applyAsDouble(xi);
        double fxf = f.applyAsDouble(xf);

        if (fxi * fxf > 0) {
            JOptionPane.showMessageDialog(null,
                String.format("el intervalo [%.3f, %.3f] no encierra raiz", xi, xf));
            return null;
        }

        List<Object[]> tabla = new ArrayList<>();
        iteraciones = 0;
        double xr = 0, ea = 100;

        while (ea > eamax && iteraciones < MAX_ITERACIONES) {
            double xrPrev = xr;
            xr = (xi + xf) / 2.0;

            fxi = f.applyAsDouble(xi);
            fxf = f.applyAsDouble(xf);
            double fxr = f.applyAsDouble(xr);

            iteraciones++;
            if (iteraciones > 1) {
                ea = Math.abs((xr - xrPrev) / xr) * 100;
            }

            tabla.add(new Object[]{iteraciones, 
                String.format("%.6f", xi), 
                String.format("%.6f", xf), 
                String.format("%.6f", xr), 
                String.format("%.6f", fxi), 
                String.format("%.6f", fxf), 
                String.format("%.6f", fxr), 
                String.format("%.4f%%", ea)});

            if (Math.abs(fxr) < EPSILON) {
                break;
            }

            if (fxr * fxi < 0) {
                xf = xr;
            } else {
                xi = xr;
            }
        }
        return tabla;
    }


    // tabla regla falsa

    public List<Object[]> reglaFalsaTabla(DoubleUnaryOperator f, double xi, double xf, double eamax) {
        double fxi = f.applyAsDouble(xi);
        double fxf = f.applyAsDouble(xf);

        if (fxi * fxf > 0) {
            JOptionPane.showMessageDialog(null,
                String.format("el intervalo [%.3f, %.3f] no encierra raiz", xi, xf));
            return null;
        }

        List<Object[]> tabla = new ArrayList<>();
        iteraciones = 0;
        double xr = 0, ea = 100;

        while (ea > eamax && iteraciones < MAX_ITERACIONES) {
            double xrPrev = xr;
            fxi = f.applyAsDouble(xi);
            fxf = f.applyAsDouble(xf);

            xr = xf - (fxf * (xi - xf)) / (fxi - fxf);
            double fxr = f.applyAsDouble(xr);

            iteraciones++;
            if (iteraciones > 1) {
                ea = Math.abs((xr - xrPrev) / xr) * 100;
            }

            tabla.add(new Object[]{iteraciones, 
                String.format("%.6f", xi), 
                String.format("%.6f", xf), 
                String.format("%.6f", xr), 
                String.format("%.6f", fxi), 
                String.format("%.6f", fxf), 
                String.format("%.6f", fxr), 
                String.format("%.4f%%", ea)});

            if (Math.abs(fxr) < EPSILON) {
                break;
            }

            if (fxi * fxr < 0) {
                xf = xr;
            } else {
                xi = xr;
            }
        }
        return tabla;
    }

 
    // tabla newton raphson
 
    public List<Object[]> newtonRaphsonTabla(DoubleUnaryOperator f, DoubleUnaryOperator df, double xi, double eamax) {
        List<Object[]> tabla = new ArrayList<>();
        iteraciones = 0;
        double xr = xi, ea = 100;

        while (ea > eamax && iteraciones < MAX_ITERACIONES) {
            double xrPrev = xr;
            double fxi = f.applyAsDouble(xr);
            double dfxi = df.applyAsDouble(xr);

            if (Math.abs(dfxi) < EPSILON) {
                JOptionPane.showMessageDialog(null,
                    String.format("derivada muy pequena en x=%.6f", xr));
                return null;
            }

            xr = xr - fxi / dfxi;

            iteraciones++;
            if (iteraciones > 1 && Math.abs(xr) > EPSILON) {
                ea = Math.abs((xr - xrPrev) / xr) * 100;
            }

            tabla.add(new Object[]{iteraciones, 
                String.format("%.6f", xrPrev), 
                String.format("%.6f", xr), 
                String.format("%.6f", xr), 
                String.format("%.6f", fxi), 
                String.format("%.6f", dfxi), 
                String.format("%.6f", f.applyAsDouble(xr)), 
                String.format("%.4f%%", ea)});

            if (Math.abs(f.applyAsDouble(xr)) < EPSILON) {
                break;
            }
        }
        return tabla;
    }


    // tabla secante

    public List<Object[]> secanteTabla(DoubleUnaryOperator f, double x1, double x2, double eamax) {
        List<Object[]> tabla = new ArrayList<>();
        iteraciones = 0;
        double xr = 0, ea = 100;

        while (ea > eamax && iteraciones < MAX_ITERACIONES) {
            double fx1 = f.applyAsDouble(x1);
            double fx2 = f.applyAsDouble(x2);

            if (Math.abs(fx1 - fx2) < EPSILON) {
                JOptionPane.showMessageDialog(null,
                    String.format("f(%.6f) casi igual a f(%.6f)", x1, x2));
                return null;
            }

            xr = x2 - (fx2 * (x1 - x2)) / (fx1 - fx2);

            iteraciones++;
            if (iteraciones > 1 && Math.abs(xr) > EPSILON) {
                ea = Math.abs((xr - x2) / xr) * 100;
            }

            tabla.add(new Object[]{iteraciones, 
                String.format("%.6f", x1), 
                String.format("%.6f", x2), 
                String.format("%.6f", xr), 
                String.format("%.6f", fx1), 
                String.format("%.6f", fx2), 
                String.format("%.6f", f.applyAsDouble(xr)), 
                String.format("%.4f%%", ea)});

            if (Math.abs(f.applyAsDouble(xr)) < EPSILON) {
                break;
            }

            x1 = x2;
            x2 = xr;
        }
        return tabla;
    }
}
