package budget.menu;

import budget.data.Budget;
import budget.utils.Input;
import budget.pojo.Purchase;

public class MenuAddPurchase {
    private static final Budget budget = Budget.getInstance();

    public static void run() {
        while (true) {
            printMenu();
            ItemAddPurchase itemAddPurchase = Input.getItemAddPurchase();
            if (itemAddPurchase == null)
                return;
            if (itemAddPurchase.equals(ItemAddPurchase.BACK))
                return;
            addPurchase(itemAddPurchase);
        }
    }

    static void printMenu() {
        System.out.println("\nChoose the type of purchase");
        for (ItemAddPurchase itemAddPurchase : ItemAddPurchase.values())
            System.out.println(itemAddPurchase.menu);
    }

    static void addPurchase(ItemAddPurchase itemAddPurchase) {
        System.out.println("\nEnter purchase name:");
        String name = Input.getString();
        System.out.println("Enter its price:");
        double price = Input.getPrice();
        budget.addPurchase(new Purchase(name, price, itemAddPurchase));
        budget.setIncome(Math.max(0, budget.getIncome() - price));
        System.out.println("Purchase was added!");
    }

}
