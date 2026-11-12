package com.grupo2.reservas.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

//Interceptor que verifica cada peticion HTTP
public class LoggingInterceptor implements HandlerInterceptor {
    //Este bloque se ejecuta antes de pasar por el controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("==================================================");
        System.out.println("[Interceptor] Petición recibida");
        // Se ejecuta los metodos: GET, POST, PUT, DELETE
        System.out.println("[Interceptor] Método HTTP : " + request.getMethod());
        System.out.println("[Interceptor] Ruta        : " + request.getRequestURI());
        return true;
    }
     // Se ejecuta cuando el controller termino
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("[Interceptor] Petición finalizada");
        // Se ejecuta con los codigos 200, 404, 500
        System.out.println("[Interceptor] Estado HTTP : " + response.getStatus());
        System.out.println("==================================================");
    }
}
