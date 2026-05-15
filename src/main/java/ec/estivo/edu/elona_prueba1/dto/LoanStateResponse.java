package ec.estivo.edu.elona_prueba1.dto;

import java.time.LocalDate;

public class LoanStateResponse {
    private Boolean returned;
    private LocalDate returnDate;

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
