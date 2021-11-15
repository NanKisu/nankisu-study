package com.study.webapp.rest.controller;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.study.webapp.rest.exception.APIException;
import com.study.webapp.rest.exception.NoDataException;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
  private final Map<Class<? extends Exception>, String> messageMapping = 
      Collections.unmodifiableMap(new LinkedHashMap() {
        {
          put(NoDataException.class,"NoDataException Occur!");
          put(MethodArgumentNotValidException.class,"BindingException Occur!");}});

  private String resolveMessage(Exception ex, String defaultMessage) {
    return messageMapping.entrySet().stream()
        .filter(entry -> entry.getKey().isAssignableFrom(ex.getClass())).findFirst()
        .map(Map.Entry::getValue).orElse(defaultMessage);
  }

  private APIException createAPIException(Exception e) {
    APIException apiException = new APIException();
    apiException.setMessage(resolveMessage(e, e.getMessage()));
    apiException.setDocumentationUrl("error");
    return apiException;
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    return super.handleExceptionInternal(ex, createAPIException(ex), headers, HttpStatus.OK,
        request);
  }

  @Override
  protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    System.out.println("handleBindException...");
    APIException apiException = createAPIException(ex);
    ex.getBindingResult().getGlobalErrors().stream().forEach(exception -> apiException
        .addDetail(exception.getObjectName(), exception.getDefaultMessage()));
    return super.handleExceptionInternal(ex, apiException, headers, HttpStatus.OK, request);
  }
  
  
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    System.out.println("handleMethodArgumentNotValid...");
    APIException apiException = createAPIException(ex);
    System.out.println(ex);
    ex.getBindingResult().getGlobalErrors().stream().forEach(exception -> apiException
        .addDetail(exception.getObjectName(), exception.getDefaultMessage()));
    ex.getBindingResult().getFieldErrors().stream().forEach(exception -> apiException
        .addDetail(exception.getObjectName(), exception.getDefaultMessage()));
    System.out.println(apiException);
    return super.handleExceptionInternal(ex, apiException, headers, HttpStatus.OK, request);
  }
  
  

  @ExceptionHandler(value = NoDataException.class)
  public ResponseEntity<Object> handleNoDataExceptionInternal(NoDataException ex,
      WebRequest request) {
    return handleExceptionInternal(ex, null, null, null, request);
  }

}
