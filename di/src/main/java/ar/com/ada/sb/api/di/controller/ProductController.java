package ar.com.ada.sb.api.di.controller;

import ar.com.ada.sb.api.di.exception.BusinessLogicException;
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
    public ResponseEntity addNewProduct(@RequestBody @Valid Product product) throws BusinessLogicException {
        // Anteriormente existia un try-catch para capturar la posibles execption producida en el
        // metodo saveNewProduct, pero camo se creo un Advice para las excepciones de tipo
        // BusinessLogicException ya no es necesario validar eso.
        // ver el codigo en el servicio.
        Product productResult = service.saveNewProduct(product);
        return ResponseEntity
                .ok()
                .body(productResult);
    }
}
