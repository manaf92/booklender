package se.lexicon.Manaf_Gvargis_Susanne.booklender.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.LibraryUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LibraryUserRepositoryTest {

    @PersistenceContext
    EntityManager em;
    @Autowired
    LibraryUserRepository libraryUserRepository;
    @BeforeEach
    void setUp() {
        List<LibraryUser> list = new ArrayList(Arrays.asList(
                new LibraryUser(LocalDate.now(),"John","john@mail.se"),
                new LibraryUser(LocalDate.now(),"test1","test1@mail.se"),
                new LibraryUser(LocalDate.now(),"test2","test2@mail.se"),
                new LibraryUser(LocalDate.now(),"test3","test3@mail.se")
        ));
        for (LibraryUser libraryUser : list) {
            em.persist(libraryUser);
        }
    }

    @Test
    void findByEmail() {
        String ex = "test1";
        String ac = libraryUserRepository.findByEmail("test1@mail.se").getName();
        assertEquals(ex,ac);
    }
}