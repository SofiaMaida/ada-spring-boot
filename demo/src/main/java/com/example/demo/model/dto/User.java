package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id","name","last_name","age", "email"})
public class User {

    private Long id;

    @NotBlank(message = "name is requeride")
    private String name;

    @NotBlank(message = "last_name is requeride")
    @JsonProperty("last_name")
    private String lastName;

    @Min(value = 18, message = "age must be greter than or to 18")
    @Max(value = 120, message = "age must be lower or equal to 120")
    @Positive(message = "only positive values")
    @NotNull(message = "age is requeride")
    private Integer age;

    @NotBlank(message = "email is requeride")
    @Email(message = "email is not format valid")
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}

/*
https://www.baeldung.com/javax-validation
{
    name: "vladimir",
    last_nane: "castañeda",
    age: 35
}
*/
