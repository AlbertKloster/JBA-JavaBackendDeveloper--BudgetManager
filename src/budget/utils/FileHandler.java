package budget.utils;

import budget.data.Budget;
import budget.pojo.Purchase;
import budget.menu.ItemAddPurchase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
    public static void save(String filename) {
        Budget budget = Budget.getInstance();
        File file = new File("./" + filename);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(String.format("%.2f\n", budget.getIncome()));
            for (Purchase purchase : budget.getPurchases()) {
                writer.write(String.format("%s: %s $%.2f\n",
                        purchase.getCategory().name(),
                        purchase.getName(),
                        purchase.getPrice()));
            }

        } catch (IOException e) {
            System.out.printf("An exception occurred %s", e.getMessage());
        }

    }

    public static void load(String filename) {
        Budget budget = Budget.getInstance();
        File file = new File("./" + filename);

        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNext())
                budget.setIncome(Double.parseDouble(scanner.nextLine()));
            while (scanner.hasNext())
                setBudget(budget, scanner.nextLine());

        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + filename);
        }
    }

    private static void setBudget(Budget budget, String line) {
        budget.addPurchase(new Purchase(getName(line), getPrice(line), getItemAddPurchase(line)));
    }

    private static ItemAddPurchase getItemAddPurchase(String line) {
        String[] elements = line.split(":");
        if (elements.length < 2)
            return null;
        return ItemAddPurchase.getItem(elements[0]);
    }

    private static double getPrice(String line) {
        String[] elements = line.split("\\$");
        if (elements.length < 2)
            return 0.0;
        if (!elements[elements.length - 1].matches("\\d+\\.?\\d*"))
            return 0.0;
        return Double.parseDouble(elements[elements.length - 1]);
    }

    private static String getName(String line) {
        String[] elementsWithType = line.split(": ");
        if (elementsWithType.length < 2)
            return "";
        String type = elementsWithType[0];
        String[] elementsWithPrice = line.split(" \\$");
        if (elementsWithPrice.length < 2)
            return "";
        String price = elementsWithPrice[elementsWithPrice.length - 1];

        return line.substring(type.length() + 2, line.length() - price.length() - 2);
    }
}
