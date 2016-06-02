package io.onecloud.service.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoyasong on 2016/6/2.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private LoadBalancerClient loadBalancer;

    private RestTemplate restTemplate = new RestTemplate();

    private List<String> products;

    public ProductController() {
        products = new ArrayList<>();
        products.add("prod1");
        products.add("prod2");
    }

    @RequestMapping("")
    public List<String> getProducts() {
        ServiceInstance instance = loadBalancer.choose("user-service");
        URI uri = instance.getUri();
        String query = uri + "/users/111";

        String userInfo = restTemplate.getForObject(query,String.class);
        log.info("get user: " + userInfo);
        products.add(userInfo);
        return products;
    }
}
