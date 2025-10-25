package MyAplicationWebGrupo04.modelo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración global de CORS.
 * Permite que el frontend (por ejemplo, React o Angular)
 * acceda a los endpoints del backend Spring Boot.
 * Compatible con el control de concurrencia optimista
 * (no interfiere con los headers ni con el manejo del campo @Version).
 */
@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permite todos los endpoints del backend
                        .allowedOriginPatterns("*") // 🔧 cambia según tu frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .exposedHeaders("ETag", "Version") // 🔍 útil si usas cabeceras para concurrencia optimista
                        .allowCredentials(true);
                //http://localhost:8083", "http://localhost:
            }
        };
    }
}
