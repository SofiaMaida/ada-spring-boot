package ar.com.ada.sb.api.di.service;

import ar.com.ada.sb.api.di.component.UtilsComponent;
import ar.com.ada.sb.api.di.exception.ApiEntityError;
import ar.com.ada.sb.api.di.exception.BusinessLogicException;
import ar.com.ada.sb.api.di.model.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService {

    @Autowired @Qualifier("utilsComponent")
    private UtilsComponent component;

    public Product saveNewProduct(Product product) throws BusinessLogicException {

        // En clase se dijo que en los servicios se pueden disparar excepciones de
        // logica de negocio, para este ejemplo una de las reglas es que el producto
        // que se reciba para guardarlo, no debe tener sus atributos nulos.
        // para ello se crea una clase llamada BusinessLogicException que extiende de Exception
        // para poder dispararla con el throw.
        // (ver las clase BusinessLogicException para mas detalles)
        if (product.isNull())
            throw new BusinessLogicException(
                    "can't be save new product",
                    HttpStatus.BAD_REQUEST,
                    new ApiEntityError("Product", "NotNull", "Entity can't be null")
            );

        long id = component.generateId();
        product.setId(id);

        return product;
    }
}
