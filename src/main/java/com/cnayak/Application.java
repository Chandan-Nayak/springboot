package com.cnayak;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@RestController
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
public class Application {


    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Example.class, args);
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
        
    }

}