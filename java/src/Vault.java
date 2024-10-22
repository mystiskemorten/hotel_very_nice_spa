public interface Vault {
    boolean ensureUnsealed(String justInCase);

    String getPaymentDetails(long loggedInUser);
}
