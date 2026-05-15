package ec.estivo.edu.elona_prueba1.repository;

import ec.estivo.edu.elona_prueba1.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    // Cuenta todos los registros
    long count();

    // Cuenta por estado (asumiendo que tienes un campo boolean 'returned' o un String 'status')
    long countByReturnedTrue();
    long countByReturnedFalse();
}
