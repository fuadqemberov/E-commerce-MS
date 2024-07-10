package az.company.diskoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiskoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiskoveryServerApplication.class, args);
    }

}
