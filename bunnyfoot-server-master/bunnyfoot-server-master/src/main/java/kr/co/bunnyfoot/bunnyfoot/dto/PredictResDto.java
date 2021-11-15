package kr.co.bunnyfoot.bunnyfoot.dto;

import lombok.Data;

@Data
public class PredictResDto {
  private Double probability;
  private Boolean success;
}
