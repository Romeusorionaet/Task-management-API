package esig.tarefas.gestaodetarefas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI OpenAPI() {

        return new OpenAPI()
                .info(new Info().title("Gestão de Tarefas").description(
                        "Projeto para teste de estágio pela empresa ESIG GROUP - Gerenciamento de tarefas (API)")
                        .version("1"));
    }
}