package paypalRestAPI.paymentPojo;

import java.util.List;

public class Item_List {
    private List<Items> items;
    private Shipping_address shipping_address;

    public Shipping_address getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(Shipping_address shipping_address) {
        this.shipping_address = shipping_address;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Item_List{" +
                "items=" + items +
                ", shipping_address=" + shipping_address +
                '}';
    }
}
