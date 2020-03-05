package ar.com.ada.spring.classone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    @GetMapping("/hi")
    public ResponseEntity helloWorld() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "world");

        return ResponseEntity.ok().body(map);
    }

}
