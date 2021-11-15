package com.study.webapp.valiation.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ObjectUtils;

public class IsEqualTwoPropertiesValidator implements ConstraintValidator<IsEqualTwoProperties, Object> {
    
  private String property1;
  private String property2;
  private String message;
  
  
  
  @Override
  public void initialize(IsEqualTwoProperties constraintAnnotation) {
    // TODO Auto-generated method stub
    property1 = constraintAnnotation.property1();
    property2 = constraintAnnotation.property2();
    message = constraintAnnotation.message();
  }



  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    // TODO Auto-generated method stub
    BeanWrapper beanWrapper = new BeanWrapperImpl(value);
    System.out.println("value:" + value);
    System.out.println("property1:" + property1);
    System.out.println("property2:" + property2);
    Object property1Value = beanWrapper.getPropertyValue(property1);
    Object property2Value = beanWrapper.getPropertyValue(property2);
    Boolean result = ObjectUtils.nullSafeEquals(property1Value, property2Value);
    
    if(!result) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(message).addPropertyNode(property1).addConstraintViolation();
    }
    
    return result;
  }
  
  
}
