package ar.com.ada.sb.api.di.service;

import ar.com.ada.sb.api.di.component.UtilsComponent;
import ar.com.ada.sb.api.di.model.dto.ShoppingCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("shoppingCarService")
public class ShoppingCartService {

    @Autowired @Qualifier("utilsComponent")
    private UtilsComponent component;

    public ShoppingCar saveShoppingCar(ShoppingCar shoppingCar) throws Exception {
        if (shoppingCar.isNull())
            throw new Exception("ShoppingCar can't be null");

        long id = component.generateId();
        shoppingCar.setId(id);

        return shoppingCar;
    }
}
