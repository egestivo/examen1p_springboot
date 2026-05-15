package ec.estivo.edu.elona_prueba1.dto.device;


public class DeviceReportResponse {
    private Long total;
    private Long available;
    private Long unavailable;

    public DeviceReportResponse(Long total, Long available, Long unavailable) {
        this.total = total;
        this.available = available;
        this.unavailable = unavailable;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    public Long getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(Long unavailable) {
        this.unavailable = unavailable;
    }
}
