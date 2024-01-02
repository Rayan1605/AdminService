package Backend.libaryproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //This is to enable feign clients
public class AdminServiceMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServiceMicroserviceApplication.class, args);
    }

}
