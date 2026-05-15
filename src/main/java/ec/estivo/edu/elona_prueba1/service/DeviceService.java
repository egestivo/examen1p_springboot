package ec.estivo.edu.elona_prueba1.service;

import ec.estivo.edu.elona_prueba1.dto.device.DeviceCreateRequest;
import ec.estivo.edu.elona_prueba1.dto.device.DeviceReportResponse;
import ec.estivo.edu.elona_prueba1.dto.device.DeviceResponse;
import ec.estivo.edu.elona_prueba1.dto.device.DeviceUpdateRequest;

import java.util.List;

public interface DeviceService {
    // listar uno
    DeviceResponse findById(Long id);

    // listar todos activos
    List<DeviceResponse> findAllActives();

    // Crear un dispositivo
    DeviceResponse create(DeviceCreateRequest request);

    // actualizar un dispositivo
    DeviceResponse update(Long id, DeviceUpdateRequest request);

    // actualizar estado (patch)
    DeviceResponse deactivate(Long id);

    // Crear reporte
    DeviceReportResponse getDeviceReport();
}
