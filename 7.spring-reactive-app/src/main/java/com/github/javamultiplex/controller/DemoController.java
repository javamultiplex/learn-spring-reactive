package com.github.javamultiplex.controller;

import com.github.javamultiplex.service.DemoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rohit Agarwal on 07/05/22 8:11 PM
 * @copyright github.com/javamultiplex
 */
@RestController
public record DemoController(DemoService demoService) {

    @PostMapping(value = "/message")
    public void demo(@RequestBody String message) {
        demoService.push(message);
    }

}
