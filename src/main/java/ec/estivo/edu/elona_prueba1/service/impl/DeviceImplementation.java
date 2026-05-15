package ec.estivo.edu.elona_prueba1.service.impl;

import ec.estivo.edu.elona_prueba1.domain.Device;
import ec.estivo.edu.elona_prueba1.dto.device.DeviceCreateRequest;
import ec.estivo.edu.elona_prueba1.dto.device.DeviceReportResponse;
import ec.estivo.edu.elona_prueba1.dto.device.DeviceResponse;
import ec.estivo.edu.elona_prueba1.dto.device.DeviceUpdateRequest;
import ec.estivo.edu.elona_prueba1.repository.DeviceRepository;
import ec.estivo.edu.elona_prueba1.service.DeviceService;
import ec.estivo.edu.elona_prueba1.web.advice.ConflictException;
import ec.estivo.edu.elona_prueba1.web.advice.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceImplementation implements DeviceService {
    private final DeviceRepository repo;
    public DeviceImplementation(DeviceRepository repo) {
        this.repo = repo;
    }


    @Override
    public DeviceResponse findById(Long id) {
        Device s = repo.findById(id).orElseThrow(() -> new
                NotFoundException("Dispositivo no encontrado"));
        return toResponse(s);
    }

    @Override
    public List<DeviceResponse> findAllActives() {
        return repo.findAllByActivoTrue().stream().map(this::toResponse).toList();
    }

    @Override
    public DeviceResponse create(DeviceCreateRequest request) {
        if(repo.existsBySerial(request.getSerial())){
            throw new ConflictException("Serial ya registrado");
        }

        Device d = new Device();
        d.setNombreComun(request.getNombreComun());
        d.setSerial(request.getSerial());
        d.setStock(request.getStock());
        d.setActivo(true);

        Device saved = repo.save(d);

        return toResponse(saved);
    }

    @Override
    public DeviceResponse update(Long id, DeviceUpdateRequest request) {
        Device d = repo.findById(id).orElseThrow(() -> new
                        NotFoundException("Dispositivo no encontrado"));

        // verificar si tiene algo
        if(request.getNombreComun() != null) d.setNombreComun(request.getNombreComun());
        if(request.getSerial() != null) d.setSerial(request.getSerial());
        if(request.getStock() != null) d.setStock(request.getStock());
        if(request.getActivo() != null) d.setActivo(request.getActivo());

        return toResponse(repo.save(d));
    }

    @Override
    public DeviceResponse deactivate(Long id) {
        Device s = repo.findById(id).orElseThrow(() -> new
                NotFoundException("Dispositivo no encontrado"));

        s.setActivo(false);
        return toResponse(repo.save(s));
    }

    @Override
    public DeviceReportResponse getDeviceReport() {
        // contadores independientes
        long total = repo.count();
        long available = repo.countByActivoTrue();
        long unavailable = repo.countByActivoFalse();

        // crear respuesta
        return new DeviceReportResponse(total, available, unavailable);
    }
    private DeviceResponse toResponse(Device d) {
        DeviceResponse r = new DeviceResponse();
        r.setId(d.getId());
        r.setNombreComun(d.getNombreComun());
        r.setSerial(d.getSerial());
        r.setStock(d.getStock());
        r.setActivo(d.getActivo());
        return r;
    }
}
