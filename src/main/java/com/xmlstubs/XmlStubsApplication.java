package com.xmlstubs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XmlStubsApplication {
	public static final Logger logger = LoggerFactory.getLogger(XmlStubsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(XmlStubsApplication.class, args);
	}

}
