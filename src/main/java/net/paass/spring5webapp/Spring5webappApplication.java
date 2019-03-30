package net.paass.spring5webapp;

import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Spring5webappApplication {

  public static void main(String[] args) {
    SpringApplication.run(Spring5webappApplication.class, args);
  }

}
