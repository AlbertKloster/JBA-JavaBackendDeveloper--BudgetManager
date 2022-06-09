package budget.analyser;

import budget.data.Budget;
import budget.menu.ItemAddPurchase;
import budget.pojo.Purchase;
import budget.pojo.Type;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class AnalyserByType implements Analyser {

    private final Budget budget = Budget.getInstance();

    @Override
    public void sort() {
        System.out.println("\nTypes:");
        AtomicReference<Double> total = new AtomicReference<>(0.0);
        getTypeList().stream().sorted(Comparator.comparingDouble(Type::getPrice).reversed())
                .forEach(type -> {
                    System.out.printf("%s - $%.2f\n", type.getType(), type.getPrice());
                    total.updateAndGet(price -> price + type.getPrice());
                });
        System.out.printf("Total sum: $%.2f\n", total.get());
    }

    private List<Type> getTypeList() {
        List<Type> typeList = new ArrayList<>();
        for (ItemAddPurchase itemAddPurchase : ItemAddPurchase.values()) {
            if (itemAddPurchase.equals(ItemAddPurchase.BACK))
                break;
            typeList.add(getType(itemAddPurchase));
        }
        return typeList;
    }

    private Type getType(ItemAddPurchase itemAddPurchase) {
        return new Type(itemAddPurchase.type, budget.getPurchases()
                .stream()
                .filter(purchase -> purchase.getCategory().equals(itemAddPurchase))
                .mapToDouble(Purchase::getPrice).sum());
    }
}
