package ec.estivo.edu.elona_prueba1.web.controller;

import ec.estivo.edu.elona_prueba1.dto.LoanCreateRequest;
import ec.estivo.edu.elona_prueba1.dto.LoanReportResponse;
import ec.estivo.edu.elona_prueba1.dto.LoanResponse;
import ec.estivo.edu.elona_prueba1.dto.LoanUpdateRequest;
import ec.estivo.edu.elona_prueba1.dto.device.DeviceCreateRequest;
import ec.estivo.edu.elona_prueba1.dto.device.DeviceReportResponse;
import ec.estivo.edu.elona_prueba1.dto.device.DeviceResponse;
import ec.estivo.edu.elona_prueba1.dto.device.DeviceUpdateRequest;
import ec.estivo.edu.elona_prueba1.service.DeviceService;
import ec.estivo.edu.elona_prueba1.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estivenona/devices")
public class DeviceController {
    // Inyectar el servicio
    private final DeviceService svc;

    public DeviceController(DeviceService svc) {
        this.svc = svc;
    }

    // obtener todos los libros
    @GetMapping
    public ResponseEntity<List<DeviceResponse>> findAll(){
        return ResponseEntity.ok(svc.findAllActives());
    }

    // obtener solo un libro
    @GetMapping("/{id}")
    public ResponseEntity<DeviceResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(svc.findById(id));
    }

    // Obtener reporte
    @GetMapping("/report")
    public ResponseEntity<DeviceReportResponse> reporte() {
        return ResponseEntity.ok(svc.getDeviceReport());
    }

    // Actualizar un libro existente
    @PutMapping("/{id}")
    public ResponseEntity<DeviceResponse> updateLoan(@PathVariable Long id, @Valid @RequestBody DeviceUpdateRequest request) {
        return ResponseEntity.ok(svc.update(id, request));
    }

    // Actualizar el estado de un libro
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<DeviceResponse> deactivateDevice(@PathVariable Long id) {
        return ResponseEntity.ok(svc.deactivate(id));
    }

    // Crear
    @PostMapping
    public ResponseEntity<DeviceResponse> createDevice(@Valid @RequestBody DeviceCreateRequest request) {
        return ResponseEntity.ok(svc.create(request));
    }
}
