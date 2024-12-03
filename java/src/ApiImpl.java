import model.Invoice;
import model.Reservation;
import model.UserObject;

import java.util.Collections;
import java.util.List;

public abstract class ApiImpl implements AuthenticatedApi{

    @Inject
    private DatabaseInterface database;
    @Inject
    private BankingEndpoint bankingEndpoint;
    @Inject
    private Vault vault;

    public List<Reservation> getMyReservations(int userId){
        //TODO
		return Collections.emptyList();
    }

    public List<Invoice> getUserInvoices(String userId){
		//TODO        
		return Collections.emptyList();
    }

    public void setMyAlternatePhoneNumbers(String commaDelimitedNumbers){
        //TODO
    }

    public void updateMyEmail(UserObject userData){
        //TODO;
    }


    public boolean payInvoice(int invoiceId){
        //TODO
        return false;
    }

}
