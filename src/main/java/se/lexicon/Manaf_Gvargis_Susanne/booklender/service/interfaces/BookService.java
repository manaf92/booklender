package se.lexicon.Manaf_Gvargis_Susanne.booklender.service.interfaces;

import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto.BookDTO;

import java.util.List;

public interface BookService extends CRUD<BookDTO,Integer> {

    List<BookDTO> findByReserved(boolean reserved);
    List<BookDTO> findByAvailable(boolean available);
    List<BookDTO> findByTitle(String title);



}
