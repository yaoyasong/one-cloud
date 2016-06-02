package io.onecloud.service.product;

import com.netflix.discovery.DiscoveryManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by yaoyasong on 2016/6/2.
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                DiscoveryManager.getInstance().shutdownComponent();
            }
        });

    }

}
