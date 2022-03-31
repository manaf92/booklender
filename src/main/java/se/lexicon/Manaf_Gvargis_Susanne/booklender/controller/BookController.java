package se.lexicon.Manaf_Gvargis_Susanne.booklender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto.BookDTO;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.service.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    //Use @RequestParam to define the search parameters. (tip: Make 4 optional params
    //with “all” marked as default)
    BookServiceImpl service;

    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.service = bookService;
    }

    @GetMapping("book/findbyid/{id}")
    ResponseEntity<BookDTO>  findById(@PathVariable("id") int bookId) {
        BookDTO found = service.findById(bookId);
        return ResponseEntity.ok(found);
    }


    @PostMapping("book/create")
    public ResponseEntity<BookDTO> create(@Validated @RequestBody BookDTO bookDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(bookDTO));
    }

    @PutMapping("book/update")
    public ResponseEntity<BookDTO> update(@Validated @RequestBody BookDTO bookDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(bookDTO));
    }

    @GetMapping("book/findbytitle")
    public ResponseEntity<List<BookDTO>>  findByTitle(@RequestParam("title") String title) {
        List<BookDTO> found = service.findByTitle(title);
        return ResponseEntity.ok(found);
    }

    @GetMapping("book/findbyavailable/{available}")
    public ResponseEntity<List<BookDTO>>  findByAvailable(@PathVariable("available") boolean available) {
        List<BookDTO> found = service.findByAvailable(available);
        return ResponseEntity.ok(found);
    }

    @GetMapping("book/findbyreserved/{reserved}")
    public ResponseEntity<List<BookDTO>>  findByReserved(@PathVariable("reserved") boolean reserved) {
        List<BookDTO> found = service.findByReserved(reserved);
        return ResponseEntity.ok(found);
    }

    @GetMapping("book/findall")
    public ResponseEntity<List<BookDTO>> findAll(){
        List<BookDTO> allFound = service.findAll();
        if (allFound.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(allFound);
        }
    }

    @GetMapping("/book/find")
    public ResponseEntity<List<BookDTO>> find(@RequestParam( name = "name", defaultValue = "all") String name, @RequestParam(value = "value", defaultValue = "all") String value) {
        List<BookDTO> found= new ArrayList<>();
        switch (name){
            case "available":
                found = service.findByAvailable(Boolean.parseBoolean(value));
                return ResponseEntity.ok(found);
            case "reserved":
                found = service.findByReserved(Boolean.parseBoolean(value));
                return ResponseEntity.ok(found);
            case "title":
                found = service.findByTitle(value);
                return ResponseEntity.ok(found);
            default:
                List<BookDTO> allFound = service.findAll();
                if (allFound.isEmpty()){
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                } else {
                    return ResponseEntity.status(HttpStatus.OK).body(allFound);
                }
        }
    }
}
