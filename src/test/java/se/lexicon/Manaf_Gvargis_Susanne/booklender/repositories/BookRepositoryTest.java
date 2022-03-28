package se.lexicon.Manaf_Gvargis_Susanne.booklender.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.Book;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {
    Book book1;
    Book book2;
    @PersistenceContext
    EntityManager em;
    @Autowired
    BookRepository bookRepository;
    @BeforeEach
    void setUp() {
        book1 = new Book("java1",30,new BigDecimal(1),"java 1");
        book1.setAvailable(false);
        book1.setReserved(true);

        book2 =new Book("java2",20,new BigDecimal(2),"java 2");
        book2.setAvailable(false);
        book2.setReserved(true);

        List<Book> list = new ArrayList(Arrays.asList(
                book1,
                book2,
                new Book("java3",40,new BigDecimal(2),"java 3"),
                new Book("java4",10,new BigDecimal(1),"java 4")
        ));
        for (Book book : list) {
            em.persist(book);
        }
    }

    @Test
    void findByAvailable() {
        int expect = 2;
        int actual = bookRepository.findByAvailable(true).size();
        assertEquals(expect,actual);
    }

    @Test
    void findByReserved() {
        int expect = 2;
        int actual = bookRepository.findByReserved(false).size();
        assertEquals(expect,actual);
    }

    @Test
    void findByTitle() {
        int expect = 1;
        int actual = bookRepository.findByTitle("java3").size();
        assertEquals(expect,actual);
    }
}