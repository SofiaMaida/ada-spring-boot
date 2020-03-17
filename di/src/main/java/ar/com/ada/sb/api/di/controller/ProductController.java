package ar.com.ada.sb.api.di.controller;

import ar.com.ada.sb.api.di.model.dto.Product;
import ar.com.ada.sb.api.di.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired @Qualifier("productService")
    private ProductService service;

    @PostMapping({ "", "/" })
    public ResponseEntity addNewProduct(@RequestBody @Valid Product product) {
        HttpStatus status = HttpStatus.OK;

        try {
            service.saveNewProduct(product);
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity
                .status(status)
                .body(null);
    }
}
