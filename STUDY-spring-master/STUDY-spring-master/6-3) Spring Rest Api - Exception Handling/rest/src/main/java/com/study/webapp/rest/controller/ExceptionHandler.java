package com.study.webapp.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.study.webapp.rest.exception.APIException;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
  private APIException createAPIException(Exception e) {
    APIException apiException = new APIException();
    apiException.setMessage(e.getMessage());
    apiException.setDocumentationUrl("error");
    return apiException;
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    return super.handleExceptionInternal(ex, createAPIException(ex), headers, status, request);
  }
  
}
