package com.PKHS.airbnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirbnbApplication {

	public static void main(String[] args) {
		new File(PostRentController.uploadDirectory).mkdir();
		new File(MyUploadController.uploadDirectoryFile).mkdir();
		SpringApplication.run(AirbnbApplication.class, args);
	}
}
