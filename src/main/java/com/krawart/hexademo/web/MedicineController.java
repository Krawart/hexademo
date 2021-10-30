package com.krawart.hexademo.web;

import com.krawart.hexademo.service.MedicineService;
import com.krawart.hexademo.service.command.AddMedicineCommand;
import com.krawart.hexademo.service.command.UpdateMedicineCommand;
import com.krawart.hexademo.service.dto.MedicineDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/medicines")
@RequiredArgsConstructor
class MedicineController {

  private final MedicineService medicineService;

  @PostMapping
  ResponseEntity<MedicineDTO> addMedicine(@RequestBody @Valid AddMedicineCommand command) {
    var result = medicineService.add(command);
    return ResponseEntity.created(URI.create("/api/v1/medicines/" + result.getId())).build();
  }

  @PutMapping("/{id}")
  ResponseEntity<MedicineDTO> updateMedicine(@RequestBody @Valid UpdateMedicineCommand command, @PathVariable UUID id) {
    var result = medicineService.update(command, id);
    return ResponseEntity.ok(MedicineDTO.of(result));
  }

  @GetMapping("/{id}")
  ResponseEntity<MedicineDTO> getMedicine(@PathVariable UUID id) {
    var result = medicineService.getById(id);
    return ResponseEntity.ok(MedicineDTO.of(result));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteMedicine(@PathVariable UUID id) {
    medicineService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
