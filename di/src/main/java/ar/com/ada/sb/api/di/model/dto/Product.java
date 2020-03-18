package ar.com.ada.sb.api.di.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class Product {

    private Long id;

    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "name contains not allowed characters")
    private String nane;

    @Future(message = "expire must be a future date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
