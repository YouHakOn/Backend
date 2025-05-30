package net.youhak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@PropertySource(value = "classpath:.env")
public class YouhakApplication {

	public static void main(String[] args) {
		SpringApplication.run(YouhakApplication.class, args);
	}

}
