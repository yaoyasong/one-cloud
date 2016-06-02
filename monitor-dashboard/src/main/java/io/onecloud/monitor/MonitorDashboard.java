package io.onecloud.monitor;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yaoyasong on 2016/6/2.
 */
@SpringBootApplication
@Controller
@EnableHystrixDashboard
@EnableDiscoveryClient
public class MonitorDashboard extends SpringBootServletInitializer {
    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MonitorDashboard.class).web(true);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(MonitorDashboard.class).web(true).run(args);
    }
}
