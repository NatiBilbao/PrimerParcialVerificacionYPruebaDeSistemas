package examen1.p3;

public class ServicioCelularesEstatico {
    public String prestamoCelular(String modelo, String marca, String usuario) {
        if (estaDisponible(modelo, marca)) {
            if (registrarPrestamo(modelo, marca, usuario)) {
                return "El celular '" + modelo + "' de " + marca + " ha sido prestado a " + usuario;
            } else {
                return "Error al registrar el préstamo del celular '" + modelo + "' de " + marca;
            }
        } else {
            return "El celular '" + modelo + "' de " + marca + " no está disponible";
        }
    }

    static boolean estaDisponible(String modelo, String marca) {
        return !modelo.equals("iPhone 13");
    }
    static boolean registrarPrestamo(String modelo, String marca, String usuario) {
        return true;
    }
}
