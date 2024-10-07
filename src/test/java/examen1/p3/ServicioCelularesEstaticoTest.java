package examen1.p3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCelularesEstaticoTest {
    private MockedStatic<ServicioCelularesEstatico> mockedServicioCelularesEstaticos;
    private ServicioCelularesEstatico servicioCelularesEstatico;

    @BeforeEach
    public void setUp() {

        mockedServicioCelularesEstaticos = Mockito.mockStatic(ServicioCelularesEstatico.class);
        servicioCelularesEstatico = new ServicioCelularesEstatico();
    }

    @AfterEach
    public void tearDown() {
        mockedServicioCelularesEstaticos.close();
    }

    @ParameterizedTest
    @CsvSource({
            "'Samsung Galaxy S21', 'Samsung', 'Diego Jauregui', true, true, 'El celular ''Samsung Galaxy S21'' de Samsung ha sido prestado a Diego Jauregui'",
            "'iPhone 13', 'Apple', 'Alejandro Santos', false, false, 'El celular ''iPhone 13'' de Apple no está disponible'",
            "'Samsung Galaxy S21', 'Samsung', 'Diego Jauregui', true, false, 'Error al registrar el préstamo del celular ''Samsung Galaxy S21'' de Samsung'"
    })
    public void testPrestamoCelular(String modelo, String marca, String usuario, boolean disponible, boolean registroExitoso, String expectedResult) {

        mockedServicioCelularesEstaticos.when(() -> ServicioCelularesEstatico.estaDisponible(modelo, marca))
                .thenReturn(disponible);

        mockedServicioCelularesEstaticos.when(() -> ServicioCelularesEstatico.registrarPrestamo(modelo, marca, usuario))
                .thenReturn(registroExitoso);

        String resultado = servicioCelularesEstatico.prestamoCelular(modelo, marca, usuario);
        assertEquals(expectedResult, resultado);
    }
}
