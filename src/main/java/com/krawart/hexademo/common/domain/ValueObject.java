package com.krawart.hexademo.common.domain;

import org.springframework.data.annotation.Immutable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker interface for all value objects.
 * Object must be immutable and implement equals() and hashCode(). Good candidate for java record
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Immutable
public @interface ValueObject {
}
