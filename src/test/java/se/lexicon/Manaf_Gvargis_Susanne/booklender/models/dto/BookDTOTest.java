package se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BookDTOTest {
    BookDTO  bookDTO;
    @BeforeEach
    void setUp() {
        bookDTO = new BookDTO(1,"java",30,new BigDecimal("1.00"),"java 1");
    }

    @Test
    void getBookId() {
        assertEquals(1,bookDTO.getBookId());
    }

    @Test
    void getTitle() {
        assertEquals("java",bookDTO.getTitle());
    }

    @Test
    void setTitle() {
        bookDTO.setTitle("C#");
        assertEquals("C#",bookDTO.getTitle());

    }

    @Test
    void isAvailable() {
        assertTrue(bookDTO.isAvailable());
    }

    @Test
    void setAvailable() {
        bookDTO.setAvailable(false);
        assertFalse(bookDTO.isAvailable());
    }

    @Test
    void isReserved() {
        assertTrue(bookDTO.isAvailable());
    }

    @Test
    void setReserved() {
        bookDTO.setReserved(true);
        assertTrue(bookDTO.isReserved());
    }

    @Test
    void getMaxLoanDays() {
        assertEquals(30,bookDTO.getMaxLoanDays());
    }

    @Test
    void setMaxLoanDays() {

        bookDTO.setMaxLoanDays(20);
        assertEquals(20,bookDTO.getMaxLoanDays());
    }

    @Test
    void getFinePerDay() {
        assertEquals(new BigDecimal("1.00"),bookDTO.getFinePerDay());
    }

    @Test
    void setFinePerDay() {
        BigDecimal bigDecimal = new BigDecimal("2.00");
        bookDTO.setFinePerDay(bigDecimal);
        assertEquals(bigDecimal,bookDTO.getFinePerDay());
    }

    @Test
    void getDescription() {
        assertEquals("java 1",bookDTO.getDescription());
    }

    @Test
    void setDescription() {
        String description =  "C# 1";
        bookDTO.setDescription(description);
        assertEquals(description,bookDTO.getDescription());
    }
}