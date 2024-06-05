package ShoppingAppTest;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;

import java.util.Scanner;
import static org.junit.Assert.assertTrue;


import ShoppingApp.AuthenticationService;
import ShoppingApp.User;

public class AuthenticationServiceTest {
    private AuthenticationService authService;

    @Before
    public void setUp() {
        authService = new AuthenticationService();
        authService.register(new Scanner("Rushikesh Rushikesh@12345"));
        authService.register(new Scanner("Manav LytfSS@12345"));
    }

    @Test
    public void testLoginSuccess() {
        String input = "Rushikesh\nRushikesh@12345\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        assertTrue("User should be able to log in with correct credentials", authService.login(scanner));
    }

    @Test
    public void testLoginFailure() {
        String input = "Rushikesh\nLytfSS\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        assertFalse("User should not be able to log in with incorrect password", authService.login(scanner));
    }

    @Test
    public void testLogout() {
        String loginInput = "Rushikesh\nRushikesh@12345\n";
        System.setIn(new ByteArrayInputStream(loginInput.getBytes()));
        Scanner loginScanner = new Scanner(System.in);
        authService.login(loginScanner);

        authService.logout();
        assertNull("currentUser should be null after logout", authService.getCurrentUser());
    }

    @Test
    public void testRegisterNewUser() {
        String newUserData = "Virat\nqwerty@989\n";
        System.setIn(new ByteArrayInputStream(newUserData.getBytes()));
        Scanner registerScanner = new Scanner(System.in);

        authService.register(registerScanner);

        assertTrue("New user should be registered successfully",authService.getUsers().containsKey("Virat"));

        registerScanner.close();  
    }
}
