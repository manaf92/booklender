package se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LibraryUserTest {

    LibraryUser libraryUser;


    @BeforeEach
    void setUp() {
        libraryUser = new LibraryUser(LocalDate.now(), "John", "john@j.com");
    }

    @Test
    void getRegDate() {
        assertEquals("2022-03-29", libraryUser.getRegDate().toString());
    }

    @Test
    void setRegDate() {
        LocalDate newDate = LocalDate.of(2022,02,22);
        libraryUser.setRegDate(newDate);
        assertEquals(newDate, libraryUser.getRegDate());
    }

    @Test
    void getName() {
        assertEquals("John", libraryUser.getName());
    }

    @Test
    void setName() {
        libraryUser.setName("Hans");
        assertEquals("Hans", libraryUser.getName());
    }

    @Test
    void getEmail() {
        assertEquals("john@j.com", libraryUser.getEmail());
    }

    @Test
    void setEmail() {
        libraryUser.setEmail("hans@h.com");
        assertEquals("hans@h.com", libraryUser.getEmail());
    }
}