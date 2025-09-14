package implementaciones;

import implementaciones.RaicesFunciones;
import org.junit.jupiter.api.Test;

import java.util.function.DoubleUnaryOperator;

import static org.junit.jupiter.api.Assertions.*;


class RaicesFuncionesTest {

    /**
     * Prueba del metodo de biseccion
     * Se espera que la raiz este entre 0.3 y 0.5
     * Tambien que f(raiz) sea muy cercano a cero
     */
    @Test
    void testBiseccion() {
        RaicesFunciones rf = new RaicesFunciones();
        DoubleUnaryOperator f = (x) -> 4*Math.pow(x,3) - 6*Math.pow(x,2) + 7*x - 2.3;

        double xi = 0.0;
        double xf = 1.0;
        double eamax = 0.0001;

        double raiz = rf.biseccion(f, xi, xf, eamax);

        // la raiz debe estar en el rango 0.3 a 0.5
        assertTrue(raiz > 0.3 && raiz < 0.5, "La raiz no esta en el rango esperado");

        // f(raiz) debe ser cercano a cero
        assertEquals(0.0, f.applyAsDouble(raiz), 1e-5, "f(raiz) no es cercano a cero");

        // debe haberse ejecutado al menos una iteracion
        assertTrue(rf.getIteraciones() > 0, "No se realizaron iteraciones");
    }

    /**
     * Prueba del metodo de regla falsa en el intervalo negativo
     * Se espera que la raiz este entre -2.5 y -2.0
     * Tambien que g(raiz) sea muy cercano a cero
     */
    @Test
    void testReglaFalsaIntervaloNegativo() {
        RaicesFunciones rf = new RaicesFunciones();
        DoubleUnaryOperator g = (x) -> Math.pow(x,2) * Math.sqrt(Math.abs(Math.cos(x))) - 5;

        double xi = -3.0;
        double xf = -2.0;
        double eamax = 0.0001;

        double raiz = rf.reglaFalsa(g, xi, xf, eamax);

        // la raiz debe estar en el rango -2.5 a -2.0
        assertTrue(raiz > -2.5 && raiz < -2.0, "La raiz no esta en el rango esperado");

        // g(raiz) debe ser cercano a cero
        assertEquals(0.0, g.applyAsDouble(raiz), 1e-5, "g(raiz) no es cercano a cero");
    }

    /**
     * Prueba del metodo de regla falsa en el intervalo positivo
     * Se espera que la raiz este entre 2.0 y 2.5
     * Tambien que g(raiz) sea muy cercano a cero
     */
    @Test
    void testReglaFalsaIntervaloPositivo() {
        RaicesFunciones rf = new RaicesFunciones();
        DoubleUnaryOperator g = (x) -> Math.pow(x,2) * Math.sqrt(Math.abs(Math.cos(x))) - 5;

        double xi = 2.0;
        double xf = 3.0;
        double eamax = 0.0001;

        double raiz = rf.reglaFalsa(g, xi, xf, eamax);

        // la raiz debe estar en el rango 2.0 a 2.5
        assertTrue(raiz > 2.0 && raiz < 2.5, "La raiz no esta en el rango esperado");

        // g(raiz) debe ser cercano a cero
        assertEquals(0.0, g.applyAsDouble(raiz), 1e-5, "g(raiz) no es cercano a cero");
    }
}