package com.krawart.hexademo.service.command;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateUserCommand {
  private String firstName;
  private String lastName;
  private String email;
}
