package ec.estivo.edu.elona_prueba1.dto;

public class LoanReportResponse {

    private Long total;
    private Long returned;
    private Long notReturned;

    public LoanReportResponse(Long total, Long returned, Long notReturned) {
        this.total = total;
        this.returned = returned;
        this.notReturned = notReturned;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getReturned() {
        return returned;
    }

    public void setReturned(Long returned) {
        this.returned = returned;
    }

    public Long getNotReturned() {
        return notReturned;
    }

    public void setNotReturned(Long notReturned) {
        this.notReturned = notReturned;
    }
}
