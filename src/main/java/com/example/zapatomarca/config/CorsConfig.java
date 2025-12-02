package com.example.zapatomarca.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuracion global de CORS para permitir peticiones del frontend Angular
 * (local y en produccion en Render).
 * * NOTA IMPORTANTE: Reemplaza 'DOMINIO-RENDER-AQUI' con la URL real de tu Angular
 * en Render una vez que lo despliegues.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Aplica esta configuracion a todos los endpoints de la API (/**)
        registry.addMapping("/**")

                // Orígenes permitidos (necesarios para evitar el error CORS)
                .allowedOrigins(
                        "http://localhost:4200", // 1. Entorno de desarrollo Angular local

                        // 2. Produccion en Render: DEBES CAMBIAR ESTO
                        "https://DOMINIO-RENDER-AQUI.onrender.com"
                )

                // Métodos HTTP permitidos
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")

                // Permite headers de autenticacion (como tokens JWT)
                .allowCredentials(true)

                // Permite cualquier header de la peticion
                .allowedHeaders("*");
    }
}