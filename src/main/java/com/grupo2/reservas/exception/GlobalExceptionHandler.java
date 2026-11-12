package com.grupo2.reservas.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice gestiona las excepciones que se lancen desde cualquier controller
    //Devuelveuna respuesta HTTP con el codigo y el mensaje
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Se genera el codigo 404: recurso que no existe
    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<Map<String, String>> recursoNoEncontrado(RecursoNoEncontradoException ex) {
        Map<String, String> cuerpo = new HashMap<>();
        cuerpo.put("mensaje", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cuerpo);
    }

    // Se genera el codigo 409: reserva en caso de que choque con otra reserva
    @ExceptionHandler(ReservaConflictivaException.class)
    public ResponseEntity<Map<String, String>> reservaConflictiva(ReservaConflictivaException ex) {
        Map<String, String> cuerpo = new HashMap<>();
        cuerpo.put("mensaje", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(cuerpo);
    }

    // Se genera el codigo 400: los datos enviados son incorrectos
    @ExceptionHandler(DatosInvalidosException.class)
    public ResponseEntity<Map<String, String>> datosInvalidos(DatosInvalidosException ex) {
        Map<String, String> cuerpo = new HashMap<>();
        cuerpo.put("mensaje", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cuerpo);
    }
}
