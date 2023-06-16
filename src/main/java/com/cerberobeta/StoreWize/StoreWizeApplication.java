package com.cerberobeta.StoreWize;

import com.cerberobeta.StoreWize.utils.ProcesUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = { MongoAutoConfiguration.class, MongoDataAutoConfiguration.class, MongoRepositoriesAutoConfiguration.class })
public class StoreWizeApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(StoreWizeApplication.class, args);

	}

}
