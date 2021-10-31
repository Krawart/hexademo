package com.krawart.hexademo.shared.infrastructure.persistence.converter;

import com.krawart.hexademo.shared.domain.value.Email;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
@SuppressWarnings("unused")
public class EmailConverter implements AttributeConverter<Email, String> {
  @Override
  public String convertToDatabaseColumn(Email attribute) {
    return attribute.email();
  }

  @Override
  public Email convertToEntityAttribute(String dbData) {
    return new Email(dbData);
  }
}
