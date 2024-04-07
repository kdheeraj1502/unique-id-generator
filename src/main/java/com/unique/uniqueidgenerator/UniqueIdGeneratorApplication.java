package com.unique.uniqueidgenerator;

//import com.unique.uniqueidgenerator.service.UIDG;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniqueIdGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniqueIdGeneratorApplication.class, args);
		//long number = UIDG.randomUniqueId();
    //	System.out.println("Number is :: " + number);
	}

}
