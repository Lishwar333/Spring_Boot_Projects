package practice.Aspect_Oriented_Programming_Practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new AnnotationConfigApplicationContext(Beanconfiguration.class);
    	
    	People people = (People) context.getBean("people");
    	people.moto();
    	
    	MyService service = context.getBean(MyService.class);
        
        service.serve();
        
        try {
            service.riskyMethod();
        } catch (Exception e) {
            System.out.println("⚠️ Caught exception in main");
        }
    }
}
