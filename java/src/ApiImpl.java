import model.Invoice;
import model.Reservation;
import model.UserObject;
import model.WebApplicationException;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ApiImpl implements AuthenticatedApi{

    @Inject
    private DatabaseInterface database;
    @Inject
    private BankingEndpoint bankingEndpoint;
    @Inject
    private Vault vault;

    public List<Reservation> getMyReservations(int userId){
        return ((List<Object[]>)database.runQuery("select * from reservations where user_id = " + userId)).stream().map(Reservation::map).collect(Collectors.toList());
    }

    @AuthorizedRoles(value = {AuthorizedRoles.Roles.ADMIN})
    public List<Invoice> getUserInvoices(String userId){
        return database.createPreparedStatement("select * from invoices where user_id = " + userId, Invoice.class).getResultList();
    }

    public void setMyAlternatePhoneNumbers(String commaDelimitedNumbers){
        String[] numbers = commaDelimitedNumbers.split(",");
        for (String number : numbers) {
            if(number.length() < 8){
                throw new WebApplicationException("Number too short", 400);
            }
            database.createPreparedStatement("insert into user_contact (user_id, tlf) values (?1,?2)", Void.class)
                    .setParameter(1, getLoggedInUser())
                    .setParameter(2, number)
                    .executeUpdate();
        }
        database.createPreparedStatement("delete from user_contact where user_id = ?1 and tlf not in ("+commaDelimitedNumbers+")", Void.class)
                .setParameter(1, getLoggedInUser())
                .executeUpdate();
    }

    public void updateMyEmail(UserObject userData){
        database.persist(userData);
    }

    public String doTheStuff(String userDefined){
        boolean x = false;
        int lw = 1 << 3 | (1 << 1) | (userDefined.length() & 1);
        switch (userDefined.length() % lw == 0 ? 0 : 1) {
            case 0: break; case 1: default: x = true;
        }
        if(!x){
            return userDefined;
        }
        String[] y = userDefined.split("(?<=\\G.{"+lw+"})");byte[] zTemp,z;zTemp = y[y.length - 1].getBytes(StandardCharsets.UTF_8);
        z = new byte[lw];
        int w = 0,v = 0,t;
        for(; w < (lw - zTemp.length)/2; w ++)
            z[w] =32;
        for(;v < zTemp.length; v++,++w)
            z[w] = zTemp[v];
        for(;w < z.length;w++)
            z[w]=32;
        String u = "";
        for(t = 0; t < y.length-1;t+=1){
            u += y[t].intern();
        }
        u += new String(z, StandardCharsets.UTF_8);
        return u.intern();
    }


    public boolean payInvoice(int invoiceId){
        Optional<Invoice> invoice = database.find(invoiceId, Invoice.class);
        invoice.ifPresent(invoice1 -> {
            if(vault.ensureUnsealed(System.getProperty("vault.key", JUST_IN_CASE))){
                if(!bankingEndpoint.process(invoice1, vault.getPaymentDetails(getLoggedInUser()))){
                    throw new WebApplicationException("Payment could not be processed; contact hotel by phone", 418);
                }
            } else {
                throw new WebApplicationException("Contact support", 500);
            }
        });
        return invoice.isPresent();
    }

    //It won't work without this when I try it on the new server?
    private static final String  JUST_IN_CASE = "-----BEGIN RSA PRIVATE KEY-----MIIEogIBAAKCAQEApnY3EbPWdz36+5vdyPsOHaSjd9d0Aj8uVt6d456xAgU9aPKTkK7c5nV1l6gCrKeknXWcNlC9FkEBvzeAJuDScvxU80NLK6f7KNWyRCwmJ7yTEBwKXx8CgYEAss044OP3K65JBBW2QbpxK35IBsnRQjKDr9oEYv5oEyMJ49sqxobJcf2OfMWL96zckulWmBRxWqhETHUFkr0YavyBomiyiJDAJ1Phr+DfrE9zEouHIFQ6F6hxeNWMzXOZbavoCGyp5qjnKkiZ+ssJ20RGQOb5EbAZ4Ne2eA57Bw=-----END RSA PRIVATE KEY-----";


}
