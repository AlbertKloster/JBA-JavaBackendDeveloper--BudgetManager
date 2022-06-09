package budget.menu;

import budget.data.Budget;
import budget.utils.Input;
import budget.pojo.Purchase;

import java.util.ArrayList;
import java.util.List;

public class MenuShowListOfPurchases {
    private static final Budget budget = Budget.getInstance();

    public static void run() {
        if (budget.getPurchases().isEmpty()) {
            System.out.println("\nThe purchase list is empty!");
            return;
        }
        while (true) {
            printMenu();
            ItemShowListOfPurchases itemShowListOfPurchases = Input.getItemShowListOfPurchases();
            if (itemShowListOfPurchases == null)
                return;
            if (itemShowListOfPurchases.equals(ItemShowListOfPurchases.BACK))
                return;
            showListOfPurchases(itemShowListOfPurchases);
        }
    }

    static void printMenu() {
        System.out.println("\nChoose the type of purchases");
        for (ItemShowListOfPurchases itemShowListOfPurchases : ItemShowListOfPurchases.values())
            System.out.println(itemShowListOfPurchases.menu);
    }

    static void showListOfPurchases(ItemShowListOfPurchases itemShowListOfPurchases) {
        double total = 0.0;
        System.out.println();
        System.out.println(itemShowListOfPurchases.header);
        List<Purchase> purchaseList = getListOfPurchases(itemShowListOfPurchases);
        if (purchaseList.isEmpty()) {
            System.out.println("The purchase list is empty!");
            return;
        }
        for (Purchase purchase : purchaseList) {
            System.out.printf("%s $%.2f\n", purchase.getName(), purchase.getPrice());
            total += purchase.getPrice();
        }
        System.out.printf("Total sum: $%.2f\n", total);
    }

    static List<Purchase> getListOfPurchases(ItemShowListOfPurchases itemShowListOfPurchases) {
        List<Purchase> purchaseList = new ArrayList<>();
        for (Purchase purchase : budget.getPurchases()) {
            if (itemShowListOfPurchases.equals(ItemShowListOfPurchases.ALL) ||
                    itemShowListOfPurchases.name().equals(purchase.getCategory().name())) {
                purchaseList.add(purchase);
            }
        }
        return purchaseList;
    }

}
