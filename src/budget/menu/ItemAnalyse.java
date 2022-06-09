package budget.menu;

public enum ItemAnalyse {
    SORT_ALL_PURCHASES(1, "1) Sort all purchases"),
    SORT_BY_TYPE(2, "2) Sort by type"),
    SORT_CERTAIN_TYPE(3, "3) Sort certain type"),
    BACK(4, "4) Back");

    final int position;
    final String menu;

    ItemAnalyse(int position, String menu) {
        this.position = position;
        this.menu = menu;
    }

    public static ItemAnalyse getItem(int position) {
        for (ItemAnalyse itemAnalyse : ItemAnalyse.values())
            if (itemAnalyse.position == position)
                return itemAnalyse;
        return null;
    }
}
