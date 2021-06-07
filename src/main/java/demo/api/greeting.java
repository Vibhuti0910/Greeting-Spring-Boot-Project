package demo.api;

import demo.model.GreetingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class greeting {

    @Autowired
    GreetingData data;

    @GetMapping("/hello")
    public String getGreeting() {
        String greeting = data.getName()!= null ? data.getName() : "World";

        return "Hello " + greeting;
    }
}
