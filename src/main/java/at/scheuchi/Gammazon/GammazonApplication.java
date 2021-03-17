package at.scheuchi.Gammazon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
public class GammazonApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GammazonApplication.class, args);
	}

}
