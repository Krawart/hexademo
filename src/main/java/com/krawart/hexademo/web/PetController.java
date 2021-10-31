package com.krawart.hexademo.web;

import com.krawart.hexademo.service.PetService;
import com.krawart.hexademo.service.command.AddPetCommand;
import com.krawart.hexademo.service.command.UpdatePetCommand;
import com.krawart.hexademo.service.dto.PetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
class PetController {

  private final PetService petService;

  @PostMapping
  ResponseEntity<PetDTO> addPet(@RequestBody @Valid AddPetCommand command) {
    var result = petService.add(command);
    return ResponseEntity.created(URI.create("/api/v1/pets/" + result.getId())).build();
  }

  @PutMapping("/{id}")
  ResponseEntity<PetDTO> updatePet(@RequestBody @Valid UpdatePetCommand command, @PathVariable UUID id) {
    var result = petService.update(command, id);
    return ResponseEntity.ok(PetDTO.of(result));
  }

  @GetMapping("/{id}")
  ResponseEntity<PetDTO> getPet(@PathVariable UUID id) {
    var result = petService.getById(id);
    return ResponseEntity.ok(PetDTO.of(result));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deletePet(@PathVariable UUID id) {
    petService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
