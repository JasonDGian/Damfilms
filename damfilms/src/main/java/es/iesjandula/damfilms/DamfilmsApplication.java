package es.iesjandula.damfilms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.iesjandula.damfilms.utils.DamfilmsServerError;

@SpringBootApplication
public class DamfilmsApplication implements CommandLineRunner{
	    
	public static void main(String[] args) throws DamfilmsServerError
	{
		SpringApplication.run(DamfilmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		// TODO Auto-generated method stub
		
	}
	
}
