package ar.com.ada.sb.rest.crud.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private String email;

    public User(Long id, String name, String lastName, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public User(String name, String lastName, Integer age, String email) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User { " +
                "id=" + id +
                ", name=" + name +
                ", lastName=" + lastName +
                ", age=" + age +
                ", email=" + email +
                " }";
    }
}
