package com.krawart.hexademo.core.schedule.presentation.rest.v1;

import com.krawart.hexademo.core.schedule.application.VisitManager;
import com.krawart.hexademo.core.schedule.application.VisitQueryService;
import com.krawart.hexademo.core.schedule.application.command.AddVisitCommand;
import com.krawart.hexademo.core.schedule.application.command.UpdateVisitCommand;
import com.krawart.hexademo.core.schedule.presentation.rest.v1.dto.VisitDTO;
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

  private final VisitManager visitManager;
  private final VisitQueryService visitQueryService;

  @PostMapping
  ResponseEntity<VisitDTO> addVisit(@RequestBody @Valid AddVisitCommand command) {
    var result = visitManager.add(command);
    return ResponseEntity.created(URI.create("/api/v1/visits/" + result.getId())).build();
  }

  @PutMapping("/{id}")
  ResponseEntity<VisitDTO> updateVisit(@RequestBody @Valid UpdateVisitCommand command, @PathVariable UUID id) {
    var result = visitManager.update(command, id);
    return ResponseEntity.ok(VisitDTO.of(result));
  }

  @GetMapping("/{id}")
  ResponseEntity<VisitDTO> getVisit(@PathVariable UUID id) {
    var result = visitQueryService.getById(id);
    return ResponseEntity.ok(VisitDTO.of(result));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteVisit(@PathVariable UUID id) {
    visitManager.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
