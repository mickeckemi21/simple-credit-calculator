package io.mickeckemi21.simplecreditcalculator.repository;

import io.mickeckemi21.simplecreditcalculator.model.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {
}
