package com.study.webapp.valiation.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.study.webapp.valiation.dto.MyValidatorInDto;

@Component
public class MyValidator implements Validator{

  @Override
  public boolean supports(Class<?> clazz) {
    // TODO Auto-generated method stub
    return MyValidatorInDto.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    // TODO Auto-generated method stub
    MyValidatorInDto sizeInDto = MyValidatorInDto.class.cast(target);
    Integer size = sizeInDto.getVar().size();
    if(size != 4) {
      errors.rejectValue("var", "길이는 반드시 4.");
    }
  }

}
