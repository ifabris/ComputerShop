package hr.algebra.computerShop.feature.user;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    User saveUser(User user);
    void deleteUser(int id);
}
