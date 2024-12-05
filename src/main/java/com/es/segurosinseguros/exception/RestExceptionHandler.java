package com.es.segurosinseguros.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Rest exception handler.
 */
@ControllerAdvice
public class RestExceptionHandler {
    /**
     * Handle bad request exception error msg for client.
     *
     * @param request the request
     * @param ex      the ex
     * @return the error msg for client
     */
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMsgForClient handleBadRequestException(HttpServletRequest request, BadRequestException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    /**
     * Handle validation exception error msg for client.
     *
     * @param request the request
     * @param ex      the ex
     * @return the error msg for client
     */
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMsgForClient handleValidationException(HttpServletRequest request, ValidationException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    /**
     * Handle resource not found exception error msg for client.
     *
     * @param request the request
     * @param ex      the ex
     * @return the error msg for client
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMsgForClient handleResourceNotFoundException(HttpServletRequest request, ResourceNotFoundException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    /**
     * Handle generic exception error msg for client.
     *
     * @param request the request
     * @param ex      the ex
     * @return the error msg for client
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMsgForClient handleGenericException(HttpServletRequest request, Exception ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(DuplicateException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorMsgForClient handleDuplicateException(HttpServletRequest request, DuplicateException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }
}
