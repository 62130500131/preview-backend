package sit.integrated.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class int221ProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(int221ProjectApplication.class, args);
	}

	public void  run(String... args) throws  Exception{
		String dir = "./images";
		File file = new File(dir);
		file.mkdirs();

	}
}
