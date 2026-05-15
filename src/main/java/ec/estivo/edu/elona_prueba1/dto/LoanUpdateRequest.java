package ec.estivo.edu.elona_prueba1.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class LoanUpdateRequest {
    /*
    bookTitle
    borrowerName
    loanDate
    returnDate
    returned*/

    @NotBlank(message = "El nombre del libro no puede ser nulo")
    @Size(min = 3, max = 120, message = "El nombre debe tener entre 3 y 120 caracteres")
    private String bookTitle;

    @NotBlank(message = "El nombre de quien recibe es obligatorio")
    @Size(max = 120, message = "El nombre debe tener entre 2 y 120 caracteres")
    private String borrowerName;

    @NotNull(message = "La fecha de préstamo es obligatoria")
    @PastOrPresent(message = "La fecha de préstamo no puede ser futura a hoy")
    private LocalDate loanDate;

    @PastOrPresent(message = "La fecha de préstamo no puede ser futura a hoy")
    private LocalDate returnedDate;

    @NotNull(message = "El libro debe tener un estado obligatorio prestado/no prestado")
    private Boolean returned;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
