package com.grupo2.reservas.exception;

/**
 * Excepción personalizada: "Reserva conflictiva".
 *
 * Se lanza cuando alguien intenta reservar un espacio que ya está
 * ocupado en ese mismo horario (solapamiento de reservas).
 *
 * El GlobalExceptionHandler la convierte en una respuesta HTTP 409
 * (Conflict) para que el cliente sepa que debe elegir otro horario.
 */
public class ReservaConflictivaException extends RuntimeException {

    public ReservaConflictivaException(String mensaje) {
        super(mensaje);
    }
}
