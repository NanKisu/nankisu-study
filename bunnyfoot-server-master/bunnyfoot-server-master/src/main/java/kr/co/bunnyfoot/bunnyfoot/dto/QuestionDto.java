package kr.co.bunnyfoot.bunnyfoot.dto;

import lombok.Data;

@Data
public class QuestionDto {
  private ScoreDto trueScore;
  private ScoreDto falseScore;
}
