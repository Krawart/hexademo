package com.krawart.hexademo.web;

import com.krawart.hexademo.service.OwnerService;
import com.krawart.hexademo.service.command.AddOwnerCommand;
import com.krawart.hexademo.service.command.UpdateOwnerCommand;
import com.krawart.hexademo.service.dto.OwnerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/owners")
@RequiredArgsConstructor
class OwnerController {

  private final OwnerService ownerService;

  @PostMapping
  ResponseEntity<OwnerDTO> addOwner(@RequestBody @Valid AddOwnerCommand command) {
    var result = ownerService.add(command);
    return ResponseEntity.created(URI.create("/api/v1/owners/" + result.getId())).build();
  }

  @PutMapping("/{id}")
  ResponseEntity<OwnerDTO> updateOwner(@RequestBody @Valid UpdateOwnerCommand command, @PathVariable UUID id) {
    var result = ownerService.update(command, id);
    return ResponseEntity.ok(OwnerDTO.of(result));
  }

  @GetMapping("/{id}")
  ResponseEntity<OwnerDTO> getOwner(@PathVariable UUID id) {
    var result = ownerService.getById(id);
    return ResponseEntity.ok(OwnerDTO.of(result));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteOwner(@PathVariable UUID id) {
    ownerService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
