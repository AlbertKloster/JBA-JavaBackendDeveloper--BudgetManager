package budget.menu;

import budget.data.Budget;
import budget.utils.FileHandler;
import budget.utils.Input;

public class MenuAction {

    private static final Budget budget = Budget.getInstance();

    public static void run() {

        boolean exit = false;

        while (!exit) {
            printMenu();
            ItemAction action = Input.getAction();
            if (action == null)
                return;
            switch (action) {
                case ADD_INCOME: {
                    addIncome();
                    break;
                }
                case ADD_PURCHASE: {
                    MenuAddPurchase.run();
                    break;
                }
                case SHOW_LIST_OF_PURCHASES: {
                    MenuShowListOfPurchases.run();
                    break;
                }
                case BALANCE: {
                    balance();
                    break;
                }
                case SAVE: {
                    save();
                    break;
                }
                case LOAD: {
                    load();
                    break;
                }
                case ANALYSE: {
                    MenuAnalyse.run();
                    break;
                }
                case EXIT: {
                    exit = true;
                    System.out.println("\nBye!");
                    break;
                }
            }
        }
    }

    static void printMenu() {
        System.out.println("\nChoose your action:");
        for (ItemAction itemAction : ItemAction.values())
            System.out.println(itemAction.menu);
    }

    static void addIncome() {
        System.out.println("Enter income:");
        budget.setIncome(budget.getIncome() + Input.getPrice());
        System.out.println("\nIncome was added!");
    }

    static void balance() {
        System.out.printf("\nBalance: $%.2f\n", budget.getIncome());
    }

    static void save() {
        FileHandler.save("purchases.txt");
        System.out.println("\nPurchases were saved!");
    }

    static void load() {
        FileHandler.load("purchases.txt");
        System.out.println("\nPurchases were loaded!");
    }



}
