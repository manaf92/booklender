package se.lexicon.Manaf_Gvargis_Susanne.booklender.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.Loan;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository <Loan,Long>{
    List<Loan> findByLoanTaker_UserId(int userId);
    List<Loan> findByLoanEnded(boolean loanEnded);
    List<Loan> findByBook_BookId(int id);

    List<Loan> findByLoanDate(LocalDate loanDate);
}
