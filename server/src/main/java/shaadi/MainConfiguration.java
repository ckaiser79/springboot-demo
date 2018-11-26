// $Id\$
package shaadi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource("application.properties")
@EnableTransactionManagement
@EnableJpaRepositories
public class MainConfiguration {

	/**
	 * Publish the documentation at /swagger-ui.html
	 */
	@Bean
	public Docket api() {
		final String name = getClass().getPackage().getName();
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(name))
				.paths(PathSelectors.any())
				.build();
	}


}