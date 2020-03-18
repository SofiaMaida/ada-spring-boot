package ar.com.ada.sb.api.di.controller;

import ar.com.ada.sb.api.di.model.dto.ShoppingCar;
import ar.com.ada.sb.api.di.service.ShoppingCarService;
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
@RequestMapping("/shopping-car")
public class ShoppingCarController {

    @Autowired @Qualifier("shoppingCarService")
    private ShoppingCarService service;

    @PostMapping({ "", "/" })
    public ResponseEntity addNewShopping(@RequestBody @Valid ShoppingCar shoppingCar) throws Exception {
        // se aplica la misma logica que se explica en ProductController
        service.saveShoppingCar(shoppingCar);
        return ResponseEntity
                .ok()
                .body(null);
    }
}
