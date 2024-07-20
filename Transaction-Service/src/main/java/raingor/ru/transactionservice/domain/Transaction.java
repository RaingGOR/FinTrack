package raingor.ru.transactionservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sender_id")
    private Long sender_id;

    @Column(name = "recipient_id")
    private Long recipient_id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private TransactionType type;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus status;

    public Transaction(Long sender_id, Long recipient_id, LocalDateTime date, Double amount, String description,
                       TransactionType type, TransactionStatus status) {
        this.sender_id = sender_id;
        this.recipient_id = recipient_id;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.status = status;
    }
}
