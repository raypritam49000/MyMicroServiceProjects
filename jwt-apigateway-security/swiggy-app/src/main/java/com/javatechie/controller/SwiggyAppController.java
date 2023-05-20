package com.javatechie.controller;

import com.javatechie.dto.OrderResponseDTO;
import com.javatechie.service.SwiggyAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swiggy")
public class SwiggyAppController {

    private final Logger LOGGER = LoggerFactory.getLogger(SwiggyAppController.class);

    @Autowired
    private SwiggyAppService service;

    @GetMapping("/home")
    public String greetingMessage() {
        return service.greeting();
    }

    @GetMapping("/{orderId}")
    public OrderResponseDTO checkOrderStatus(@PathVariable String orderId, @RequestHeader("loggedInUser") String username) {
        LOGGER.info("logged in user details : " + username);
        return service.checkOrderStatus(orderId);
    }
}
