package com.krawart.hexademo.web;

import com.krawart.hexademo.service.VetService;
import com.krawart.hexademo.service.command.AddVetCommand;
import com.krawart.hexademo.service.command.UpdateVetCommand;
import com.krawart.hexademo.service.dto.VetDTO;
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

  private final VetService vetService;

  @PostMapping
  ResponseEntity<VetDTO> addVet(@RequestBody @Valid AddVetCommand command) {
    var result = vetService.add(command);
    return ResponseEntity.created(URI.create("/api/v1/vets/" + result.getId())).build();
  }

  @PutMapping("/{id}")
  ResponseEntity<VetDTO> updateVet(@RequestBody @Valid UpdateVetCommand command, @PathVariable UUID id) {
    var result = vetService.update(command, id);
    return ResponseEntity.ok(VetDTO.of(result));
  }

  @GetMapping("/{id}")
  ResponseEntity<VetDTO> getVet(@PathVariable UUID id) {
    var result = vetService.getById(id);
    return ResponseEntity.ok(VetDTO.of(result));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteVet(@PathVariable UUID id) {
    vetService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
