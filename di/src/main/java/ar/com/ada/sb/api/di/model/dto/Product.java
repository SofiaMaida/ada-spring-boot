package ar.com.ada.sb.api.di.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class Product {

    private Long id;

    // anotaciones de validadciones
    private String nane;

    // anotaciones de validadciones
    private Date expire;

    public Product(Long id, String nane, Date expire) {
        this.id = id;
        this.nane = nane;
        this.expire = expire;
    }

    public Product(String nane, Date expire) {
        this.nane = nane;
        this.expire = expire;
    }

    @Override
    public String toString() {
        return "Product { " +
                "id=" + id +
                ", nane=" + nane +
                ", expire=" + expire +
                " }";
    }

    public Boolean isNull() {
        return this.nane == null &&
                this.expire == null;
    }
}
