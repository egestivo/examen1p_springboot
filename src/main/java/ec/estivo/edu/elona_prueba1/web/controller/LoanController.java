package ec.estivo.edu.elona_prueba1.web.controller;

import ec.estivo.edu.elona_prueba1.dto.LoanCreateRequest;
import ec.estivo.edu.elona_prueba1.dto.LoanReportResponse;
import ec.estivo.edu.elona_prueba1.dto.LoanResponse;
import ec.estivo.edu.elona_prueba1.dto.LoanUpdateRequest;
import ec.estivo.edu.elona_prueba1.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estivenona/loans")
public class LoanController {
    // Inyectar el servicio
    private final LoanService svc;

    public LoanController(LoanService svc) {
        this.svc = svc;
    }

    // obtener todos los libros
    @GetMapping
    public ResponseEntity<List<LoanResponse>> findAll(){
        return ResponseEntity.ok(svc.findAll());
    }

    // obtener solo un libro
    @GetMapping("/{id}")
    public ResponseEntity<LoanResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(svc.findById(id));
    }

    // Obtener reporte
    @GetMapping("/report")
    public ResponseEntity<LoanReportResponse> reporteLoans() {
        return ResponseEntity.ok(svc.getLoanReport());
    }

    // Actualizar un libro existente
    @PutMapping("/{id}")
    public ResponseEntity<LoanResponse> updateLoan(@PathVariable Long id, @Valid @RequestBody LoanUpdateRequest request) {
        return ResponseEntity.ok(svc.update(id, request));
    }

    // Actualizar el estado de un libro
    @PatchMapping("/{id}/return")
    public ResponseEntity<LoanResponse> returnLoan(@PathVariable Long id) {
        return ResponseEntity.ok(svc.devuelto(id));
    }

    // Crear
    @PostMapping
    public ResponseEntity<LoanResponse> createLoan(@Valid @RequestBody LoanCreateRequest request) {
        return ResponseEntity.ok(svc.create(request));
    }

}
