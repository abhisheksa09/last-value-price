package com.ihsmarkit.csvtodb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class FinancialInstrumentConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.ihsmarkit.csvtodb.controller"))
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }

    /**
     * Swagger API information.
     *
     * @return Swagger API information
     */
    private ApiInfo apiInfo() {
        return new ApiInfo("Financial Instrument API", "This API allows to store financial instrument details", "1.0", "SLA to be defined",
                new Contact("Abhishek", "", "someEmail@gmail.com"), "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
    }
}
