import model.Invoice;

public interface BankingEndpoint {
    boolean process(Invoice invoice1, String paymentDetails);
}
