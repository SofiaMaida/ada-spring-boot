package ar.com.ada.sb.api.persistence.model.repository;

import ar.com.ada.sb.api.persistence.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // El tipo de dato Optional se basa en el patron de diseño Option
    // el cual nos permite mostrar la posibilidad de que un método pueda no devolver el valor deseado.
    // Para este caso, la consulta a la DB puede o no traer resultados.
    // Al usar Optional nos obliga a controlar la posible ausencia de la consulta de manera explicita,
    // si no se usa un Optional, debemos aplicar la validacion del retorno del metodo [ if (variable != null) ]
    // veremos como se usa el Optional en CourseServices.save()
    // para ver mas del tema:
    // https://www.adictosaltrabajo.com/2015/03/02/optional-java-8/
    Optional<Course> findByCode(String code);

//    Optional<Course> findByName(String name);
//    Optional<Course> findByCodeAndName(String code, String name);
}
