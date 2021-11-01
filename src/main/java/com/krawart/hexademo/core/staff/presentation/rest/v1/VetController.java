package com.krawart.hexademo.core.staff.presentation.rest.v1;

import com.krawart.hexademo.core.staff.application.VetManager;
import com.krawart.hexademo.core.staff.application.VetQueryService;
import com.krawart.hexademo.core.staff.application.command.AddVetCommand;
import com.krawart.hexademo.core.staff.application.command.UpdateVetCommand;
import com.krawart.hexademo.core.staff.presentation.rest.v1.dto.VetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/vets")
@RequiredArgsConstructor
class VetController {

  private final VetManager vetManager;
  private final VetQueryService vetQueryService;

  @PostMapping
  ResponseEntity<VetDTO> addVet(@RequestBody @Valid AddVetCommand command) {
    var result = vetManager.add(command);
    return ResponseEntity.created(URI.create("/api/v1/vets/" + result.getId())).build();
  }

  @PutMapping("/{id}")
  ResponseEntity<VetDTO> updateVet(@RequestBody @Valid UpdateVetCommand command, @PathVariable UUID id) {
    var result = vetManager.update(command, id);
    return ResponseEntity.ok(VetDTO.of(result));
  }

  @GetMapping("/{id}")
  ResponseEntity<VetDTO> getVet(@PathVariable UUID id) {
    var result = vetQueryService.getById(id);
    return ResponseEntity.ok(VetDTO.of(result));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteVet(@PathVariable UUID id) {
    vetManager.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
