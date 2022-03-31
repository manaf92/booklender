package se.lexicon.Manaf_Gvargis_Susanne.booklender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto.LoanDTO;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.service.LoanServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LoanController {
    LoanServiceImpl service;

    @Autowired
    public LoanController(LoanServiceImpl service) {
        this.service = service;
    }

    @GetMapping("loan/findbyid/{id}")
    ResponseEntity<LoanDTO> findById(@PathVariable("id") long userId) {
        LoanDTO found = service.findById(userId);
        return ResponseEntity.ok(found);
    }

    @PostMapping("loan/create")
    public ResponseEntity<LoanDTO> create(@Validated  @RequestBody LoanDTO loanDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(loanDTO));
    }

    @PutMapping("loan/update")
    public ResponseEntity<LoanDTO> update(@Validated @RequestBody LoanDTO loanDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(loanDTO));
    }

    @GetMapping("book/findbyloandate/{loandate}")
    public ResponseEntity<List<LoanDTO>> findByLoanDate(@PathVariable("loandate") LocalDate loandate) {
        List<LoanDTO> found = service.findByLoanDate(loandate);
        return ResponseEntity.ok(found);
    }

    @GetMapping("book/findbyloanended/{loanEnded}")
    public ResponseEntity<List<LoanDTO>> findByLoanEnded(@PathVariable("loanEnded") boolean loanEnded) {
        List<LoanDTO> found = service.findByLoanEnded(loanEnded);
        return ResponseEntity.ok(found);
    }

    @GetMapping("book/findbybookid/{bookid}")
    public ResponseEntity<List<LoanDTO>> findByBookId(@PathVariable("bookid") int bookid) {
        List<LoanDTO> found = service.findByBookId(bookid);
        return ResponseEntity.ok(found);
    }

    @GetMapping("book/findbyuserid/{userid}")
    public ResponseEntity<List<LoanDTO>> findByUserId(@PathVariable("userid") int userId) {
        List<LoanDTO> found = service.findByUserId(userId);
        return ResponseEntity.ok(found);
    }

    @GetMapping("loan/findall")
    public ResponseEntity<List<LoanDTO>> findAll() {
        List<LoanDTO> allFound = service.findAll();
        if (allFound.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(allFound);
        }
    }

    @GetMapping("loan/find")
    public ResponseEntity<List<LoanDTO>> find(@RequestParam(name="name" , defaultValue = "all")  String name, @RequestParam(value = "value",defaultValue = "all") String value) {
        List<LoanDTO> found = new ArrayList<>();
        switch (name) {
            case "loandate":
                found = service.findByLoanDate(LocalDate.parse(value));
                return ResponseEntity.ok(found);

            case "bookid":
                found = service.findByBookId(Integer.parseInt(value));
                return ResponseEntity.ok(found);

            case "loanended":
                found = service.findByLoanEnded(Boolean.parseBoolean(value));
                return ResponseEntity.ok(found);

            case "userid":
                found = service.findByUserId(Integer.parseInt(value));
                return ResponseEntity.ok(found);

            default:
                List<LoanDTO> allFound = service.findAll();
                if (allFound.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                } else {
                    return ResponseEntity.status(HttpStatus.OK).body(allFound);
                }
        }
    }
}
