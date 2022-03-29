package se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.Book;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.LibraryUser;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LoanDTOTest {

    LoanDTO loanDTO;
    LibraryUserDTO libraryUserDTO = new LibraryUserDTO(67, LocalDate.now(), "Lisa", "lisa@se.com");
    BookDTO bookDTO = new BookDTO(1,"java",30,new BigDecimal("1.00"),"java 1");

    @BeforeEach
    void setUp() {
        loanDTO = new LoanDTO(234l, libraryUserDTO, bookDTO, LocalDate.now(), false);
    }

    @Test
    void getLoanId() {
            assertEquals(234, loanDTO.getLoanId());
    }

    @Test
    void getLoanTaker() {
        assertEquals("Lisa", loanDTO.getLoanTaker().getName());
    }

    @Test
    void setLoanTaker() {
        LibraryUserDTO user1 =new LibraryUserDTO(10, LocalDate.now().plusDays(19), "user1", "user1@se.com");
        loanDTO.setLoanTaker(user1);
        assertEquals(user1,loanDTO.getLoanTaker());
    }

    @Test
    void getBook() {
        assertEquals(bookDTO, loanDTO.getBook());
    }

    @Test
    void setBook() {
        BookDTO book2 = new BookDTO(3,"java3",30,new BigDecimal("1.00"),"java 1");
        loanDTO.setBook(book2);
        assertEquals(book2, loanDTO.getBook());
    }

    @Test
    void getLoanDate() {
        assertEquals("2022-03-29", loanDTO.getLoanDate().toString());
    }

    @Test
    void setLoanDate() {
        LocalDate newDate = LocalDate.of(2022,02,22);
        loanDTO.setLoanDate(newDate);
        assertEquals(newDate, loanDTO.getLoanDate());
    }

    @Test
    void isLoanEnded() {
        assertFalse(loanDTO.isLoanEnded());
    }

    @Test
    void setLoanEnded() {
        loanDTO.setLoanEnded(true);
        assertTrue(loanDTO.isLoanEnded());
    }
}