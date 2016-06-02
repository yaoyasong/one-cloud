package io.onecloud.service.user;

import com.netflix.discovery.DiscoveryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yaoyasong on 2016/6/1.
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class UserApplication {

    private static final Logger log = LoggerFactory.getLogger(UserApplication.class);

    @RequestMapping("/")
    public String home() {
        return "hello cloud.";
    }

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                log.info("Shutting down, unregister from eureka");
                DiscoveryManager.getInstance().shutdownComponent();
            }
        });
    }
}
