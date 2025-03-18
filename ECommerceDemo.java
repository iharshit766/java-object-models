import java.util.ArrayList;
import java.util.List;

// ECommercePlatform class containing customers and orders
class ECommercePlatform {
    private String name;
    private List<Customer> customers;
    private List<Order> orders;

    public ECommercePlatform(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void displayPlatformInfo() {
        System.out.println("E-Commerce Platform: " + name);
        System.out.println("Customers:");
        for (Customer customer : customers) {
            System.out.println("  " + customer.getName());
        }
        System.out.println("\nOrders:");
        for (Order order : orders) {
            System.out.println("  Order ID: " + order.getOrderId() + " by " + order.getCustomer().getName());
        }
    }
}

// Customer class (places multiple orders)
class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }
}

// Product class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Order class (aggregates products)
class Order {
    private static int orderCounter = 1;
    private int orderId;
    private Customer customer;
    private List<Product> products;

    public Order(Customer customer) {
        this.orderId = orderCounter++;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId + " placed by " + customer.getName());
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("  " + product.getName() + " - $" + product.getPrice());
        }
    }
}

// ECommerceDemo class to demonstrate the system
public class ECommerceDemo {
    public static void main(String[] args) {
        // Creating an e-commerce platform
        ECommercePlatform platform = new ECommercePlatform("ShopEase");

        // Creating customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");
        platform.addCustomer(alice);
        platform.addCustomer(bob);

        // Creating products
        Product laptop = new Product("Laptop", 1000.00);
        Product phone = new Product("Smartphone", 500.00);

        // Creating orders
        Order order1 = new Order(alice);
        order1.addProduct(laptop);
        order1.addProduct(phone);
        platform.addOrder(order1);

        Order order2 = new Order(bob);
        order2.addProduct(phone);
        platform.addOrder(order2);

        // Displaying order details
        order1.displayOrderDetails();
        order2.displayOrderDetails();

        // Displaying platform info
        platform.displayPlatformInfo();
    }
}
