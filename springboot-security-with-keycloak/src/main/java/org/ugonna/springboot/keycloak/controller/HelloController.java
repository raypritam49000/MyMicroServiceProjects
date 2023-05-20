package org.ugonna.springboot.keycloak.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/super_admin")
    public String getSuperAdmin(@RequestHeader String Authorization) {
        LOGGER.info("@@@ getSuperAdmin ::: "+Authorization);
        return "Hello Super Admin";
    }

    @GetMapping("/admin")
    public String getAdmin(@RequestHeader String Authorization) {
        LOGGER.info("@@@ getAdmin ::: "+Authorization);
        return "Hello Admin";
    }

    @GetMapping("/user")
    public String getUsers(@RequestHeader String Authorization) {
        LOGGER.info("@@@ getUsers ::: "+Authorization);
        return "Hello User";
    }

    @GetMapping("/random")
    public String getRandomUser(@RequestHeader String Authorization) {
        LOGGER.info("@@@ getRandomUser ::: ");
        return "Hello random user";
    }
}
