package com.iheart.iHeart.Media;


 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
///public class IHeartMediaApplication implements CommandLineRunner {
public class IHeartMediaApplication  {

	//private Logger logger = LoggerFactory.getLogger(this.getClass());


	
	// https://dzone.com/articles/expose-restful-apis-using-spring-boot-in-7-minutes
	public static void main(String[] args) {
		SpringApplication.run(IHeartMediaApplication.class, args);
	}
	
//    @Bean
//    public Docket api() { 
//        return new Docket(DocumentationType.SWAGGER_2)  
//          .select()                                  
//          .apis(RequestHandlerSelectors.any())              
//          .paths(PathSelectors.any())                          
//          .build();                                           
//    }
//    
//    
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Spring REST Sample with Swagger")
//                .description("Spring REST Sample with Swagger")
//                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
//                .contact("Niklas Heidloff")
//                .license("Apache License Version 2.0")
//                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
//                .version("2.0")
//                .build();
//    }
	
//    @Bean
//    public Docket apiDocket() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.basePackage("com.iheart.iHeart")).build();
//                //.paths(PathSelectors.any())
//                //.build();
//    }
	
//	@Override
//	public void run(String... args) throws Exception {
//
//		logger.info("Student id 10001 -> {}", repository.findById(10001L));
//	}
}

 
