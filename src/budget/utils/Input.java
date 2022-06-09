package budget.utils;

import budget.menu.ItemAction;
import budget.menu.ItemAddPurchase;
import budget.menu.ItemAnalyse;
import budget.menu.ItemShowListOfPurchases;

import java.util.Scanner;

public class Input {
    static final Scanner SC = new Scanner(System.in);

    public static ItemAction getAction() {
        String input = SC.nextLine();
        if (isNotAction(input))
            return null;
        return ItemAction.getItem(Integer.parseInt(input));
    }

    private static boolean isNotAction(String input) {
        return !input.matches("[0-7]");
    }

    public static double getPrice() {
        String input = SC.nextLine();
        if (isNotPrice(input))
            return 0.0;
        return Double.parseDouble(input);
    }

    private static boolean isNotPrice(String input) {
        return !input.matches("\\d+\\.?\\d*");
    }

    public static String getString() {
        return SC.nextLine();
    }

    public static ItemAddPurchase getItemAddPurchase() {
        String input = SC.nextLine();
        if (isNotItemAddPurchase(input))
            return null;
        return ItemAddPurchase.getItem(Integer.parseInt(input));
    }

    private static boolean isNotItemAddPurchase(String input) {
        return !input.matches("[1-5]");
    }

    public static ItemShowListOfPurchases getItemShowListOfPurchases() {
        String input = SC.nextLine();
        if (isNotItemShowListOfPurchases(input))
            return null;
        return ItemShowListOfPurchases.getItem(Integer.parseInt(input));
    }

    private static boolean isNotItemShowListOfPurchases(String input) {
        return !input.matches("[1-6]");
    }

    public static ItemAnalyse getItemAnalyse() {
        String input = SC.nextLine();
        if (isNotItemAnalyse(input))
            return null;
        return ItemAnalyse.getItem(Integer.parseInt(input));
    }

    private static boolean isNotItemAnalyse(String input) {
        return !input.matches("[1-6]");
    }

}
