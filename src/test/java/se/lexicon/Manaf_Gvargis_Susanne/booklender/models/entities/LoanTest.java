package se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {

    Loan loan;
    LibraryUser libraryUser = new LibraryUser( LocalDate.now(), "Lisa", "lisa@se.com");
    Book book = new Book("java",30,new BigDecimal("1.00"),"java 1");

    @BeforeEach
    void setUp() {
        loan = new Loan(libraryUser, book, LocalDate.now(), false);
    }

    @Test
    void getLoanTaker() {
        assertEquals("Lisa", loan.getLoanTaker().getName());
    }

    @Test
    void setLoanTaker() {
        LibraryUser user1 =new LibraryUser( LocalDate.now().plusDays(19), "user1", "user1@se.com");
        loan.setLoanTaker(user1);
        assertEquals(user1, loan.getLoanTaker());
    }

    @Test
    void getBook() {
        assertEquals(book, loan.getBook());
    }

    @Test
    void setBook() {
        Book book2 = new Book("java3",30,new BigDecimal("1.00"),"java 1");
        loan.setBook(book2);
        assertEquals(book2, loan.getBook());
    }

    @Test
    void getLoanDate() {
        assertEquals("2022-03-29", loan.getLoanDate().toString());
    }

    @Test
    void setLoanDate() {
        LocalDate newDate = LocalDate.of(2022,02,22);
        loan.setLoanDate(newDate);
        assertEquals(newDate, loan.getLoanDate());
    }

    @Test
    void isLoanEnded() {
        assertFalse(loan.isLoanEnded());
    }

    @Test
    void setLoanEnded() {
        loan.setLoanEnded(true);
        assertTrue(loan.isLoanEnded());
    }

}