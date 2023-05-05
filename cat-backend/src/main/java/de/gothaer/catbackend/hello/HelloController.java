package de.gothaer.catbackend.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")

public class HelloController {
    @GetMapping
    public String hello(){
        return "Hello World";
    }


    @GetMapping("/{name}") // Erwartet ein Objekt
    public String helloName(@PathVariable String name)
    {
        return "Hello " + name;
    }





}

