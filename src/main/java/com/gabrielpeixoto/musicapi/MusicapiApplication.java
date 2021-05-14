package com.gabrielpeixoto.musicapi;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class MusicapiApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(MusicapiApplication.class, args);
		System.out.println("Músicas com webflux");
	}

}
