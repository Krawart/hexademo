package com.krawart.hexademo.core.store.presentation.rest.v1;

import com.krawart.hexademo.core.store.application.MedicineManager;
import com.krawart.hexademo.core.store.application.MedicineQueryService;
import com.krawart.hexademo.core.store.application.command.AddMedicineCommand;
import com.krawart.hexademo.core.store.application.command.UpdateMedicineCommand;
import com.krawart.hexademo.core.store.presentation.rest.v1.dto.MedicineDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/medicines")
@RequiredArgsConstructor
class MedicineController {

    private final MedicineManager medicineManager;
    private final MedicineQueryService medicineQueryService;

    @PostMapping
    ResponseEntity<MedicineDTO> addMedicine(@RequestBody @Valid AddMedicineCommand command) {
        var result = medicineManager.add(command);
        return ResponseEntity.created(URI.create("/api/v1/medicines/" + result.getId()))
                .build();
    }

    @PutMapping("/{id}")
    ResponseEntity<MedicineDTO> updateMedicine(
            @RequestBody @Valid UpdateMedicineCommand command, @PathVariable UUID id) {
        var result = medicineManager.update(command, id);
        return ResponseEntity.ok(MedicineDTO.of(result));
    }

    @GetMapping("/{id}")
    ResponseEntity<MedicineDTO> getMedicine(@PathVariable UUID id) {
        var result = medicineQueryService.getById(id);
        return ResponseEntity.ok(MedicineDTO.of(result));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMedicine(@PathVariable UUID id) {
        medicineManager.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
