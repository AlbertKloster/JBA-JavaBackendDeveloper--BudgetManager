package budget.menu;

import budget.utils.Input;
import budget.analyser.Analyser;
import budget.analyser.AnalyserAllPurchases;
import budget.analyser.AnalyserByType;
import budget.analyser.AnalyserCertainType;

public class MenuAnalyse {

    public static void run() {
        while (true) {
            printMenu();
            ItemAnalyse itemAnalyse = Input.getItemAnalyse();
            if (itemAnalyse == null)
                return;
            if (itemAnalyse.equals(ItemAnalyse.BACK))
                return;
            Analyser analyser = getAnalyser(itemAnalyse);
            analyser.sort();
        }
    }

    static void printMenu() {
        System.out.println("\nHow do you want to sort?");
        for (ItemAnalyse itemAnalyse : ItemAnalyse.values())
            System.out.println(itemAnalyse.menu);
    }

    static Analyser getAnalyser(ItemAnalyse itemAnalyse) {
        if (itemAnalyse.equals(ItemAnalyse.SORT_BY_TYPE))
            return new AnalyserByType();
        if (itemAnalyse.equals(ItemAnalyse.SORT_CERTAIN_TYPE))
            return new AnalyserCertainType();
        return new AnalyserAllPurchases();
    }

}
