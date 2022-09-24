package it.develhope.TimeBank.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.Collections;


@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(
                        new ApiInfo(
                                "Time Bank",
                                "Team project which consist in the development of the back-end section of a web app.",
                                "1.0",
                                null,
                                new Contact(
                                        "Develhope team project - Java 4, Team 3",
                                        "https://github.com/G1ad/TimeBank",
                                        null
                                ),
                                null,
                                null,
                                Collections.emptyList()
                        )
                ).tags(
                        new Tag("Help Request Controller","Show the request by root")
                );
    }
}
