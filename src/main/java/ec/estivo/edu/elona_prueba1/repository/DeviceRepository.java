package ec.estivo.edu.elona_prueba1.repository;

import ec.estivo.edu.elona_prueba1.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {
    // Cuenta todos los registros
    long count();
    // trae todos los activos
    List<Device> findAllByActivoTrue();
    Boolean existsBySerial(String serial);

    // Cuenta por estado (asumiendo que tienes un campo boolean 'returned' o un String 'status')
    long countByActivoTrue();
    long countByActivoFalse();
    long countDeviceByStockLessThan(Integer stock);
}
