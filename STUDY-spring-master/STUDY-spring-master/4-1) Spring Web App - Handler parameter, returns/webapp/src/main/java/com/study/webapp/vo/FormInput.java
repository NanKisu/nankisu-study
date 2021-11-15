package com.study.webapp.vo;

import javax.validation.constraints.NotEmpty;

public class FormInput {
  @NotEmpty
  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return "FormInput [text=" + text + "]";
  }
  
}
