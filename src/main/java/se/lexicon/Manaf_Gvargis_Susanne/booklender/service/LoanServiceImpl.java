package se.lexicon.Manaf_Gvargis_Susanne.booklender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto.LoanDTO;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.Book;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.Loan;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.repositories.LoanRepository;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.service.converter.EntityDTOConverter;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.service.interfaces.LoanService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    LoanRepository repository;
    EntityDTOConverter converter;

    @Autowired
    public LoanServiceImpl(LoanRepository repository, EntityDTOConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public LoanDTO create(LoanDTO loanDTO) {
        Loan loan = converter.DTOToLoan(loanDTO);
        return converter.loanToDTO(repository.save(loan));
    }

    @Override
    public LoanDTO findById(Long id) {
        return converter.loanToDTO(repository.findById(id).get());
    }

    @Override
    public List<LoanDTO> findAll() {
        List<Loan> loanList = repository.findAll();
        List<LoanDTO> loanDTOList = new ArrayList<>();
        loanList.forEach(loan -> loanDTOList.add(converter.loanToDTO(loan)));
        return loanDTOList;
    }

    @Override
    public LoanDTO update(LoanDTO loanDTO) {
        if (loanDTO == null) throw new  IllegalArgumentException("loanDTO was null");
        if (loanDTO.getLoanId() == 0) throw new  IllegalArgumentException("loanDTO.getLoanId() was 0");
        Optional<Loan> found = repository.findById(loanDTO.getLoanId());
        if (!found.isPresent()) throw new  IllegalArgumentException("the object was not found");
        Loan loan = found.get();
        loan.setLoanEnded(loanDTO.isLoanEnded());
        loan.setLoanDate(loanDTO.getLoanDate());
        loan.setLoanTaker(converter.DTOToLibraryUser(loanDTO.getLoanTaker()));
        loan.setBook(converter.DTOToBook(loanDTO.getBook()));
        return converter.loanToDTO(loan);
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<LoanDTO> findByBookId(int id) {
        List<Loan> loanList = repository.findByBook_BookId(id);
        List<LoanDTO> loanDTOList = new ArrayList<>();
        loanList.forEach(loan -> loanDTOList.add(converter.loanToDTO(loan)));
        return loanDTOList;
    }

    @Override
    public List<LoanDTO> findByUserId(int id) {
        List<Loan> loanList = repository.findByLoanTaker_UserId(id);
        List<LoanDTO> loanDTOList = new ArrayList<>();
        loanList.forEach(loan -> loanDTOList.add(converter.loanToDTO(loan)));
        return loanDTOList;
    }

    @Override
    public List<LoanDTO> findByLoanEnded(boolean loanEnded) {
        List<Loan> loanList = repository.findByLoanEnded(loanEnded);
        List<LoanDTO> loanDTOList = new ArrayList<>();
        loanList.forEach(loan -> loanDTOList.add(converter.loanToDTO(loan)));
        return loanDTOList;
    }
}
