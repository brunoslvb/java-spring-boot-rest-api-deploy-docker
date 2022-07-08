package br.com.dockerapi.controllers;

import br.com.dockerapi.exceptions.ObjectNotFoundException;
import br.com.dockerapi.models.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    private List<String> buildErrors(String ...errors){
        return Arrays.asList(errors.clone());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Object> handleRuntimeException(RuntimeException ex){
        return new ApiResponse<>(buildErrors("Erro ao executar operação"));
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Object> handleObjectNotFoundException(ObjectNotFoundException ex){
        return new ApiResponse<>(buildErrors(ex.getMessage()));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ApiResponse<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
        return new ApiResponse<>(buildErrors("Método '" + ex.getMethod() + "' não permitido nesta rota"));
    }

}
