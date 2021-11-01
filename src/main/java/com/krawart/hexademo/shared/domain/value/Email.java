package com.krawart.hexademo.shared.domain.value;

import com.krawart.hexademo.common.domain.ValueObject;
import org.springframework.util.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ValueObject
public record Email(String email) {
  public Email {
    Assert.notNull(email, "Email cannot be undefined");
    Assert.isTrue(isValid(email), "Email must be in valid format");
  }

  private static boolean isValid(String email) {
    Pattern regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    Matcher matcher = regex.matcher(email);
    return matcher.find();
  }
}
