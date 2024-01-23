package com.krawart.hexademo.core.patient.presentation.rest.v1;

import com.krawart.hexademo.core.patient.application.PetManager;
import com.krawart.hexademo.core.patient.application.PetQueryService;
import com.krawart.hexademo.core.patient.application.command.AddPetCommand;
import com.krawart.hexademo.core.patient.application.command.UpdatePetCommand;
import com.krawart.hexademo.core.patient.presentation.rest.v1.dto.PetDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
class PetController {

  private final PetManager petManager;
  private final PetQueryService petQueryService;

  @PostMapping
  ResponseEntity<PetDTO> addPet(@RequestBody @Valid AddPetCommand command) {
    var result = petManager.add(command);
    return ResponseEntity.created(URI.create("/api/v1/pets/" + result.getId())).build();
  }

  @PutMapping("/{id}")
  ResponseEntity<PetDTO> updatePet(@RequestBody @Valid UpdatePetCommand command, @PathVariable UUID id) {
    var result = petManager.update(command, id);
    return ResponseEntity.ok(PetDTO.of(result));
  }

  @GetMapping("/{id}")
  ResponseEntity<PetDTO> getPet(@PathVariable UUID id) {
    var result = petQueryService.getById(id);
    return ResponseEntity.ok(PetDTO.of(result));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deletePet(@PathVariable UUID id) {
    petManager.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
