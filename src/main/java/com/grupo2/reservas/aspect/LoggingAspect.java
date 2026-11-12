package com.grupo2.reservas.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//la clase @Ascpet es de aspecto y @Component donde Spring registra como bean
@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.grupo2.reservas.controller..*.*(..))")
    public Object medirTiempo(ProceedingJoinPoint puntoDeUnion) throws Throwable {

        // getSignature() informa el metodo que esta usando
        String metodo = puntoDeUnion.getSignature().toString();
        System.out.println("[Aspecto] Ejecutando: " + metodo);

        // Nos marca el tiempo inicial
        long inicio = System.currentTimeMillis();

        //Ejecutamos el metodo del controller
        try {
            Object resultado = puntoDeUnion.proceed();

            long fin = System.currentTimeMillis();
            System.out.println("[Aspecto] " + metodo + " tardó " + (fin - inicio) + " ms");
            return resultado; // devolvemos el resultado tal cual al cliente

        } catch (Throwable error) {
            // Mensaje cuando el controller lanza una excepsion
            System.out.println("[Aspecto] " + metodo + " falló: " + error.getMessage());
            throw error;
        }
    }
}
