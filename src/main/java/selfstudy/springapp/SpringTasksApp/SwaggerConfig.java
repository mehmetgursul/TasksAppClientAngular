package selfstudy.springapp.SpringTasksApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = selfstudy.springapp.SpringTasksApp.controller.TaskController.class)
public class SwaggerConfig {
	private static final String SWAGGER_API_VERSION = "1.0";
	private static final String LICENCE_TEXT = "Licence";
	private static final String TITLE = "Tasks REST API";
	private static final String DESCRIPTION = "RESTful API for Tasks";
	
	@Bean
	public Docket productApi() {		
        return new Docket(DocumentationType.SWAGGER_2)         		     		                 
                .select() 
                .apis(RequestHandlerSelectors.basePackage("selfstudy.springapp.SpringTasksApp.controller"))
                .paths(PathSelectors.regex("/tasks.*"))
                .build()
                .apiInfo(apiInfo());
	}
	
	
	private ApiInfo	apiInfo() {
		return new ApiInfoBuilder()
				.title(TITLE)
				.description(DESCRIPTION)
				.license(LICENCE_TEXT)
				.version(SWAGGER_API_VERSION)
				.build();
	}
}
