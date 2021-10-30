package com.krawart.hexademo.web;

import com.krawart.hexademo.service.EquipmentService;
import com.krawart.hexademo.service.command.AddEquipmentCommand;
import com.krawart.hexademo.service.command.UpdateEquipmentCommand;
import com.krawart.hexademo.service.dto.EquipmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/equipments")
@RequiredArgsConstructor
class EquipmentController {

  private final EquipmentService equipmentService;

  @PostMapping
  ResponseEntity<EquipmentDTO> addEquipment(@RequestBody @Valid AddEquipmentCommand command) {
    var result = equipmentService.add(command);
    return ResponseEntity.created(URI.create("/api/v1/equipments/" + result.getId())).build();
  }

  @PutMapping("/{id}")
  ResponseEntity<EquipmentDTO> updateEquipment(@RequestBody @Valid UpdateEquipmentCommand command, @PathVariable UUID id) {
    var result = equipmentService.update(command, id);
    return ResponseEntity.ok(EquipmentDTO.of(result));
  }

  @GetMapping("/{id}")
  ResponseEntity<EquipmentDTO> getEquipment(@PathVariable UUID id) {
    var result = equipmentService.getById(id);
    return ResponseEntity.ok(EquipmentDTO.of(result));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteEquipment(@PathVariable UUID id) {
    equipmentService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
