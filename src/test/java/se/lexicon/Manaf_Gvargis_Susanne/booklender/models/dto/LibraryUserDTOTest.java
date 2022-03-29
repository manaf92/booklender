package se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LibraryUserDTOTest {

    LibraryUserDTO libraryUserDTO1;


    @BeforeEach
    void setUp() {
        libraryUserDTO1 = new LibraryUserDTO(12, LocalDate.now(), "John", "john@j.com");
    }

    @Test
    void getUserId() {
        assertEquals(12, libraryUserDTO1.getUserId());
    }

    @Test
    void getRegDate() {
        assertEquals("2022-03-29", libraryUserDTO1.getRegDate().toString());
    }

    @Test
    void setRegDate() {
        LocalDate newDate = LocalDate.of(2022,02,22);
        libraryUserDTO1.setRegDate(newDate);
        assertEquals(newDate, libraryUserDTO1.getRegDate());
    }

    @Test
    void getName() {
        assertEquals("John", libraryUserDTO1.getName());
    }

    @Test
    void setName() {
        libraryUserDTO1.setName("Hans");
        assertEquals("Hans", libraryUserDTO1.getName());
    }

    @Test
    void getEmail() {
        assertEquals("john@j.com", libraryUserDTO1.getEmail());
    }

    @Test
    void setEmail() {
        libraryUserDTO1.setEmail("hans@h.com");
        assertEquals("hans@h.com", libraryUserDTO1.getEmail());
    }
}