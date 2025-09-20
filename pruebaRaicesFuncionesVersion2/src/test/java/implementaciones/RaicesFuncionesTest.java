package implementaciones;

import implementaciones.RaicesFunciones;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.function.DoubleUnaryOperator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RaicesFuncionesTest {
    
    private RaicesFunciones rf;
    
    @BeforeEach
    void setUp() {
        rf = new RaicesFunciones();
    }

    /**
     * Prueba del metodo de biseccion
     * Se espera que la raiz este entre 0.3 y 0.5
     * Tambien que f(raiz) sea muy cercano a cero
     */
    @Test
    void testBiseccion() {
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
     * Prueba del metodo de biseccion con intervalo invalido
     * Se espera que retorne NaN cuando no hay cambio de signo
     */
    @Test
    void testBiseccionIntervaloInvalido() {
        DoubleUnaryOperator f = (x) -> x * x + 1; // Siempre positiva
        double xi = 0.0;
        double xf = 1.0;
        double eamax = 0.0001;
        
        double resultado = rf.biseccion(f, xi, xf, eamax);
        
        assertTrue(Double.isNaN(resultado), "Deberia retornar NaN para intervalo invalido");
    }

    /**
     * Prueba del metodo de regla falsa en el intervalo negativo
     * Se espera que la raiz este entre -2.5 y -2.0
     * Tambien que g(raiz) sea muy cercano a cero
     */
    @Test
    void testReglaFalsaIntervaloNegativo() {
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

    /**
     * Prueba del metodo de regla falsa con intervalo invalido
     * Se espera que retorne NaN cuando no hay cambio de signo
     */
    @Test
    void testReglaFalsaIntervaloInvalido() {
        DoubleUnaryOperator f = (x) -> x * x + 1; // Siempre positiva
        double xi = 1.0;
        double xf = 2.0;
        double eamax = 0.0001;
        
        double resultado = rf.reglaFalsa(f, xi, xf, eamax);
        
        assertTrue(Double.isNaN(resultado), "Deberia retornar NaN para intervalo invalido");
    }

    /**
     * Prueba del metodo de Newton-Raphson
     * Se espera que encuentre la raiz de f(x) = 4x³ - 6x² + 7x - 2.3
     */
    @Test
    void testNewtonRaphson() {
        DoubleUnaryOperator f = (x) -> 4*Math.pow(x,3) - 6*Math.pow(x,2) + 7*x - 2.3;
        DoubleUnaryOperator df = (x) -> 12*Math.pow(x,2) - 12*x + 7;
        double xi = 0.0;
        double eamax = 0.0001;
        
        double raiz = rf.newtonRaphson(f, df, xi, eamax);
        
        // Verificar que la raiz es valida
        assertFalse(Double.isNaN(raiz), "Newton-Raphson no deberia retornar NaN");
        // f(raiz) debe ser cercano a cero
        assertEquals(0.0, f.applyAsDouble(raiz), 1e-5, "f(raiz) no es cercano a cero");
        // debe haberse ejecutado al menos una iteracion
        assertTrue(rf.getIteraciones() > 0, "No se realizaron iteraciones");
    }

    /**
     * Prueba del metodo de Newton-Raphson con derivada nula
     * Se espera que retorne NaN cuando la derivada es cero
     */
    @Test
    void testNewtonRaphsonDerivadaNula() {
        DoubleUnaryOperator f = (x) -> x * x - 1;
        DoubleUnaryOperator df = (x) -> 0.0; // Derivada siempre cero
        double xi = 1.0;
        double eamax = 0.0001;
        
        double resultado = rf.newtonRaphson(f, df, xi, eamax);
        
        assertTrue(Double.isNaN(resultado), "Deberia retornar NaN cuando la derivada es nula");
    }

    /**
     * Prueba del metodo de la secante
     * Se espera que encuentre la raiz usando dos puntos iniciales
     */
    @Test
    void testSecante() {
        DoubleUnaryOperator g = (x) -> Math.pow(x,2) * Math.sqrt(Math.abs(Math.cos(x))) - 5;
        double x1 = -3.0;
        double x2 = -2.0;
        double eamax = 0.0001;
        
        double raiz = rf.secante(g, x1, x2, eamax);
        
        // Verificar que la raiz es valida
        assertFalse(Double.isNaN(raiz), "Secante no deberia retornar NaN");
        // g(raiz) debe ser cercano a cero
        assertEquals(0.0, g.applyAsDouble(raiz), 1e-5, "g(raiz) no es cercano a cero");
        // debe haberse ejecutado al menos una iteracion
        assertTrue(rf.getIteraciones() > 0, "No se realizaron iteraciones");
    }

    /**
     * Prueba del metodo de la secante con valores de funcion iguales
     * Se espera que retorne NaN cuando f(x1) = f(x2)
     */
    @Test
    void testSecanteValoresIguales() {
        DoubleUnaryOperator f = (x) -> 5.0; // Funcion constante
        double x1 = 1.0;
        double x2 = 2.0;
        double eamax = 0.0001;
        
        double resultado = rf.secante(f, x1, x2, eamax);
        
        assertTrue(Double.isNaN(resultado), "Deberia retornar NaN cuando f(x1) = f(x2)");
    }

    /**
     * Prueba del metodo biseccionTabla
     * Verifica que retorne una tabla con datos de iteraciones
     */
    @Test
    void testBiseccionTabla() {
        DoubleUnaryOperator f = (x) -> 4*Math.pow(x,3) - 6*Math.pow(x,2) + 7*x - 2.3;
        double xi = 0.0;
        double xf = 1.0;
        double eamax = 0.0001;
        
        List<Object[]> tabla = rf.biseccionTabla(f, xi, xf, eamax);
        
        // Verificar que la tabla no es nula
        assertNotNull(tabla, "La tabla no deberia ser nula");
        // Verificar que tiene al menos una fila
        assertTrue(tabla.size() > 0, "La tabla deberia tener al menos una fila");
        // Verificar que cada fila tiene 8 columnas
        assertEquals(8, tabla.get(0).length, "Cada fila deberia tener 8 columnas");
    }

    /**
     * Prueba del metodo reglaFalsaTabla
     * Verifica que retorne una tabla con datos de iteraciones
     */
    @Test
    void testReglaFalsaTabla() {
        DoubleUnaryOperator g = (x) -> Math.pow(x,2) * Math.sqrt(Math.abs(Math.cos(x))) - 5;
        double xi = -3.0;
        double xf = -2.0;
        double eamax = 0.0001;
        
        List<Object[]> tabla = rf.reglaFalsaTabla(g, xi, xf, eamax);
        
        // Verificar que la tabla no es nula
        assertNotNull(tabla, "La tabla no deberia ser nula");
        // Verificar que tiene al menos una fila
        assertTrue(tabla.size() > 0, "La tabla deberia tener al menos una fila");
        // Verificar que cada fila tiene 8 columnas
        assertEquals(8, tabla.get(0).length, "Cada fila deberia tener 8 columnas");
    }

    /**
     * Prueba del metodo newtonRaphsonTabla
     * Verifica que retorne una tabla con datos de iteraciones
     */
    @Test
    void testNewtonRaphsonTabla() {
        DoubleUnaryOperator f = (x) -> 4*Math.pow(x,3) - 6*Math.pow(x,2) + 7*x - 2.3;
        DoubleUnaryOperator df = (x) -> 12*Math.pow(x,2) - 12*x + 7;
        double xi = 0.0;
        double eamax = 0.0001;
        
        List<Object[]> tabla = rf.newtonRaphsonTabla(f, df, xi, eamax);
        
        // Verificar que la tabla no es nula
        assertNotNull(tabla, "La tabla no deberia ser nula");
        // Verificar que tiene al menos una fila
        assertTrue(tabla.size() > 0, "La tabla deberia tener al menos una fila");
        // Verificar que cada fila tiene 8 columnas
        assertEquals(8, tabla.get(0).length, "Cada fila deberia tener 8 columnas");
    }

    /**
     * Prueba del metodo secanteTabla
     * Verifica que retorne una tabla con datos de iteraciones
     */
    @Test
    void testSecanteTabla() {
        DoubleUnaryOperator g = (x) -> Math.pow(x,2) * Math.sqrt(Math.abs(Math.cos(x))) - 5;
        double x1 = -3.0;
        double x2 = -2.0;
        double eamax = 0.0001;
        
        List<Object[]> tabla = rf.secanteTabla(g, x1, x2, eamax);
        
        // Verificar que la tabla no es nula
        assertNotNull(tabla, "La tabla no deberia ser nula");
        // Verificar que tiene al menos una fila
        assertTrue(tabla.size() > 0, "La tabla deberia tener al menos una fila");
        // Verificar que cada fila tiene 8 columnas
        assertEquals(8, tabla.get(0).length, "Cada fila deberia tener 8 columnas");
    }

    /**
     * Prueba del metodo getIteraciones
     * Verifica que retorne el numero correcto de iteraciones
     */
    @Test
    void testGetIteraciones() {
        DoubleUnaryOperator f = (x) -> 4*Math.pow(x,3) - 6*Math.pow(x,2) + 7*x - 2.3;
        double xi = 0.0;
        double xf = 1.0;
        double eamax = 0.0001;
        
        // Ejecutar biseccion
        rf.biseccion(f, xi, xf, eamax);
        
        // Verificar que el numero de iteraciones es mayor a cero
        assertTrue(rf.getIteraciones() > 0, "El numero de iteraciones deberia ser mayor a cero");
        // Verificar que el numero es razonable (no deberia necesitar mas de 100 iteraciones)
        assertTrue(rf.getIteraciones() < 100, "El numero de iteraciones es demasiado alto");
    }

    /**
     * Prueba de precision con tolerancia muy pequena
     * Verifica que los metodos puedan alcanzar alta precision
     */
    @Test
    void testPrecisionAlta() {
        DoubleUnaryOperator f = (x) -> x * x - 2; // raiz = sqrt(2)
        double xi = 1.0;
        double xf = 2.0;
        double eamax = 1e-10; // Tolerancia muy pequena
        
        double raiz = rf.biseccion(f, xi, xf, eamax);
        
        // La raiz deberia estar muy cerca de sqrt(2)
        assertEquals(Math.sqrt(2), raiz, 1e-9, "La raiz no tiene la precision esperada");
        // f(raiz) deberia ser muy cercano a cero
        assertEquals(0.0, f.applyAsDouble(raiz), 1e-8, "f(raiz) no es suficientemente preciso");
    }

    /**
     * Prueba de metodos con tabla retornando null para casos invalidos
     */
    @Test
    void testTablasRetornanNullParaCasosInvalidos() {
        DoubleUnaryOperator f = (x) -> x * x + 1; // Siempre positiva
        
        // Biseccion con intervalo invalido
        List<Object[]> tablaBiseccion = rf.biseccionTabla(f, 0.0, 1.0, 0.0001);
        assertNull(tablaBiseccion, "biseccionTabla deberia retornar null para intervalo invalido");
        
        // Regla falsa con intervalo invalido
        List<Object[]> tablaReglaFalsa = rf.reglaFalsaTabla(f, 0.0, 1.0, 0.0001);
        assertNull(tablaReglaFalsa, "reglaFalsaTabla deberia retornar null para intervalo invalido");
        
        // Newton-Raphson con derivada nula
        DoubleUnaryOperator df = (x) -> 0.0;
        List<Object[]> tablaNewton = rf.newtonRaphsonTabla(f, df, 1.0, 0.0001);
        assertNull(tablaNewton, "newtonRaphsonTabla deberia retornar null para derivada nula");
        
        // Secante con valores iguales
        DoubleUnaryOperator g = (x) -> 5.0;
        List<Object[]> tablaSecante = rf.secanteTabla(g, 1.0, 2.0, 0.0001);
        assertNull(tablaSecante, "secanteTabla deberia retornar null para valores iguales");
    }
}