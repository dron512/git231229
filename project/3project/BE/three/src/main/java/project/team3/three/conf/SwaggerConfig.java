package project.team3.three.conf;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "대학생을 위한 일정관리 프로그램",
                version = "v1.0.0"
        )
)
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi User(){
        String[] paths = {"/**"};
        return GroupedOpenApi.builder()
                .group("User Management")
                .pathsToMatch(paths)
                .build();
    }
}
