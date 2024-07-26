package raingor.ru.transactionservice.specifications;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import raingor.ru.transactionservice.domain.Transaction;
import raingor.ru.transactionservice.domain.TransactionStatus;
import raingor.ru.transactionservice.domain.TransactionType;


import java.time.LocalDateTime;

public class TransactionSpecification {

    public static Specification<Transaction> hasSenderId(Long senderId) {
        return (Root<Transaction> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("sender_id"), senderId);
        };
    }

    public static Specification<Transaction> hasRecipientId(Long recipientId) {
        return (Root<Transaction> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("recipient_id"), recipientId);
        };
    }

    public static Specification<Transaction> hasDate(LocalDateTime date) {
        return (Root<Transaction> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("date"), date);
        };
    }

    public static Specification<Transaction> hasAmount(Double amount) {
        return (Root<Transaction> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("amount"), amount);
        };
    }

    public static Specification<Transaction> hasDescription(String description) {
        return (Root<Transaction> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("description"), "%" + description + "%");
        };
    }

    public static Specification<Transaction> hasType(String type) {
        return (Root<Transaction> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            try {
                TransactionType transactionType = TransactionType.valueOf(type.toUpperCase());
                return criteriaBuilder.equal(root.get("type"), transactionType);
            }catch (IllegalArgumentException e){
                return criteriaBuilder.disjunction();
            }
        };
    }

    public static Specification<Transaction> hasStatus(String status) {
        return (Root<Transaction> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            try {
                TransactionStatus transactionStatus = TransactionStatus.valueOf(status);
                return criteriaBuilder.equal(root.get("status"), transactionStatus);
            } catch (IllegalArgumentException e) {
                return criteriaBuilder.disjunction();
            }
        };
    }

}

