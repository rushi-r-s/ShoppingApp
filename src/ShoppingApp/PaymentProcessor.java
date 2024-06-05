package ShoppingApp;

public class PaymentProcessor {
    public static boolean processPayment(double amount, String paymentMethod) {
        System.out.println("Processing payment of $" + String.format("%.2f", amount) + " using " + paymentMethod);

        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            System.out.println("Payment process interrupted.");
        }

        boolean isSuccess = Math.random() > 0.5;
        if (isSuccess) {
            System.out.println("Payment processed successfully.");
        } else {
            System.out.println("Payment failed. Please try again.");
        }
        return isSuccess;
    }
}
