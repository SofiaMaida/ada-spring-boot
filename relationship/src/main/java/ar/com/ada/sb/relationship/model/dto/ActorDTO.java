package ar.com.ada.sb.relationship.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ActorDTO {

    private Long id;
    private String name;
    private String gender;
    private Date birthday;
    private String bio;
    private Set<FilmDTO> films;

    public ActorDTO(Long id, String name, String gender, Date birthday, String bio, Set<FilmDTO> films) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.bio = bio;
        this.films = films;
    }

    public ActorDTO(String name, String gender, Date birthday, String bio, Set<FilmDTO> films) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.bio = bio;
        this.films = films;
    }
}
