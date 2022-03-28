package se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Loan {

    @Id
    @Column(name = "loan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private LibraryUser loanTaker;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;
    private LocalDate loanDate;
    private boolean loanEnded;

    public Loan(LibraryUser loanTaker, Book book, LocalDate loanDate, boolean loanEnded) {
        this.loanTaker = loanTaker;
        this.book = book;
        this.loanDate = loanDate;
        this.loanEnded = loanEnded;
    }
    public Loan (){}


    public boolean isOverdue() {
       return LocalDate.now().isAfter(loanDate.plusDays(book.getMaxLoanDays()));
    }

    public Long getLoanId() {
        return loanId;
    }
    public LibraryUser getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUser loanTaker) {
        this.loanTaker = loanTaker;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
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

    public void extendLoan(int days){
        this.loanDate = this.loanDate.plusDays(days);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return loanEnded == loan.loanEnded && loanId.equals(loan.loanId) && loanTaker.equals(loan.loanTaker) && book.equals(loan.book) && loanDate.equals(loan.loanDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, loanTaker, book, loanDate, loanEnded);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanTaker=" + loanTaker +
                ", book=" + book +
                ", loanDate=" + loanDate +
                ", loanEnded=" + loanEnded +
                '}';
    }
}
