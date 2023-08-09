public class User {
  private String username;
  private String userID;
  private String role;
  
  public User(String username, String userID, String role) {
    this.username = username;
    this.userID = userID;
    this.role = role;
    
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getUserID() {
    return userID;
  }
  public void setUserID(String userID) {
    this.userID = userID;
  }
  public void setRole(String role) {
    this.role = role;
  }
  public String getRole() {
    return role;
  }
  public void display() {
    
  }
}
