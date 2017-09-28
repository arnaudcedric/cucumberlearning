package paypalRestAPI.paymentPojo;

import java.util.List;

public class PostObjectPaypal {


    private String intent;
    private Payer payer;
    private List<Transactions> transactions;
    private String note_to_payer;
    private Redirect_urls redirect_urls;

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public String getNote_to_payer() {
        return note_to_payer;
    }

    public void setNote_to_payer(String note_to_payer) {
        this.note_to_payer = note_to_payer;
    }

    public Redirect_urls getRedirectUrls() {
        return redirect_urls;
    }

    public void setRedirect_urls(Redirect_urls redirectUrls) {
        this.redirect_urls = redirectUrls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostObjectPaypal)) return false;

        PostObjectPaypal that = (PostObjectPaypal) o;

        if (!getIntent().equals(that.getIntent())) return false;
        if (!getPayer().equals(that.getPayer())) return false;
        if (!getTransactions().equals(that.getTransactions())) return false;
        if (!getNote_to_payer().equals(that.getNote_to_payer())) return false;
        return getRedirectUrls().equals(that.getRedirectUrls());
    }

    @Override
    public int hashCode() {
        int result = getIntent().hashCode();
        result = 31 * result + getPayer().hashCode();
        result = 31 * result + getTransactions().hashCode();
        result = 31 * result + getNote_to_payer().hashCode();
        result = 31 * result + getRedirectUrls().hashCode();
        return result;
    }

//    @Override
//    public String toString() {
//        return "PostObjectPaypal{" +
//                "intent='" + intent + '\'' +
//                ", payer=" + payer +
//                ", transactions=" + transactions +
//                ", note_to_payer='" + note_to_payer + '\'' +
//                ", redirectUrls=" + redirect_urls +
//                '}';
//    }
}


