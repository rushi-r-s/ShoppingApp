package ShoppingApp;

import java.util.Scanner;

import java.util.HashMap;

public class AuthenticationService {
    private HashMap<String, User> users = new HashMap<>();
    private User currentUser;

    public boolean login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            user.setLoggedIn(true);
            currentUser = user;
            System.out.println("Login successful!");
            Logger.log("Login successful for user: " + username);
            return true;
        } else {
            System.out.println("Login failed!");
            Logger.log("Failed login attempt for user: " + username);
            return false;
        }
    }

    public void logout() {
        if (currentUser != null) {
            currentUser.setLoggedIn(false);
            currentUser = null;
            System.out.println("Logged out successfully.");
        }
    }

    public void register(Scanner scanner) {
        System.out.print("Enter new username: ");
        String username = scanner.next();
        System.out.print("Enter new password: ");
        String password = scanner.next();

        if (users.containsKey(username)) {
            System.out.println("User already exists!");
        } else {
            users.put(username, new User(username, password));
            System.out.println("Registration successful!");
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }
    
    public HashMap<String, User> getUsers() {
        return users;
    }
    
    
}
