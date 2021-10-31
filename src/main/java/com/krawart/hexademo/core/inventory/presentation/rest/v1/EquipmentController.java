package com.krawart.hexademo.core.inventory.presentation.rest.v1;

import com.krawart.hexademo.core.inventory.application.EquipmentManager;
import com.krawart.hexademo.core.inventory.application.EquipmentQueryService;
import com.krawart.hexademo.core.inventory.application.command.AddEquipmentCommand;
import com.krawart.hexademo.core.inventory.application.command.UpdateEquipmentCommand;
import com.krawart.hexademo.core.inventory.application.dto.EquipmentDTO;
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

  private final EquipmentManager equipmentManager;
  private final EquipmentQueryService equipmentQueryService;

  @PostMapping
  ResponseEntity<EquipmentDTO> addEquipment(@RequestBody @Valid AddEquipmentCommand command) {
    var result = equipmentManager.add(command);
    return ResponseEntity.created(URI.create("/api/v1/equipments/" + result.getId())).build();
  }

  @PutMapping("/{id}")
  ResponseEntity<EquipmentDTO> updateEquipment(@RequestBody @Valid UpdateEquipmentCommand command, @PathVariable UUID id) {
    var result = equipmentManager.update(command, id);
    return ResponseEntity.ok(EquipmentDTO.of(result));
  }

  @GetMapping("/{id}")
  ResponseEntity<EquipmentDTO> getEquipment(@PathVariable UUID id) {
    var result = equipmentQueryService.getById(id);
    return ResponseEntity.ok(EquipmentDTO.of(result));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteEquipment(@PathVariable UUID id) {
    equipmentManager.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
