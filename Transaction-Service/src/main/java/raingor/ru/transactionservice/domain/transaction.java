package raingor.ru.transactionservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class transaction {
    private Long id;
    private Long user_id;
    private LocalDateTime date;
    private Double amount;
    private String description;
    private String type;
    private String status;

}
