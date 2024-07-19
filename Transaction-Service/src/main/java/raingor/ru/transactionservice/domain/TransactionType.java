package raingor.ru.transactionservice.domain;

public enum TransactionType {
    DEPOSIT,         // Вклад
    WITHDRAWAL,      // Снятие средств
    TRANSFER,        // Перевод средств между счетами
    PAYMENT,         // Оплата товаров или услуг
    REFUND,          // Возврат средств
    FEE,             // Комиссия
    INTEREST,        // Процентный доход
    CHARGE_BACK      // Оспоренная транзакция
}
