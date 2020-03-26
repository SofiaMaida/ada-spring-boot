package ar.com.ada.sb.relationship.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class DirectorDTO {

    private Long id;
    private String name;
    private String bio;
    private Set<FilmDTO> films;

    public DirectorDTO(Long id, String name, String bio, Set<FilmDTO> films) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.films = films;
    }

    public DirectorDTO(String name, String bio, Set<FilmDTO> films) {
        this.name = name;
        this.bio = bio;
        this.films = films;
    }
}
