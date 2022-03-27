package dao;

import model.User;
import service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDao implements UserService {

    private Map<Integer, User> users = new HashMap<>();

    @Override
    public void allUserAdd(User user) {
        users.put((int) user.getId(), user);
    }

    @Override
    public User withIdFindUser(int id) {
        return users.get(id);
    }

    @Override
    public void withIdRemove(int id) {
        users.remove(id);
    }

    @Override
    public List<User> allUsersFind() {
        return users.values().stream().toList();
    }
}
