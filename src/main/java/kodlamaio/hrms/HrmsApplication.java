package kodlamaio.hrms;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import com.cloudinary.*;
//import com.cloudinary.utils.ObjectUtils;




@SpringBootApplication
@EnableSwagger2
public class HrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);
		
		
		//Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
		//"cloud_name", "djxvzwcwj",
		//"api_key", "966476139916427",
		//"api_secret", "3GnA_jqS9A3xY7QJ6XjzYFPNhM4"));
		
		//File file = new File("my_image.jpg");
		//Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("kodlamaio.hrms"))                         
          .build();                                           
    }
	
	

}
