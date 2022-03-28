package se.lexicon.Manaf_Gvargis_Susanne.booklender.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.Loan;
@Repository
public interface LoanRepository extends JpaRepository <Loan,Long>{
}
