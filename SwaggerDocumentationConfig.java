package com.shop.item.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {

        return new ApiInfoBuilder()
            .title("Swagger Shop Items")
            .description("List All the API'S Shop Items")
            .license("MIT")
            .licenseUrl("https://opensource.org/licenses/MIT")
            .version("1.0.0")
            .contact(new Contact("Bharathkumar","https://codeaches.com", "bharathkumarp@virtusa.com"))
            .build();
    }

    @Bean
    public Docket customImplementation() {

      return new Docket(DocumentationType.SWAGGER_2)
          .useDefaultResponseMessages(false)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.shop.item"))
          .paths(PathSelectors.any())
          .build()
         // .enable(enableSwaggerPlugin)
          .apiInfo(apiInfo());
    }
}
	
