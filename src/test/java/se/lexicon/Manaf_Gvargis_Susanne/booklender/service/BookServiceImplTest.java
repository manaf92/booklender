package se.lexicon.Manaf_Gvargis_Susanne.booklender.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto.BookDTO;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.Book;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@DirtiesContext
class BookServiceImplTest {
    @Autowired
    BookServiceImpl bookService;
    @Autowired
    TestEntityManager em;
    BookDTO bookDTO;
    Book book;
    int bookId;
    @BeforeEach
    void setUp() {
        bookDTO = new BookDTO(1,"java",30,new BigDecimal("1.00"),"java 1");
        book = new Book("java",30,new BigDecimal("1.00"),"java 1");
        em.persist(book);
        bookId = book.getBookId();

    }

    @Test
    void findByReserved() {
    }

    @Test
    void findByAvailable() {
    }

    @Test
    void findByTitle() {
    }

    @Test
    void create() {
        bookService.create(bookDTO);
        int count = bookService.findAll().size();
        bookService.findAll().forEach(System.out::println);
        assertEquals(2,count);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
        bookDTO.setTitle("C#");
        bookDTO.setBookId(bookId);
        BookDTO updated = bookService.update(bookDTO);
        System.out.println(updated);
        assertEquals("C#",updated.getTitle());
    }

    @Test
    void delete() {

    }
}