package ar.acom.ada.sb.api.persistence.controller;

import ar.acom.ada.sb.api.persistence.model.dto.CourseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @PostMapping({ "", "/" })
    public ResponseEntity newCourse(@RequestBody @Valid CourseDto dto) {

        return ResponseEntity.ok().body(null);
    }
}
