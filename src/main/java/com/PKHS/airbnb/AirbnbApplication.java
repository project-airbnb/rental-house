package com.PKHS.airbnb;

import com.PKHS.airbnb.controller.MyUploadController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication
public class AirbnbApplication {

	public static void main(String[] args) {
		new File(MyUploadController.uploadDirectory).mkdir();
		SpringApplication.run(AirbnbApplication.class, args);
	}
}
