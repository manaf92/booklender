package se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Validated
public class LoanDTO {

    private Long loanId;

    @NotNull(message = "loanTaker should not be null")
    private LibraryUserDTO loanTaker;

    @NotNull(message = "Book must be specified.")
    private BookDTO book;

    @FutureOrPresent(message = "loanDate must be in present")
    private LocalDate loanDate;
    @NotNull(message = "loanEnded is required")
    private boolean loanEnded;

    public LoanDTO(Long loanId, LibraryUserDTO loanTaker, BookDTO book, LocalDate loanDate, boolean loanEnded) {
        this.loanId = loanId;
        this.loanTaker = loanTaker;
        this.book = book;
        this.loanDate = loanDate;
        this.loanEnded = loanEnded;
    }

    public Long getLoanId() {
        return loanId;
    }

    public LibraryUserDTO getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUserDTO loanTaker) {
        this.loanTaker = loanTaker;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public boolean isLoanEnded() {
        return loanEnded;
    }

    public void setLoanEnded(boolean loanEnded) {
        this.loanEnded = loanEnded;
    }
}
