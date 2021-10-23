package com.krawart.hexademo.web;

import com.krawart.hexademo.service.UserService;
import com.krawart.hexademo.service.command.AddUserCommand;
import com.krawart.hexademo.service.command.UpdateUserCommand;
import com.krawart.hexademo.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
class UserController {

  private final UserService userService;

  @PostMapping
  ResponseEntity<UserDTO> addUser(@RequestBody AddUserCommand command) {
    var result = userService.add(command);
    return ResponseEntity.created(URI.create("/api/v1/users/" + result.getId())).build();
  }

  @PutMapping("/{id}")
  ResponseEntity<UserDTO> updateUser(@RequestBody UpdateUserCommand command, @PathVariable UUID id) {
    var result = userService.update(command, id);
    return ResponseEntity.ok(UserDTO.of(result));
  }

  @GetMapping("/{id}")
  ResponseEntity<UserDTO> getUser(@PathVariable UUID id) {
    var result = userService.getById(id);
    return ResponseEntity.ok(UserDTO.of(result));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
    userService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
