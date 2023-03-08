package Template;

public class AppAuthenticator extends Authenticator {
    @Override
    protected boolean verifyCredentials(String username, String password) {
        if(username.equals("admin") && password.equals("admin")){
            return true;
        }
        else
            return false;
    }

    @Override
    protected boolean checkUserActive(String username) {
        // Check if user is active using email
        return true; // Placeholder for actual implementation
    }

    @Override
    protected boolean checkUserRoles(String username) {
        // Check user roles using email
        return true; // Placeholder for actual implementation
    }
}
