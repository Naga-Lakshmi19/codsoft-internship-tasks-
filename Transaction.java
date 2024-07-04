import java.time.LocalDate;

public class Transaction {
    private int id;
    private int bookId;
    private int borrowerId;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public Transaction(int id, int bookId, int borrowerId, LocalDate issueDate, LocalDate returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.borrowerId = borrowerId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    // Getters and setters
    // toString method
}
