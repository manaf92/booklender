package se.lexicon.Manaf_Gvargis_Susanne.booklender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto.LibraryUserDTO;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.LibraryUser;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.repositories.LibraryUserRepository;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.service.converter.EntityDTOConverter;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.service.interfaces.LibraryUserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryUserServiceImpl implements LibraryUserService {

    LibraryUserRepository repository;
    EntityDTOConverter converter;
    @Autowired
    public LibraryUserServiceImpl(LibraryUserRepository repository, EntityDTOConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public LibraryUserDTO create(LibraryUserDTO libraryUserDTO) {
        LibraryUser libraryUser = converter.DTOToLibraryUser(libraryUserDTO);
        return converter.libraryUserToDTO(repository.save(libraryUser));
    }

    @Override
    public LibraryUserDTO findById(Integer id) {
        return converter.libraryUserToDTO(repository.findById(id).get());
    }

    @Override
    public List<LibraryUserDTO> findAll() {
        List<LibraryUser> userList = repository.findAll();
        List<LibraryUserDTO> userDTOList = new ArrayList<>();
        userList.forEach(user -> userDTOList.add(converter.libraryUserToDTO(user)));
        return userDTOList;
    }

    @Override
    public LibraryUserDTO update(LibraryUserDTO libraryUserDTO) {
        LibraryUser user = converter.DTOToLibraryUser(libraryUserDTO);
        return converter.libraryUserToDTO(repository.save(user));
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
    @Override
    public LibraryUserDTO findByEmail(String email) {
        return converter.libraryUserToDTO(repository.findByEmail(email));
    }
}
