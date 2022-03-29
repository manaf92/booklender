package se.lexicon.Manaf_Gvargis_Susanne.booklender.service.interfaces;

import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto.LibraryUserDTO;

public interface LibraryUserService extends CRUD<LibraryUserDTO,Integer> {

    LibraryUserDTO findByEmail(String email);
}
