package se.lexicon.Manaf_Gvargis_Susanne.booklender.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.Book;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.LibraryUser;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.Loan;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {
    private Loan loan;
    @BeforeEach
    void setUp() {
            loan = new Loan(
                new LibraryUser(LocalDate.now(),"John","john@mail.se"),
                new Book("java",30,new BigDecimal(1),"java i"),
                LocalDate.now(),
                false
        );
    }

    @Test
    void getLoanTaker() {
        // assertArrayEquals("John",  loan.getLoanTaker());
    }

    @Test
    void setLoanTaker() {
    }

    @Test
    void getBook() {
    }

    @Test
    void setBook() {
    }

    @Test
    void getLoanDate() {
    }

    @Test
    void setLoanDate() {
    }

    @Test
    void isLoanEnded() {
        assertFalse(loan.isLoanEnded());
    }
    @Test
    void isOverdue() {
        assertFalse(loan.isOverdue());
    }

    @Test
    void setLoanEnded() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
        System.out.println(loan);
    }
}