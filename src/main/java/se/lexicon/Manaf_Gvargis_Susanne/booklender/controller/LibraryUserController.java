package se.lexicon.Manaf_Gvargis_Susanne.booklender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto.LibraryUserDTO;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.service.LibraryUserServiceImpl;

import java.util.List;

@RestController
public class LibraryUserController {
    LibraryUserServiceImpl service;

    @Autowired
    public LibraryUserController(LibraryUserServiceImpl service) {
        this.service = service;
    }

    @GetMapping("libraryuser/findbyid/{id}")
    ResponseEntity<LibraryUserDTO> findById(@PathVariable("id") int userId) {
        LibraryUserDTO found = service.findById(userId);
        return ResponseEntity.ok(found);
    }

    @GetMapping("libraryuser/findbyemail/{email}")
    public ResponseEntity<LibraryUserDTO> findByEmail(@PathVariable("email") String email){
        LibraryUserDTO libraryUserDTO = service.findByEmail(email);
        return  ResponseEntity.ok(libraryUserDTO);
    }

    @GetMapping("libraryuser/findall")
    public ResponseEntity<List<LibraryUserDTO>> findAll(){
        List<LibraryUserDTO> allFound = service.findAll();
        if (allFound.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(allFound);
        }
    }

    @PostMapping("libraryuser/create")
    public ResponseEntity<LibraryUserDTO> create(@Validated @RequestBody LibraryUserDTO libraryUserDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(libraryUserDTO));
    }

    @PutMapping("libraryuser/update")
    public ResponseEntity<LibraryUserDTO> update(@Validated @RequestBody LibraryUserDTO libraryUserDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(libraryUserDTO));
    }

}
