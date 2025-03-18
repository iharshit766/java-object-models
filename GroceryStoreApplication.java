import java.util.ArrayList;
import java.util.List;

// Class representing a Product with name, quantity, and price per unit
class Product {
    private String name;
    private double quantity; // Could be in kg or liters
    private double pricePerUnit;

    public Product(String name, double quantity, double pricePerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double getTotalPrice() {
        return quantity * pricePerUnit;
    }
}

// Class representing a Customer who purchases multiple products
class Customer {
    private String name;
    private List<Product> cart;

    public Customer(String name) {
        this.name = name;
        this.cart = new ArrayList<>();
    }

    public void addProduct(Product product) {
        cart.add(product);
    }

    public List<Product> getCart() {
        return cart;
    }

    public String getName() {
        return name;
    }
}

// Class responsible for generating the bill for a Customer
class BillGenerator {
    public static double calculateTotalBill(Customer customer) {
        double total = 0;
        for (Product product : customer.getCart()) {
            total += product.getTotalPrice();
        }
        return total;
    }

    public static void printBill(Customer customer) {
        System.out.println("Customer: " + customer.getName());
        System.out.println("Purchased Products:");
        for (Product product : customer.getCart()) {
            System.out.printf("%s (%.2f units at $%.2f per unit) - Total: $%.2f\n",
                    product.getName(), product.getQuantity(), product.getPricePerUnit(), product.getTotalPrice());
        }
        System.out.println("Total Bill: $" + calculateTotalBill(customer));
    }
}

// Main class to demonstrate the bill generation process
public class GroceryStoreApplication {
    public static void main(String[] args) {
        // Creating a customer
        Customer customer = new Customer("Alice");

        // Adding products to the cart
        customer.addProduct(new Product("Apples", 2, 3)); // 2 kg at $3 per kg
        customer.addProduct(new Product("Milk", 1, 2));   // 1 liter at $2 per liter

        // Generating and printing the bill
        BillGenerator.printBill(customer);
    }
}
