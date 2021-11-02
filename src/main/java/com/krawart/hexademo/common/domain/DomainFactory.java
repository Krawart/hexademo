package com.krawart.hexademo.common.domain;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Sometime is business logic involved in creation process. This is handled with factories.
 * Their only responsibility is to create aggregates in safe and consistent way
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface DomainFactory {

  @AliasFor(annotation = Component.class)
  String value() default "";
}