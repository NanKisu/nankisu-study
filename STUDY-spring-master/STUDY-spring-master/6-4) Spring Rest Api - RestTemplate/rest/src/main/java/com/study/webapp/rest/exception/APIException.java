package com.study.webapp.rest.exception;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class APIException {
  @Data
  private static class Detail {
    private final String target;
    private final String message;
  }

  private String message;
  private String documentationUrl;
  @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
	private final List<Detail> details = new ArrayList<>();
  
  public void addDetail(String target, String message) {
    details.add(new Detail(target, message));
  }
}
