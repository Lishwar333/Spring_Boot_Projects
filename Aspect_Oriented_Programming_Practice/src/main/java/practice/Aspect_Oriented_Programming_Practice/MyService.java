package practice.Aspect_Oriented_Programming_Practice;

import org.springframework.stereotype.Component;

@Component
public class MyService {
    public void serve() {
        System.out.println("🚀 Serving business logic");
    }

    public void riskyMethod() {
        throw new RuntimeException("Something failed");
    }
}
