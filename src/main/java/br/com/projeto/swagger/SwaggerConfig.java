package br.com.projeto.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	  @Bean
	  public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	          .select()
	          .apis(RequestHandlerSelectors.basePackage("br.com.projeto.controller"))
	          .apis(RequestHandlerSelectors.any())
	          .paths(PathSelectors.any())
	          .build()
	          .useDefaultResponseMessages(false)
	          .globalResponseMessage(RequestMethod.GET, responseMessageForGET())
	          .globalResponseMessage(RequestMethod.PUT,  responseMessageForPutPost())
	          .globalResponseMessage(RequestMethod.POST,  responseMessageForPutPost());
	    }
	  
	  
	  private List<ResponseMessage> responseMessageForGET()
	  {
	      return new ArrayList<ResponseMessage>() {{
	          add(new ResponseMessageBuilder()
	              .code(200)
	              .message("ok")
	              .responseModel(new ModelRef("ok"))
	              .build());
	      }};
	  }
	  
	  private List<ResponseMessage> responseMessageForPutPost()
	  {
	      return new ArrayList<ResponseMessage>() {{
	          add(new ResponseMessageBuilder()
	              .code(200)
	              .message("ok")
	              .responseModel(new ModelRef("ok"))
	              .build());
	          
	          add(new ResponseMessageBuilder()
	                  .code(500)
	                  .message("Exception!")
	                  .build());
	      }};
	  }
}
