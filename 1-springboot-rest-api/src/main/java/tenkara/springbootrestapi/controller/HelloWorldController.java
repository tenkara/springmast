package tenkara.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // HTTP GET request to / and avoid 404 error
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    // HTTP GET request to /hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

}
