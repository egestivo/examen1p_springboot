package ec.estivo.edu.elona_prueba1.service;

import ec.estivo.edu.elona_prueba1.domain.Device;
import ec.estivo.edu.elona_prueba1.dto.device.DeviceCreateRequest;
import ec.estivo.edu.elona_prueba1.repository.DeviceRepository;
import ec.estivo.edu.elona_prueba1.web.advice.ConflictException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
public class DeviceServiceTest {

    @Autowired
    private final DeviceService deviceService;

    @Autowired
    private final DeviceRepository deviceRepository;

    public DeviceServiceTest(DeviceService deviceService, DeviceRepository deviceRepository) {
        this.deviceService = deviceService;
        this.deviceRepository = deviceRepository;
    }

    @Test
    void shouldNotAllowDuplicateSerial() {
        Device existing = new Device();
        existing.setNombreComun("Test");
        existing.setSerial("ABC-123");
        existing.setStock(10);
        existing.setActivo(true);

        deviceRepository.save(existing);

        DeviceCreateRequest req = new DeviceCreateRequest();

        req.setNombreComun("TestChjocar");
        req.setSerial("ABC-123");
        req.setStock(10);

        assertThatThrownBy(() -> deviceService.create(req)).isInstanceOf(ConflictException.class);
    }

}
