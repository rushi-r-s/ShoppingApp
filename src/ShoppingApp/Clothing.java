package ShoppingApp;

public class Clothing extends Product {
    private String size;

    public Clothing(String name, double price, String description, String size) {
        super(name, price, description);
        this.size = size;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName() + ", Price: " + getPrice() + ", Description: " + getDescription() + ", Size: " + size);
    }
}
