package se.lexicon.Manaf_Gvargis_Susanne.booklender.service.converter;

import org.springframework.stereotype.Component;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto.BookDTO;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto.LibraryUserDTO;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto.LoanDTO;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.Book;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.LibraryUser;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.Loan;

import javax.transaction.Transactional;

@Component
@Transactional
public class EntityDTOConverter {
    public Book DTOToBook(BookDTO dto){
        return new Book(dto.getTitle(), dto.getMaxLoanDays(), dto.getFinePerDay(), dto.getDescription());
    }

    public BookDTO bookToDTO(Book book){
        return new BookDTO(book.getBookId(), book.getTitle(), book.getMaxLoanDays(), book.getFinePerDay(), book.getDescription());
    }

    public LoanDTO loanToDTO(Loan loan){
        return new LoanDTO(loan.getLoanId(), libraryUserToDTO(loan.getLoanTaker()), bookToDTO(loan.getBook()),loan.getLoanDate(),loan.isLoanEnded());
    }

    public Loan DTOToLoan(LoanDTO dto){
        return new Loan(DTOToLibraryUser(dto.getLoanTaker()), DTOToBook(dto.getBook()), dto.getLoanDate(), dto.isLoanEnded());
    }

    public LibraryUser DTOToLibraryUser(LibraryUserDTO dto){
        return new LibraryUser(dto.getRegDate(), dto.getName(), dto.getEmail());
    }

    public LibraryUserDTO libraryUserToDTO(LibraryUser book){
        return new LibraryUserDTO(book.getUserId(), book.getRegDate(), book.getName(), book.getEmail());
    }

}
