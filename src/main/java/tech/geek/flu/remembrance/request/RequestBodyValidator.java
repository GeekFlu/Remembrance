package tech.geek.flu.remembrance.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;
import tech.geek.flu.remembrance.controller.RemembranceController;
import tech.geek.flu.remembrance.domain.exception.RemembranceBadRequestException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

@Slf4j
@ControllerAdvice
public class RequestBodyValidator extends RequestBodyAdviceAdapter {

  Validator validator= Validation.buildDefaultValidatorFactory().getValidator();

  private final List<Class<?>> targetClass = List.of(RemembranceController.class);


  @Override
  public boolean supports(MethodParameter methodParameter,
                          Type targetType,
                          Class<? extends HttpMessageConverter<?>> converterType) {
    return targetClass.contains(methodParameter.getContainingClass());
  }

  @Override
  public Object afterBodyRead(Object body,
                              HttpInputMessage inputMessage,
                              MethodParameter parameter,
                              Type targetType,
                              Class<? extends HttpMessageConverter<?>> converterType) {
    Set<ConstraintViolation<Object>> violations = validator.validate(body);
    if (!violations.isEmpty()) {
      throw new RemembranceBadRequestException(violations);
    }
    return body;
  }
}
