package ar.com.ada.sb.relationship.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class FilmDTO {

    private Long id;
    private String title;
    private String description;
    private Date year;
    private DirectorDTO director;
    private Set<ActorDTO> actors;

    public FilmDTO(Long id, String title, String description, Date year, DirectorDTO director, Set<ActorDTO> actors) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
        this.director = director;
        this.actors = actors;
    }

    public FilmDTO(String title, String description, Date year, DirectorDTO director, Set<ActorDTO> actors) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.director = director;
        this.actors = actors;
    }
}
