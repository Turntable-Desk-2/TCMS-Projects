package io.turntabl.tcmsProjects;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@EnableSwagger2
@SpringBootApplication
public class TcmsProjectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcmsProjectsApplication.class, args);
	}


	private static Connection getConnection() throws URISyntaxException, SQLException {
		String dbUrl = System.getenv("JDBC_DATABASE_URL");
		return DriverManager.getConnection(dbUrl);
	}

}
