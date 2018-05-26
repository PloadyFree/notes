package philip.notes.user;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User loadByUsername(String username) {
        return userRepository.findById(username).orElse(null);
    }

    @Override
    public User register(String username, String password) {
        User user = new User(username, passwordEncoder.encode(password));
        userRepository.save(user);
        return user;
    }
}