package budget.analyser;

import budget.data.Budget;
import budget.pojo.Purchase;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;

public class AnalyserAllPurchases implements Analyser {
    private final Budget budget = Budget.getInstance();
    @Override
    public void sort() {
        if (budget.getPurchases().isEmpty()) {
            System.out.println("\nThe purchase list is empty!");
            return;
        }
        System.out.println("\nAll:");
        AtomicReference<Double> total = new AtomicReference<>(0.0);
        budget.getPurchases()
                .stream()
                .sorted(Comparator.comparingDouble(Purchase::getPrice).reversed())
                .forEachOrdered(purchase -> {
                    System.out.printf("%s $%.2f\n", purchase.getName(), purchase.getPrice());
                    total.updateAndGet(price -> price + purchase.getPrice());
                });
        System.out.printf("Total: $%.2f\n", total.get());
    }
}
