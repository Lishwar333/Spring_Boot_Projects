package practice.Aspect_Oriented_Programming_Practice;

import org.springframework.stereotype.Component;

@Component
public class Employee implements People{

	@Override
	public void moto() {
		System.out.print("We the employee people");
		
	}
	
	

}
