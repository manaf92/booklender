package se.lexicon.Manaf_Gvargis_Susanne.booklender.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.Book;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.LibraryUser;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.Loan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LoanRepositoryTest {
    Book book1;
    Book book2;
    LibraryUser user1;

    @PersistenceContext
    EntityManager em;
    @Autowired
    LoanRepository loanRepository;

    @BeforeEach
    void setUp() {
        book1 = new Book("java1",30,new BigDecimal(1),"java 1");
        book1.setAvailable(false);
        book1.setReserved(true);

        book2 =new Book("java2",20,new BigDecimal(2),"java 2");
        book2.setAvailable(false);
        book2.setReserved(true);

        Book book3 = new Book("java3",40,new BigDecimal(2),"java 3");
        Book book4 = new Book("java4",10,new BigDecimal(1),"java 4");
        List<Book> bookList = new ArrayList(Arrays.asList(book1, book2, book3, book4));
        for (Book book : bookList) {
            em.persist(book);
        }

        user1 = new LibraryUser(LocalDate.now(),"test1","test1@mail.se");
        LibraryUser user2 = new LibraryUser(LocalDate.now(),"test2","test2@mail.se");
        LibraryUser user3 = new LibraryUser(LocalDate.now(),"test3","test3@mail.se");
        LibraryUser user4 = new LibraryUser(LocalDate.now(),"test4","test4@mail.se");
        List<LibraryUser> userList = new ArrayList(Arrays.asList(user1,user2,user3,user4));
        for (LibraryUser libraryUser : userList) {
            em.persist(libraryUser);
        }

        Loan loan1 = new Loan(user1,book1,LocalDate.now(),true);
        Loan loan2 = new Loan(user3,book2,LocalDate.now().plusDays(40),false);
        Loan loan3 = new Loan(user2,book1,LocalDate.now().plusDays(30),false);
        Loan loan4 = new Loan(user1,book2,LocalDate.now(),false);
        List<Loan> loanList =  new ArrayList<>(Arrays.asList(loan1,loan2,loan3,loan4));
        loanList.forEach(l-> em.persist(l));
    }

    @Test
    void findByLoanTaker_UserId() {
        int expect = 2;
        int actual = loanRepository.findByLoanTaker_UserId(user1.getUserId()).size();
        assertEquals(expect,actual);
    }

    @Test
    void findByBook_BookId() {
        int expect = 2;
        List<Loan> loans = loanRepository.findByBook_BookId(book1.getBookId());
        int actual = loans.size();
        loans.forEach(System.out::println);
        assertEquals(expect,actual);
    }

    @Test
    void findByLoanEnded(){
        int expect = 3;
        List<Loan> loans = loanRepository.findByLoanEnded(false);
        int actual = loans.size();
        loans.forEach(System.out::println);
        assertEquals(expect,actual);
    }
}