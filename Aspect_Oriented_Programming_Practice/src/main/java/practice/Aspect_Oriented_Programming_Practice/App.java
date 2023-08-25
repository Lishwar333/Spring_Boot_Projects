package practice.Aspect_Oriented_Programming_Practice;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new AnnotationConfigApplicationContext(Beanconfiguration.class);
    	BusinessLogic busilgc= context.getBean(BusinessLogic.class);
    	try
    	{
    	busilgc.method1();
    	}
    	catch (Exception e) {
    	// TODO: handle exception System.out.println(e);
    }
}
