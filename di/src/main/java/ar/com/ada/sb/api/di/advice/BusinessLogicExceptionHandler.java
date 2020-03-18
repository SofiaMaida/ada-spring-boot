package ar.com.ada.sb.api.di.advice;

import ar.com.ada.sb.api.di.exception.ApiEntityError;
import ar.com.ada.sb.api.di.exception.BusinessLogicException;
import ar.com.ada.sb.api.di.exception.validations.ApiErrorsResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


// este Advice espara definir las capturas de las excepciones que se puedan disparar en nuestro
// codigo, inicialmente vamos a capturar las excepciones de tipo BusinessLogicException
@RestControllerAdvice
public class BusinessLogicExceptionHandler {

    // Este es el metodo que se encargará de capturar las excepciones de tipo BusinessLogicException y
    // armará el Response al usuario para indicarle que algo salió mal.
    // si notan, este metodo de Advice es un poco diferente al que captura las excepciones de
    // validaciones, este contiene una anotacion llamada ExceptionHandler y recibe como parametro las clase
    // a la cual estará monitoreando para su captura.
    // y como parametros del metodo, recibe una varable "e" que es de tipo BusinessLogicException
    // y el contenido del metodo es un poco mas simple que el de validacion
    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity handleBusinessLogicException(BusinessLogicException e, NativeWebRequest req) {

        // aqui se verifica su la excepcion (BusinessLogicException) tiene un estatus definido, de no tenerlo,
        // setea uno por defecto (INTERNAL_SERVER_ERROR)
        HttpStatus httpStatus = e.getHttpStatus() != null ? e.getHttpStatus() : INTERNAL_SERVER_ERROR;

        // de la excepcion (BusinessLogicException) se extrae la lista de errores que se pudieron crear en el flujo
        // y en base a ellas, se crea el objeto de respuesta (ApiErrorsResponseBody)
        // Nota: la clase ApiErrorsResponseBody se le hizo una modificacion para que funcionara como una clase de tipo
        // genericts y que pueda tener 2 tipos de errores en su lista: ApiEntityError y ApiFieldError, para ver ese cambio
        // vayan a la clase ApiErrorsResponseBody y la comparan con el de la clse enterior
        ApiErrorsResponseBody apiErrorsResponseBody = new ApiErrorsResponseBody<ApiEntityError>(
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                e.getEntityErrors());

        // se crea la respuesta (informando el o los errores producidos)
        return ResponseEntity
                .status(httpStatus)
                .body(apiErrorsResponseBody);
    }
}
