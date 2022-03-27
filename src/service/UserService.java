package service;

import model.User;

import java.util.List;

public interface UserService {

    void allUserAdd(User user);

    User withIdFindUser(int id);

    void withIdRemove(int id);

    List<User> allUsersFind();
}
