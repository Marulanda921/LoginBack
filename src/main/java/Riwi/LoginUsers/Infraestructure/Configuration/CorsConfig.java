package Riwi.LoginUsers.Infraestructure.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Permitir credenciales
        config.setAllowCredentials(true);
        // Permitir cualquier origen usando patrones
        config.setAllowedOriginPatterns(Arrays.asList("*")); // Permitir cualquier origen
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos permitidos
        config.setAllowedHeaders(Arrays.asList("*")); // Permitir cualquier cabecera

        source.registerCorsConfiguration("/**", config); // Aplicar a todas las rutas
        return new CorsFilter(source);
    }
}
