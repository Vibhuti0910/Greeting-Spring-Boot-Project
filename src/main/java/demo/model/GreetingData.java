package demo.model;

import org.springframework.stereotype.Component;

@Component
public class GreetingData {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
