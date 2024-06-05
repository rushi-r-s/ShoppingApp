package ShoppingApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductCatalog implements IProductCatalog  {
    private List<Product> products = new ArrayList<>();
    private ProductFactory productFactory = new ProductFactory();

    public void loadProducts() {
        
    	 products.add(productFactory.createProduct("Electronics", "Laptop", 2000.00, "High-performance laptop", "2 years"));
         products.add(productFactory.createProduct("Electronics", "Mobile", 1000.00, "High-performance mobile", "1 year"));
         products.add(productFactory.createProduct("Electronics", "Earphones", 500.00, "High-quality earphones", "1 year"));
         products.add(productFactory.createProduct("Electronics", "Tv", 300.00, "High-definition TV", "5 years"));
         
         products.add(productFactory.createProduct("Clothing", "Shirt", 500.00, "Cotton t-shirt", "M"));
         products.add(productFactory.createProduct("Clothing", "Jeans", 400.00, "Comfortable jeans", "L"));
         products.add(productFactory.createProduct("Clothing", "Suit", 300.00, "Formal suit", "L"));
         products.add(productFactory.createProduct("Clothing", "Tie", 100.00, "Silk tie", "One size"));
        System.out.println("Products loaded.");
    }
    
    public List<Product> getProducts() {
        return products;  
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : products) {
                product.displayInfo();
            }
        }
    }

    public void addProductToCart(Scanner scanner, Cart cart) {
        System.out.print("Enter product name to add to cart: ");
        String name = scanner.next();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                cart.addItem(product);
                return;
            }
        }
        System.out.println("Product not found.");
    }
}
