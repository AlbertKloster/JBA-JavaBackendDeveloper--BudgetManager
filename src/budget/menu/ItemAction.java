package budget.menu;

public enum ItemAction {
    ADD_INCOME(1, "1) Add income"),
    ADD_PURCHASE(2, "2) Add purchase"),
    SHOW_LIST_OF_PURCHASES(3, "3) Show list of purchases"),
    BALANCE(4, "4) Balance"),
    SAVE(5, "5) Save"),
    LOAD(6, "6) Load"),
    ANALYSE(7, "7) Analyze (Sort)"),
    EXIT(0, "0) Exit");

    final int position;
    final String menu;

    ItemAction(int position, String menu) {
        this.position = position;
        this.menu = menu;
    }

    public static ItemAction getItem(int position) {
        for (ItemAction itemAction : ItemAction.values())
            if (itemAction.position == position)
                return itemAction;
        return null;
    }


}
