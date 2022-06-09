package budget.menu;

public enum ItemAddPurchase {
    FOOD(1, "1) Food", "Food:", "Food"),
    CLOTHES(2, "2) Clothes", "Clothes:", "Clothes"),
    ENTERTAINMENT(3, "3) Entertainment", "Entertainment:", "Entertainment"),
    OTHER(4, "4) Other", "Other:", "Other"),
    BACK(5, "5) Back", "", "");

    public final int position;
    public final String menu;
    public final String header;
    public final String type;

    ItemAddPurchase(int position, String menu, String header, String type) {
        this.position = position;
        this.menu = menu;
        this.header = header;
        this.type = type;
    }

    public static ItemAddPurchase getItem(int position) {
        for (ItemAddPurchase itemAddPurchase : ItemAddPurchase.values())
            if (itemAddPurchase.position == position)
                return itemAddPurchase;
        return null;
    }

    public static ItemAddPurchase getItem(String name) {
        for (ItemAddPurchase itemAddPurchase : ItemAddPurchase.values())
            if (itemAddPurchase.name().equals(name))
                return itemAddPurchase;
        return null;
    }
}
