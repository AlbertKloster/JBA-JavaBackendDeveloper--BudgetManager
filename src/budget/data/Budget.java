package budget.data;

import budget.pojo.Purchase;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton Class for shared Data
 */
public class Budget {

    private static Budget instance;
    private double income = 0.0;
    private final List<Purchase> purchases = new ArrayList<>();

    private Budget() { }

    public static Budget getInstance() {
        if (instance == null)
            instance = new Budget();
        return instance;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }
}
