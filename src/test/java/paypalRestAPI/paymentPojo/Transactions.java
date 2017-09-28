package paypalRestAPI.paymentPojo;

public class Transactions {
    private Amount amount;
    private String description;
    private String custom;
    private String invoice_number;
    private Payment_Options payment_options;
    private String soft_descriptor;
    private Item_List item_list;

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }

    public String getSoft_descriptor() {
        return soft_descriptor;
    }

    public void setSoft_descriptor(String soft_descriptor) {
        this.soft_descriptor = soft_descriptor;
    }

    public Payment_Options getPayment_options() {
        return payment_options;
    }

    public void setPayment_options(Payment_Options payment_options) {
        this.payment_options = payment_options;
    }

    public Item_List getItem_list() {
        return item_list;
    }

    public void setItem_list(Item_List item_list) {
        this.item_list = item_list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transactions)) return false;

        Transactions that = (Transactions) o;

        if (!getAmount().equals(that.getAmount())) return false;
        if (!getDescription().equals(that.getDescription())) return false;
        if (!getCustom().equals(that.getCustom())) return false;
        if (!getInvoice_number().equals(that.getInvoice_number())) return false;
        if (!getSoft_descriptor().equals(that.getSoft_descriptor())) return false;
        if (!getPayment_options().equals(that.getPayment_options())) return false;
        return getItem_list().equals(that.getItem_list());
    }

    @Override
    public int hashCode() {
        int result = getAmount().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getCustom().hashCode();
        result = 31 * result + getInvoice_number().hashCode();
        result = 31 * result + getSoft_descriptor().hashCode();
        result = 31 * result + getPayment_options().hashCode();
        result = 31 * result + getItem_list().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", custom='" + custom + '\'' +
                ", invoice_number='" + invoice_number + '\'' +
                ", soft_descriptor='" + soft_descriptor + '\'' +
                ", payment_options=" + payment_options +
                ", item_list=" + item_list +
                '}';
    }
}

