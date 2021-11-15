package com.study.webapp.valiation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import com.study.webapp.valiation.validator.IsEqualTwoPropertiesValidator;

@Documented
@Constraint(validatedBy = {IsEqualTwoPropertiesValidator.class})
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsEqualTwoProperties {
  
  String message() default "{com.study.webapp.valiation.annotation.IsEqualTwoProperties.message}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
  
  String property1();
  String property2();
  
  @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
  @Retention(RetentionPolicy.RUNTIME)
  @Documented
  public @interface List{
    IsEqualTwoProperties[] value();
  }
}
