package budget.analyser;

import budget.data.Budget;
import budget.utils.Input;
import budget.menu.ItemAddPurchase;
import budget.pojo.Purchase;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class AnalyserCertainType implements Analyser {

    private final Budget budget = Budget.getInstance();

    @Override
    public void sort() {
        printMenu();
        ItemAddPurchase itemAddPurchase = Input.getItemAddPurchase();
        if (itemAddPurchase == null)
            return;
        if (itemAddPurchase.equals(ItemAddPurchase.BACK))
            return;
        System.out.println();
        List<Purchase> purchaseList = getPurchaseList(itemAddPurchase);
        if (purchaseList.isEmpty()) {
            System.out.println("The purchase list is empty!");
            return;
        }
        System.out.println(itemAddPurchase.header);
        AtomicReference<Double> total = new AtomicReference<>(0.0);
        purchaseList.stream()
                .sorted(Comparator.comparingDouble(Purchase::getPrice).reversed())
                .forEach(purchase -> {
                    System.out.printf("%s $%.2f\n", purchase.getName(), purchase.getPrice());
                    total.updateAndGet(price -> price + purchase.getPrice());
                });
        System.out.printf("Total sum: $%.2f\n", total.get());
    }

    private void printMenu() {
        System.out.println("\nChoose the type of purchase");
        for (ItemAddPurchase itemAddPurchase : ItemAddPurchase.values()) {
            if (itemAddPurchase.equals(ItemAddPurchase.BACK))
                return;
            System.out.println(itemAddPurchase.menu);
        }
    }

    private List<Purchase> getPurchaseList(ItemAddPurchase itemAddPurchase) {
        return budget.getPurchases().stream()
                .filter(purchase -> purchase.getCategory().equals(itemAddPurchase))
                .collect(Collectors.toList());
    }


}
