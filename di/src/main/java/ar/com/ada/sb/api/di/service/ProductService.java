package ar.com.ada.sb.api.di.service;

import ar.com.ada.sb.api.di.component.UtilsComponent;
import ar.com.ada.sb.api.di.model.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService {

    @Autowired @Qualifier("utilsComponent")
    private UtilsComponent component;

    public Product saveNewProduct(Product product) throws Exception {
        if (product.isNull())
            throw new Exception("Product can't be null");

        long id = component.generateId();
        product.setId(id);

        return product;
    }
}
