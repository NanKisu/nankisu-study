package kr.co.bunnyfoot.bunnyfoot.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BbtiResDto {
  @ApiModelProperty(name = "bbti", value = "토끼 유형 (DODO, INSSA, AGYO, SUNDING)", dataType = "string", example = "DODO")
  private String bbti;
  @ApiModelProperty(name = "predict", value = "비절병 의심 정도 (NORMAL, WATCH, WARNING, DANGER)", dataType = "string", example = "NOMRAL")
  private String predict;
}
