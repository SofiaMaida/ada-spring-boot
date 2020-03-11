package ar.com.ada.sb.rest.crud.controller;

import ar.com.ada.sb.rest.crud.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    @GetMapping({ "", "/" })
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok().body(users);
    }

    @PostMapping({ "", "/" })
    public ResponseEntity createUser(@RequestBody User user) throws URISyntaxException {
        // cuanto la cantidad de elementos que hay en la lista
        // stream es de las expresiones lambda de java 8, luego la vemos a detalles. OK?
        long count = users.stream().count();

        // if ternary: evalua si la cantidad en la lista es mayor a cero
        User userFromList = (count > 0) ?
                // en la instruccion true: de la lista saca el ultimo elemento insertado y
                // lo retorna
                users.stream().skip(count - 1).findFirst().orElse(null) :
                // en la instruccion false: retorna un null
                null;

        // if ternay: para definir el nuevo id del usuario a insertar en la lista
        long id = (userFromList != null) ?
                // en instruccion true: extrae el id del ultimo usuario, le suma 1 y retorna el nuevo valor
                userFromList.getId() + 1 :
                // en la instruccion false: retorna 1 directamente porque la lista esta vacia.
                1;

        // asigno el id generado en el if ternary anterior al usuario que se quiere agregar
        user.setId(id);

        // agrego el usuario nuevo a la lista.
        users.add(user);

        // retorno el response del la peticion POST.
        return ResponseEntity
                .created(new URI("/users/" + user.getId()))
                .body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        // stream es de las expresiones lambda de java 8, luego la vemos a detalles. OK?
        User user = users.stream()
                // se define un filtro para fucar de la lista el objeto que cumpla con
                // la condicion del filtro: por cada usuario de la lista se compara
                // su id (.getId()) con el id del parametro de la url (id)
                .filter(u -> u.getId() == id)
                // una vez filtrado, se indica que se retorne el primero encontrado
                .findFirst()
                // en caso que no se consiga un registro que cumpla con el filtro
                // que retornu null
                .orElse(null);

        // se define una variable httpStatus para la respuesta en base a si de la busqueda
        // en la lista fue exitosa o no
        HttpStatus httpStatus = user != null ?
                HttpStatus.OK :
                HttpStatus.NOT_FOUND;

        // se retorna la respuesta.
        return ResponseEntity.status(httpStatus).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUserById(@RequestBody User user, @PathVariable Long id) {
        // stream es de las expresiones lambda de java 8, luego la vemos a detalles. OK?
        boolean hasUserExist = users.stream()
                // se busca cualquier objeto de la lista que cumpla con la condicion
                // en teoria solo debe haber uno porque el id es unico.
                // el resultado de esta funcion lambda es true o false
                .anyMatch(u -> u.getId() == id);

        // se crea e inicializa a null una variable de tipo HttpStatus
        // esto será es status de la respuesta
        HttpStatus httpStatus = null;

        // se verifica si se encontró el user que se quiere actualizar
        if (hasUserExist) {
            // se asigna un valor al status
            httpStatus = HttpStatus.OK;

            // se recorre cada usuario y al encontrar el que se desea actualizar ( u.getId() == id )
            // se asigna los valores que trae de ResponseBody (user)
            users.forEach(u -> {
                if (u.getId() == id) {
                    u.setName(user.getName());
                    u.setLastName(user.getLastName());
                    u.setAge(user.getAge());
                    u.setEmail(user.getEmail());
                    user.setId(u.getId());
                }
            });
        } else {
            // en caso que no se haya conseguido el usario en la lista
            // se settea un NOT_FOUND en el status
            httpStatus = HttpStatus.NOT_FOUND;
        }

        return ResponseEntity
                .status(httpStatus)
                .body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        // con esta funcion se eliminar de la lista el usuario que cumpla con la
        // condicion de busqueda, el resultado devuelve un true o false
        boolean hasDelete = users.removeIf(u -> u.getId() == id);

        // se arma un mapa para la respuesta incorrecta (BAD_REQUEST)
        // esta ocurre cuando no se consigue el usuario con el id que suministro la
        // petición en la url
        Map<String, String> map = new HashMap<>();
        map.put("error", HttpStatus.BAD_REQUEST.toString());
        map.put("message", "user id not exist");

        // se retorna una respuesta noContent si se logró eliminar el registro de la lista
        // o un badRequest si no existe un usuario con el id
        // esa evaluacion de la determina la variable hasDelete
        return (hasDelete) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.badRequest().body(map);
    }
}
