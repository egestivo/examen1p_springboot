package ec.estivo.edu.elona_prueba1.dto.device;

import jakarta.validation.constraints.PositiveOrZero;


public class DeviceUpdateRequest {
    private String nombreComun;
    private String serial;
    @PositiveOrZero(message = "El stock debe ser mayor que 0")
    private Integer stock;
    private Boolean activo;

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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
