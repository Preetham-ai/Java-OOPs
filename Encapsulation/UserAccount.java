public class UserAccount {
    private String username;
    private String encryptedPassword;
    private int failedLoginAttempts;
    private boolean isLocked;
    
    public UserAccount(String username, String password) {
        if(username == null || username.isEmpty()) throw new IllegalArgumentException("Username required");
        this.username = username;
        setPassword(password);
    }
    
    public void setPassword(String newPassword) {
        if(newPassword.length() < 8) throw new IllegalArgumentException("Password must be 8+ characters");
        this.encryptedPassword = encryptPassword(newPassword);
    }
    
    private String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }
    
    public boolean login(String attemptedPassword) {
        if(isLocked) throw new IllegalStateException("Account locked");
        
        boolean success = encryptedPassword.equals(encryptPassword(attemptedPassword));
        if(!success) {
            failedLoginAttempts++;
            if(failedLoginAttempts >= 3) isLocked = true;
        } else {
            failedLoginAttempts = 0;
        }
        return success;
    }
    
    public void unlockAccount(String adminKey) {
        if("ADMIN123".equals(adminKey)) isLocked = false;
    }

    public static void main(String[] args) {
        UserAccount user = new UserAccount("john_doe", "secure123");
        
        System.out.println("Login attempt 1: " + user.login("wrongpass"));
        System.out.println("Login attempt 2: " + user.login("stillwrong"));
        System.out.println("Login attempt 3: " + user.login("secure123"));
        
        UserAccount lockedUser = new UserAccount("test_user", "password123");
        lockedUser.login("wrong");
        lockedUser.login("wrong");
        lockedUser.login("wrong");
        System.out.println("Is account locked? " + lockedUser.login("wrong"));
        
        lockedUser.unlockAccount("ADMIN123");
        System.out.println("After unlock: " + lockedUser.login("password123"));
    }
}
