import java.util.ArrayList;
import java.util.List;

// Bank class
class Bank {
    private String name;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void openAccount(Customer customer, double initialDeposit) {
        Account newAccount = new Account(this, customer, initialDeposit);
        accounts.add(newAccount);
        customer.addAccount(newAccount);
        System.out.println("Account opened for " + customer.getName() + " at " + name + " with balance: " + initialDeposit);
    }

    public String getName() {
        return name;
    }
}

// Customer class
class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public String getName() {
        return name;
    }

    public void viewBalances() {
        for (Account account : accounts) {
            System.out.println("Bank: " + account.getBank().getName() + ", Balance: " + account.getBalance());
        }
    }
}

// Account class
class Account {
    private Bank bank;
    private Customer customer;
    private double balance;

    public Account(Bank bank, Customer customer, double initialDeposit) {
        this.bank = bank;
        this.customer = customer;
        this.balance = initialDeposit;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }
}

// BankDemo class to demonstrate association
public class BankDemo {
    public static void main(String[] args) {
        // Creating a bank
        Bank bank = new Bank("State Bank");

        // Creating customers
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        // Opening accounts
        bank.openAccount(customer1, 5000);
        bank.openAccount(customer2, 3000);
        bank.openAccount(customer1, 2000); // Alice opens another account

        // Viewing balances
        System.out.println("\nCustomer Account Balances:");
        customer1.viewBalances();
        customer2.viewBalances();
    }
}
