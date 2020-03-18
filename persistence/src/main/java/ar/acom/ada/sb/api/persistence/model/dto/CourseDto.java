package ar.acom.ada.sb.api.persistence.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor
public class CourseDto implements Serializable {
    private Long id;
    private String name;
    private String code;
    private BigDecimal price;
    private String description;

    public CourseDto(Long id, String name, String code, BigDecimal price, String description) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.description = description;
    }

    public CourseDto(String name, String code, BigDecimal price, String description) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "CourseDto {" +
                "id=" + id +
                ", name=" + name +
                ", code=" + code +
                ", price=" + price +
                ", description=" + description +
                " }";
    }
}
