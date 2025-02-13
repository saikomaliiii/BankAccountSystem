import java.util.Scanner;

// BankAccount class to handle account operations
class BankAccount {
    private double balance;

    // Constructor initializes the balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Current Balance: $" + balance);
        } else {
            System.out.println("Invalid amount! Deposit must be greater than 0.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining Balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds! Available Balance: $" + balance);
        } else {
            System.out.println("Invalid amount! Withdrawal must be greater than 0.");
        }
    }

    // Check balance method
    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }
}

// BankSystem class for user interaction
class BankSystem {
    private Scanner scanner = new Scanner(System.in);
    private BankAccount account;

    // Constructor initializes an account with a default balance
    public BankSystem() {
        System.out.print("Enter Initial Account Balance: ");
        double initialBalance = scanner.nextDouble();
        account = new BankAccount(initialBalance);
    }

    // Menu-driven banking operations
    public void menu() {
        while (true) {
            System.out.println("\nBank Account System");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> account.checkBalance();
                case 2 -> {
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                }
                case 3 -> {
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                }
                case 4 -> {
                    System.out.println("Exiting Bank System. Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        }
    }
}

// Main class
public class BankAccountSystem {
    public static void main(String[] args) {
        BankSystem bank = new BankSystem();
        bank.menu();
    }
}
