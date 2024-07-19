package raingor.ru.transactionservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import raingor.ru.transactionservice.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
