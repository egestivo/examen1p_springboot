package ec.estivo.edu.elona_prueba1.dto.device;

import jakarta.validation.constraints.*;

public class DeviceCreateRequest {
    @NotBlank(message = "El nombre del dispositivo es obligatorio")
    @Size(max = 120, message = "El nombre debe tener entre 2 y 120 caracteres")
    private String nombreComun;

    @NotBlank(message = "El serial es obligatorio")
    private String serial;

    @PositiveOrZero(message = "El stock no puede ser menor que 0")
    private Integer stock;

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
