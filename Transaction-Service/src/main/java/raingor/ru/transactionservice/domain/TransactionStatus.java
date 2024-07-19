package raingor.ru.transactionservice.domain;

public enum TransactionStatus {
    PENDING,      // Ожидание обработки
    COMPLETED,    // Завершена успешно
    FAILED,       // Провалена
    CANCELED,     // Отменена
    IN_PROGRESS,  // В процессе выполнения
    REFUNDED,     // Возвращена
    ON_HOLD       // Приостановлена
}
