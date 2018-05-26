package philip.notes.user;

public interface UserService {
    User loadByUsername(String username);
    User register(String username, String password);
}
