package se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book;
    @BeforeEach
    void setUp() {
        book = new Book("java",30,new BigDecimal("1.00"),"java 1");
    }

    @Test
    void getTitle() {
        assertEquals("java", book.getTitle());
    }

    @Test
    void setTitle() {
        book.setTitle("C#");
        assertEquals("C#", book.getTitle());

    }

    @Test
    void isAvailable() {
        assertTrue(book.isAvailable());
    }

    @Test
    void setAvailable() {
        book.setAvailable(false);
        assertFalse(book.isAvailable());
    }

    @Test
    void isReserved() {
        assertTrue(book.isAvailable());
    }

    @Test
    void setReserved() {
        book.setReserved(true);
        assertTrue(book.isReserved());
    }

    @Test
    void getMaxLoanDays() {
        assertEquals(30, book.getMaxLoanDays());
    }

    @Test
    void setMaxLoanDays() {

        book.setMaxLoanDays(20);
        assertEquals(20, book.getMaxLoanDays());
    }

    @Test
    void getFinePerDay() {
        assertEquals(new BigDecimal("1.00"), book.getFinePerDay());
    }

    @Test
    void setFinePerDay() {
        BigDecimal bigDecimal = new BigDecimal("2.00");
        book.setFinePerDay(bigDecimal);
        assertEquals(bigDecimal, book.getFinePerDay());
    }

    @Test
    void getDescription() {
        assertEquals("java 1", book.getDescription());
    }

    @Test
    void setDescription() {
        String description =  "C# 1";
        book.setDescription(description);
        assertEquals(description, book.getDescription());
    }
}