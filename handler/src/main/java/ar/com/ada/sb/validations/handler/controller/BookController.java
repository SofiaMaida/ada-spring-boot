package ar.com.ada.sb.validations.handler.controller;

import ar.com.ada.sb.validations.handler.model.dto.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping({ "", "/" })
    public ResponseEntity addNewBook(@RequestBody @Valid Book book) throws URISyntaxException {
        long id = new Random().nextLong() % (100 - 10) + 10;
        book.setId(id);
        return ResponseEntity
                .created(new URI("/books/"+id))
                .body(book);
    }
}
