package budget.menu;

public enum ItemShowListOfPurchases {
    FOOD(1, "1) Food", "Food:"),
    CLOTHES(2, "2) Clothes", "Clothes:"),
    ENTERTAINMENT(3, "3) Entertainment", "Entertainment:"),
    OTHER(4, "4) Other", "Other:"),
    ALL(5, "5) All", "All:"),
    BACK(6, "6) Back", "");

    final int position;
    final String menu;
    final String header;

    ItemShowListOfPurchases(int position, String menu, String header) {
        this.position = position;
        this.menu = menu;
        this.header = header;
    }

    public static ItemShowListOfPurchases getItem(int position) {
        for (ItemShowListOfPurchases itemShowListOfPurchases : ItemShowListOfPurchases.values())
            if (itemShowListOfPurchases.position == position)
                return itemShowListOfPurchases;
        return null;
    }
}
