package ar.com.ada.sb.helloworld.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWorldController {

    @GetMapping("/hi")
    public ResponseEntity sayHelloWolrd() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "wolrd");

        return ResponseEntity.ok().body(map);
    }
}
