package com.study.springmvcwithoutxml.vo;

import javax.validation.constraints.NotEmpty;

public class InputText {
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
    return "InputText [text=" + text + "]";
  }
}
