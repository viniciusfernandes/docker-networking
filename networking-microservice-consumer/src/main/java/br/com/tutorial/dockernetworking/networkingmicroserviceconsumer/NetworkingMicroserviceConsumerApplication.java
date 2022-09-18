package br.com.tutorial.dockernetworking.networkingmicroserviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NetworkingMicroserviceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetworkingMicroserviceConsumerApplication.class, args);
	}

}
