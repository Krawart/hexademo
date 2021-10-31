package com.krawart.hexademo.core.patient.presentation.rest.v1;

import com.krawart.hexademo.core.patient.application.OwnerManager;
import com.krawart.hexademo.core.patient.application.OwnerQueryService;
import com.krawart.hexademo.core.patient.application.command.AddOwnerCommand;
import com.krawart.hexademo.core.patient.application.command.UpdateOwnerCommand;
import com.krawart.hexademo.core.patient.application.dto.OwnerDTO;
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

  private final OwnerManager ownerManager;
  private final OwnerQueryService ownerQueryService;

  @PostMapping
  ResponseEntity<OwnerDTO> addOwner(@RequestBody @Valid AddOwnerCommand command) {
    var result = ownerManager.add(command);
    return ResponseEntity.created(URI.create("/api/v1/owners/" + result.getId())).build();
  }

  @PutMapping("/{id}")
  ResponseEntity<OwnerDTO> updateOwner(@RequestBody @Valid UpdateOwnerCommand command, @PathVariable UUID id) {
    var result = ownerManager.update(command, id);
    return ResponseEntity.ok(OwnerDTO.of(result));
  }

  @GetMapping("/{id}")
  ResponseEntity<OwnerDTO> getOwner(@PathVariable UUID id) {
    var result = ownerQueryService.getById(id);
    return ResponseEntity.ok(OwnerDTO.of(result));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteOwner(@PathVariable UUID id) {
    ownerManager.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
