package ar.com.ada.sb.api.di.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class ShoppingCar {

    private Long id;

    // anotaciones de validadciones
    private List<Product> products;

    public ShoppingCar(Long id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public ShoppingCar(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ShoppingCar { " +
                "id=" + id +
                ", products=" + products +
                " }";
    }

    public Boolean isNull() {
        return products.isEmpty();
    }
}
