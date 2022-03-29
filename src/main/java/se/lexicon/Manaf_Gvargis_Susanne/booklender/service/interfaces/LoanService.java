package se.lexicon.Manaf_Gvargis_Susanne.booklender.service.interfaces;

import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto.LoanDTO;

import java.util.List;

public interface LoanService extends CRUD<LoanDTO,Long> {
    List<LoanDTO> findByBookId(int id);
    List<LoanDTO> findByUserId(int id);
    List<LoanDTO> findByLoanEnded(boolean loanEnded);
}
