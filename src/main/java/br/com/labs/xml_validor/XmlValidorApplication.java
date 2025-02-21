package br.com.labs.xml_validor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class XmlValidorApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlValidorApplication.class, args);
	}

}
