package br.com.sgm.integracao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class CorsMappingConfig implements WebMvcConfigurer {

	@Override
    public void addCorsMappings(CorsRegistry registry) { 
        registry.addMapping("/api/integracao/**");
    }
}