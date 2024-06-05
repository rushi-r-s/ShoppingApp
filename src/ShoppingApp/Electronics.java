package ShoppingApp;

public class Electronics extends Product {
    private String warrantyPeriod;

    public Electronics(String name, double price, String description, String warrantyPeriod) {
        super(name, price, description);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName() + ", Price: " + getPrice() + ", Description: " + getDescription() + ", Warranty: " + warrantyPeriod);
    }
}
