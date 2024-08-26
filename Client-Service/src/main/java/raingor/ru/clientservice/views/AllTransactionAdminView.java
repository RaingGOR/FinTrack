package raingor.ru.clientservice.views;

import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import raingor.ru.clientservice.client.dtos.TransactionDTO;
import raingor.ru.clientservice.layouts.MainLayout;
import raingor.ru.clientservice.client.services.TransactionService;

import java.util.List;

@Route(value = "transactions", layout = MainLayout.class)
@PageTitle("Transaction List")
public class AllTransactionAdminView extends VerticalLayout {

    private final TransactionService transactionService;

    @Autowired
    public AllTransactionAdminView(TransactionService transactionService) {
        this.transactionService = transactionService;
        initialize();
    }

    private void initialize() {
        Grid<TransactionDTO> grid = new Grid<>(TransactionDTO.class);

        List<TransactionDTO> transactions = transactionService.getAllTransactions();
        grid.setItems(transactions);

        // Настройка колонок
        grid.setColumns("id", "sender_id", "recipient_id", "date", "amount", "description", "type", "status");

        grid.getColumnByKey("amount").setHeader("Amount ($)");
        grid.getColumnByKey("date").setHeader("Date");
        grid.getColumnByKey("description").setHeader("Description");


        grid.getColumnByKey("amount").setTextAlign(ColumnTextAlign.END);
        grid.getColumnByKey("date").setTextAlign(ColumnTextAlign.CENTER);

        add(grid);
    }
}