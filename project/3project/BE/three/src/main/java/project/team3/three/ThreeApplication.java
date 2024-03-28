package project.team3.three;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;


@EnableJdbcAuditing
@SpringBootApplication
public class ThreeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ThreeApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ThreeApplication.class);
	}
}

