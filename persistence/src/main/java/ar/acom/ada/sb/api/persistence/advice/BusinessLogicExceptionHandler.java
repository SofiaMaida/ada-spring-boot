package ar.acom.ada.sb.api.persistence.advice;

import ar.acom.ada.sb.api.persistence.exception.ApiEntityError;
import ar.acom.ada.sb.api.persistence.exception.ApiErrorsResponseBody;
import ar.acom.ada.sb.api.persistence.exception.BusinessLogicException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@RestControllerAdvice
public class BusinessLogicExceptionHandler {

    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity handleBusinessLogicException(BusinessLogicException e, NativeWebRequest req) {

        HttpStatus httpStatus = e.getHttpStatus() != null ?
                e.getHttpStatus() :
                INTERNAL_SERVER_ERROR;

        ApiErrorsResponseBody apiErrorsResponseBody = new ApiErrorsResponseBody<ApiEntityError>(
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                e.getEntityErrors());

        return ResponseEntity
                .status(httpStatus)
                .body(apiErrorsResponseBody);
    }
}
