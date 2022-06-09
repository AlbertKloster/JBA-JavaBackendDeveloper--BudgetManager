package budget.pojo;

import budget.menu.ItemAddPurchase;

public class Purchase {
    private final String name;
    private final double price;
    private final ItemAddPurchase itemAddPurchase;

    public Purchase(String name, double price, ItemAddPurchase itemAddPurchase) {
        this.name = name;
        this.price = price;
        this.itemAddPurchase = itemAddPurchase;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ItemAddPurchase getCategory() {
        return itemAddPurchase;
    }
}
