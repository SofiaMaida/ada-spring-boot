package ar.com.ada.sb.api.di.service;

import ar.com.ada.sb.api.di.component.UtilsComponent;
import ar.com.ada.sb.api.di.exception.ApiEntityError;
import ar.com.ada.sb.api.di.exception.BusinessLogicException;
import ar.com.ada.sb.api.di.model.dto.ShoppingCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("shoppingCarService")
public class ShoppingCarService {

    @Autowired @Qualifier("utilsComponent")
    private UtilsComponent component;

    public ShoppingCar saveShoppingCar(ShoppingCar shoppingCar) throws Exception {

        // se aplica la misma logica que se explica en ProductService
        if (shoppingCar.isNull())
            throw new BusinessLogicException(
                    "ShoppingCar can't be null",
                    HttpStatus.BAD_REQUEST,
                    new ApiEntityError("ShoppingCar", "NotNull", "Entity can't be null")
            );

        long id = component.generateId();
        shoppingCar.setId(id);

        return shoppingCar;
    }
}
