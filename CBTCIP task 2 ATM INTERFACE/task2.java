import java.util.*;

public class task2 {
    private static int balance = 1000;
    private static List<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of account");
        long d = sc.nextLong();
        System.out.println("Enter the account no");
        long h = sc.nextLong();

        boolean a = true;
        while (a) {
            System.out.println("Choose the option");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    transaction();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    exit();
                    a = false; // Set 'a' to false to exit the loop
                    break;
                default:
                    System.out.println("Enter the correct choice");
            }
        }

        sc.close(); // Close the Scanner after the loop has ended
    }

    static void transfer() {
        System.out.println("Please enter the amount you want to transfer");
        Scanner sc1 = new Scanner(System.in);
        long tb = sc1.nextLong();
        if (tb > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= tb;
            System.out.println("Transfer successful");
            transactionHistory.add("Transfer: -" + tb);
        }
    }

    static void exit() {
        System.out.println("Thank you. Visit Again");
    }

    static void deposit() {
        System.out.println("Enter the amount");
        Scanner sc2 = new Scanner(System.in);
        long dt = sc2.nextLong();
        balance += dt;
        System.out.println("Deposit successful. Remaining balance: " + balance);
        transactionHistory.add("Deposit: +" + dt);
    }

    static void withdraw() {
        System.out.println("Enter the amount you want to withdraw");
        Scanner sc3 = new Scanner(System.in);
        long wt = sc3.nextLong();
        if (wt > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= wt;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
            transactionHistory.add("Withdrawal: -" + wt);
        }
    }

    static void transaction() {
        System.out.println("Transaction History:");
        for (String entry : transactionHistory) {
            System.out.println(entry);
        }
    }
}
