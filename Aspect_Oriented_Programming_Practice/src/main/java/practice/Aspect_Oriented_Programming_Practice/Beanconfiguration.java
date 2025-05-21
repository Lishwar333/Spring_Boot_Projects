package practice.Aspect_Oriented_Programming_Practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "practice.Aspect_Oriented_Programming_Practice")
@EnableAspectJAutoProxy
public class Beanconfiguration {
	
	@Bean
	public Employee people() {
		
		return new Employee();
	}

}
