import java.util.Scanner;

public class ExpenseTrackerSimple {
    static double[] amounts = new double[50];
    static String[] categories = new String[50];
    static String[] descriptions = new String[50];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Expense Tracker ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Calculation");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addExpense(sc);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    calculateTotal();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }

    static void addExpense(Scanner sc) {
        if (count >= amounts.length) {
            System.out.println("Expense list is full!");
            return;
        }
        System.out.print("Enter amount: ");
        amounts[count] = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter category: ");
        categories[count] = sc.nextLine();
        System.out.print("Enter description: ");
        descriptions[count] = sc.nextLine();
        count++;
        System.out.println("Expense added!");
    }

    static void viewExpenses() {
        if (count == 0) {
            System.out.println("No expenses recorded.");
            return;
        }
        System.out.println("\n--- Expenses ---");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + amounts[i] + " | " + categories[i] + " | " + descriptions[i]);
        }
    }

    static void calculateTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += amounts[i];
        }
        System.out.println("Total amount spent: " + total);
    }
}
