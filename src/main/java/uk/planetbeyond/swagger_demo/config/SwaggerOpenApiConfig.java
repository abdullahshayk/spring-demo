package uk.planetbeyond.swagger_demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerOpenApiConfig
{
	@Bean
	public OpenAPI api() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("JWT", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT").in(SecurityScheme.In.HEADER).name("Authorization")))
				.info(new Info().title("Demo Swagger Project Api")
						.description("Dummy Description")
						.version("1.0.0"))
				.addSecurityItem(new SecurityRequirement().addList("JWT"));
	}
}

