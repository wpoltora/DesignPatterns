package Template;

public abstract class Authenticator {
    private boolean authenticated = false;

    public boolean authenticate(String username, String password) {
        if (!verifyCredentials(username, password)) {
            System.out.println("Invalid username or password");
            return false;
        }
        if (!checkUserActive(username)) {
            System.out.println("User is not active");
            return false;
        }
        if (!checkUserRoles(username)) {
            System.out.println("User does not have necessary roles");
            return false;
        }
        // Authentication successful
        System.out.println("Authentication successful");
        authenticated = true;
        return true;
    }

    protected abstract boolean verifyCredentials(String username, String password);
    protected abstract boolean checkUserActive(String username);
    protected abstract boolean checkUserRoles(String username);

    public boolean isAuthenticated(){
        return authenticated;
    }
}