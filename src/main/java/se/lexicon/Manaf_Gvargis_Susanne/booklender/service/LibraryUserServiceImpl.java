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
import java.util.Optional;

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
        if(libraryUserDTO == null) throw new IllegalArgumentException("libraryUserDTO was null");
        if (repository.findByEmail(libraryUserDTO.getEmail()).isPresent()) throw new IllegalArgumentException("Email already exist");
        if(libraryUserDTO == null) throw new IllegalArgumentException("libraryUserDTO was null");
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
        if (libraryUserDTO.getUserId()!=repository.findByEmail(libraryUserDTO.getEmail()).get().getUserId()) throw new IllegalArgumentException("email already used");
        if(libraryUserDTO == null) throw new IllegalArgumentException("libraryUserDTO is null.");
        if (libraryUserDTO.getUserId() == 0) throw new IllegalArgumentException("Library user id was 0");
        Optional<LibraryUser> found = repository.findById(libraryUserDTO.getUserId());
        if (!found.isPresent()) throw new IllegalArgumentException("Object not found.");
        LibraryUser libraryUser = found.get();
        libraryUser.setEmail(libraryUserDTO.getEmail());
        libraryUser.setName(libraryUserDTO.getName());
        libraryUser.setRegDate(libraryUserDTO.getRegDate());

        return converter.libraryUserToDTO(libraryUser);
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
        return converter.libraryUserToDTO(repository.findByEmail(email).get());
    }
}
