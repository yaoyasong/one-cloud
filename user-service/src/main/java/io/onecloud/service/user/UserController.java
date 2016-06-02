package io.onecloud.service.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoyasong on 2016/6/2.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private List<String> users;

    public UserController() {
        users = new ArrayList();
        users.add("DemoUser1");
        users.add("DemoUser2");
        users.add("DemoUser3");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<String> getUsers() {
        return users;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getUser(@PathVariable String userId) {

        return "DemoUser1";
    }

}
