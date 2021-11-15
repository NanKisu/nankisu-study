package com.study.webapp.valiation.dto;

import java.util.List;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class SizeInDto {
  private List<String> var;
}
