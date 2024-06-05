package ShoppingApp;
import java.util.Scanner;

public class Main {
    private static AuthenticationService authService = new AuthenticationService();
    private static IProductCatalog productCatalog = new ProductCatalog();
    private static Cart cart = Cart.getInstance();
    private static Logger logger = new Logger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;


        productCatalog.loadProducts();

        while (running) {
            System.out.println("\nPLease select to get started");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Products Catalog");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice != 1 && choice != 2 && choice != 6 && authService.getCurrentUser() == null) {
                System.out.println("Please login first.");
                continue;
            }

            switch (choice) {
                case 1:
                	if (authService.getCurrentUser() == null)
                	{
                    authService.login(scanner);
                	} else {
                		System.out.println("You are already logged in");
                	}
                	break;
                case 2:
                    authService.register(scanner);
                    break;
                case 3:
                    if (authService.getCurrentUser() != null) {
                        productCatalog.displayProducts();
                        productCatalog.addProductToCart(scanner, cart);
                    } else {
                        System.out.println("Please login to browse products.");
                    }
                    break;
                case 4:
                    if (authService.getCurrentUser() != null) {
                        cart.displayCart();
                    } else {
                        System.out.println("Please login to view your cart.");
                    }
                    break;
                case 5:
                    if (authService.getCurrentUser() != null) {
                    	 OrderProcessing orderProcessing = new OrderProcessing(cart, authService.getCurrentUser());
                         Order order = orderProcessing.createAndProcessOrder(scanner);
                         if (order != null) {
                             order.displayOrderDetails();
                         }
                    } else {
                        System.out.println("Please login to checkout.");
                    }
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Shopping System!");
    }
}
