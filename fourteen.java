import java.util.HashMap;
import java.util.Map;

// Interface for grocery items
interface GroceryItem {
    // Method to get available stock
    int getStock();

    // Method to update stock after placing an order
    void updateStock(int quantity);
}

// Concrete class for dairy products
class DairyProduct implements GroceryItem {
    private int stock;

    public DairyProduct(int initialStock) {
        this.stock = initialStock;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void updateStock(int quantity) {
        stock += quantity;
    }
}

// Concrete class for wafers
class Wafers implements GroceryItem {
    private int stock;

    public Wafers(int initialStock) {
        this.stock = initialStock;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void updateStock(int quantity) {
        stock += quantity;
    }
}

// Concrete class for vegetables
class Vegetables implements GroceryItem {
    private int stock;

    public Vegetables(int initialStock) {
        this.stock = initialStock;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void updateStock(int quantity) {
        stock += quantity;
    }
}

// Concrete class for beverages
class Beverages implements GroceryItem {
    private int stock;

    public Beverages(int initialStock) {
        this.stock = initialStock;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void updateStock(int quantity) {
        stock += quantity;
    }
}

// Grocery shop class
class GroceryShop {
    private Map<String, GroceryItem> inventory;

    public GroceryShop() {
        inventory = new HashMap<>();
        // Initialize items with initial stock
        inventory.put("Dairy Product", new DairyProduct(100));
        inventory.put("Wafers", new Wafers(150));
        inventory.put("Vegetables", new Vegetables(200));
        inventory.put("Beverages", new Beverages(300));
    }

    // Method to check stock and place an order if stock is not sufficient
    public void placeOrder(String item, int quantity) {
        if (inventory.containsKey(item)) {
            GroceryItem groceryItem = inventory.get(item);
            int availableStock = groceryItem.getStock();
            if (availableStock < quantity) {
                // Order more stock
                System.out.println("Ordering " + (quantity - availableStock) + " " + item);
                groceryItem.updateStock(quantity - availableStock);
            } else {
                System.out.println("Stock of " + item + " is sufficient.");
            }
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    // Method to display current stock of all items
    public void displayStock() {
        System.out.println("Current Stock:");
        for (Map.Entry<String, GroceryItem> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getStock());
        }
    }
}

public class fourteen{
    public static void main(String[] args) {
        GroceryShop groceryShop = new GroceryShop();

        // Display initial stock
        groceryShop.displayStock();

        // Simulate customer demand and place orders
        groceryShop.placeOrder("Dairy Product", 50);
        groceryShop.placeOrder("Wafers", 200);
        groceryShop.placeOrder("Vegetables", 100);
        groceryShop.placeOrder("Beverages", 250);

        // Display updated stock after placing orders
        groceryShop.displayStock();
    }
}

