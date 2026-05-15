package ec.estivo.edu.elona_prueba1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class LoanCreateRequest {
    @NotBlank(message = "El nombre del libro no puede ser nulo")
    @Size(min = 3, max = 120, message = "El nombre debe tener entre 3 y 120 caracteres")
    private String bookTitle;

    @NotBlank(message = "El nombre de quien se lleva el libro es requerido")
    @Size(max = 120, message = "El nombre debe tener entre 2 y 120 caracteres")
    private String borrowerName;

    @NotNull(message = "La fecha de préstamo es obligatoria")
    @Past(message = "La fecha de préstamo no puede ser futura a hoy")
    private LocalDate loanDate;

    @Past(message = "La fecha de devolución no puede ser futura a hoy")
    private LocalDate returnedDate;

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

}
