package net.vino9.vino.demo.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/rest/hello")
    public String hello() {
        return "world";
    }
}
