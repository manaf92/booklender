package se.lexicon.Manaf_Gvargis_Susanne.booklender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.EnumUtils;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto.BookDTO;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.Book;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.repositories.BookRepository;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.service.converter.EntityDTOConverter;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.service.interfaces.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {
    BookRepository repository;
    EntityDTOConverter converter;

    @Autowired
    public BookServiceImpl(BookRepository repository, EntityDTOConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<BookDTO> findByReserved(boolean reserved) {
        List<Book>  bookList= repository.findByReserved(reserved);
        List<BookDTO> bookDTOList= new ArrayList<>();
        //bookDTOList = bookList.stream().map(EntityDTOConverter::bookToDTO).collect(Collectors.toList());
        bookList.forEach(book -> bookDTOList.add(converter.bookToDTO(book)));
        return bookDTOList;
    }

    @Override
    public List<BookDTO> findByAvailable(boolean available) {
        List<Book>  bookList= repository.findByAvailable(available);
        List<BookDTO> bookDTOList= new ArrayList<>();
        bookList.forEach(book -> bookDTOList.add(converter.bookToDTO(book)));
        return bookDTOList;
    }

    @Override
    public List<BookDTO> findByTitle(String title) {
        List<Book> bookList = repository.findByTitle(title);
        List<BookDTO> bookDTOList = new ArrayList<>();
        bookList.forEach(book -> bookDTOList.add(converter.bookToDTO(book)));
        return bookDTOList;
    }

    @Override
    public BookDTO create(BookDTO bookDTO) {
        Book book = converter.DTOToBook(bookDTO);
        return converter.bookToDTO(repository.save(book));
    }

    @Override
    public BookDTO findById(Integer id) {
        return converter.bookToDTO(repository.findById(id).get());
    }

    @Override
    public List<BookDTO> findAll() {
        List<Book> bookList = repository.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();
        bookList.forEach(book -> bookDTOList.add(converter.bookToDTO(book)));
        return bookDTOList;
    }

    @Override
    public BookDTO update(BookDTO bookDTO) {
        if (bookDTO == null) throw new  IllegalArgumentException("bookDTO was null");
        if (bookDTO.getBookId() == 0) throw new  IllegalArgumentException("bookDTO.getBookId() was 0");
        Optional<Book> found = repository.findById(bookDTO.getBookId());
        if (!found.isPresent()) throw new  IllegalArgumentException("the object was not found");
         Book book = found.get();
         book.setReserved(bookDTO.isReserved());
         book.setAvailable(bookDTO.isAvailable());
         book.setDescription(bookDTO.getDescription());
         book.setTitle(bookDTO.getTitle());
         book.setFinePerDay(bookDTO.getFinePerDay());
        return converter.bookToDTO(book);
    }

    @Override
    public boolean delete(Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
