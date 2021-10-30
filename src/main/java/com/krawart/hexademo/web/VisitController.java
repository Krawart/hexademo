package com.krawart.hexademo.web;

import com.krawart.hexademo.service.VisitService;
import com.krawart.hexademo.service.command.AddVisitCommand;
import com.krawart.hexademo.service.command.UpdateVisitCommand;
import com.krawart.hexademo.service.dto.VisitDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/visits")
@RequiredArgsConstructor
class VisitController {

  private final VisitService visitService;

  @PostMapping
  ResponseEntity<VisitDTO> addVisit(@RequestBody @Valid AddVisitCommand command) {
    var result = visitService.add(command);
    return ResponseEntity.created(URI.create("/api/v1/visits/" + result.getId())).build();
  }

  @PutMapping("/{id}")
  ResponseEntity<VisitDTO> updateVisit(@RequestBody @Valid UpdateVisitCommand command, @PathVariable UUID id) {
    var result = visitService.update(command, id);
    return ResponseEntity.ok(VisitDTO.of(result));
  }

  @GetMapping("/{id}")
  ResponseEntity<VisitDTO> getVisit(@PathVariable UUID id) {
    var result = visitService.getById(id);
    return ResponseEntity.ok(VisitDTO.of(result));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteVisit(@PathVariable UUID id) {
    visitService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
