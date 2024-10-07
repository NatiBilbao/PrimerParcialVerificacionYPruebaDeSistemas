package examen1.p2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

public class ServicioCelularesTest {
    private ServicioCelulares servicioCelulares;
    private ServicioCelulares servicioMock;

    @BeforeEach
    public void setUp() {
        servicioMock = Mockito.spy(new ServicioCelulares());
        servicioCelulares = new ServicioCelulares();
    }

    @Test
    public void testPrestamoCelularDisponibleYExitoso() {

        doReturn(true).when(servicioMock).estaDisponible("Samsung Galaxy S21", "Samsung");

        doReturn(true).when(servicioMock).registrarPrestamo("Samsung Galaxy S21", "Samsung", "Diego Jauregui");

        String resultado = servicioMock.prestamoCelular("Samsung Galaxy S21", "Samsung", "Diego Jauregui");

        assertEquals("El celular 'Samsung Galaxy S21' de Samsung ha sido prestado a Diego Jauregui", resultado);
    }

    @Test
    public void testPrestamoCelularNoDisponible() {

        doReturn(false).when(servicioMock).estaDisponible("iPhone 13", "Apple");

        String resultado = servicioMock.prestamoCelular("iPhone 13", "Apple", "Alejandro Santos");

        assertEquals("El celular 'iPhone 13' de Apple no está disponible", resultado);
    }

    @Test
    public void testErrorAlRegistrarPrestamo() {

        doReturn(true).when(servicioMock).estaDisponible("Samsung Galaxy S21", "Samsung");

        doReturn(false).when(servicioMock).registrarPrestamo("Samsung Galaxy S21", "Samsung", "Diego Jauregui");

        String resultado = servicioMock.prestamoCelular("Samsung Galaxy S21", "Samsung", "Diego Jauregui");

        assertEquals("Error al registrar el préstamo del celular 'Samsung Galaxy S21' de Samsung", resultado);
    }
}
