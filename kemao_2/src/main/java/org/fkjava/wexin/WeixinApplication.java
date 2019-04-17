package org.fkjava.wexin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.fkjava")
public class WeixinApplication implements CommonsConfig {

	public static void main(String[] args) {
		SpringApplication.run(WeixinApplication.class, args);
	}
}
