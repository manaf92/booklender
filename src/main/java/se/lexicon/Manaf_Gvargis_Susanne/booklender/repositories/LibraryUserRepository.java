package se.lexicon.Manaf_Gvargis_Susanne.booklender.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.Manaf_Gvargis_Susanne.booklender.models.entities.LibraryUser;

import java.util.Optional;

@Repository
public interface LibraryUserRepository extends JpaRepository<LibraryUser, Integer> {
    Optional<LibraryUser> findByEmail(String email);
}
