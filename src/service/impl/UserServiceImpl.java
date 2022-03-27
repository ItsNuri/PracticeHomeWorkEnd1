package service.impl;

import com.company.exceptions.InvalidIdException;
import dao.UserDao;
import model.User;
import service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDao();

    @Override
    public void allUserAdd(User user) {
        userDao.allUserAdd(user);
    }

    @Override
    public User withIdFindUser(int id) {
        try {
            if (userDao.withIdFindUser(id) == null) {
                throw new InvalidIdException("User with such ID is not found");
            }
        }catch(InvalidIdException e) {
            System.err.println(e.getMessage());
        }
        return userDao.withIdFindUser(id);
    }

    @Override
    public void withIdRemove(int id) {
        userDao.withIdRemove(id);
    }

    @Override
    public List<User> allUsersFind() {
        return userDao.allUsersFind();
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "userDao=" + userDao +
                '}';
    }
}

