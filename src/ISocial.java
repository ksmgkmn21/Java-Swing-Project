import java.util.HashMap;
import java.util.List;

public interface ISocial {

    public void addFriend(User active_user, User target_user) throws QueueEmpty, QueueFull;
    public void displayFriend(String username);
    public void sendRequest(User active_user, User target_user) throws QueueFull;
    public HashMap<String, User> getUserMap() ;
    public List<User> displayAllUsers();
    public User searchUser(String nickName);
    public void removePendingRequest(User user, User targetUser) throws QueueEmpty, QueueFull;
	void removeFriend(User active_user, User target_user);
}
