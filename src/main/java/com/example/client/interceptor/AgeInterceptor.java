package com.example.client.interceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AgeInterceptor implements HandlerInterceptor {

    private final String SECRET_KEY = "mi_clave_secreta_super_segura";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");

        if (token == null || token.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el token de acceso");
            return false;
        }

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY.getBytes())
                    .parseClaimsJws(token)
                    .getBody();

            Integer age = (Integer) claims.get("age");
            String name = (String) claims.get("name");

            if (age < 18) {
                throw new RuntimeException("Acceso denegado: " + name + " es menor de edad (" + age + ")");
            }

            return true;

        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Token inválido o error de edad: " + e.getMessage());
            return false;
        }
    }
}