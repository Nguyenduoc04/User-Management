package vn.codegym.usermanagement.Service;

import vn.codegym.usermanagement.Model.User;

import vn.codegym.usermanagement.DAO.UserDAO;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public List<User> findAll() {
        return userDAO.selectAllUsers();
    }

    public User findById(int id) {
        return userDAO.selectUser(id);
    }

    public void save(User user) throws SQLException {
        userDAO.insertUser(user);
    }

    public void update(User user) throws SQLException {
        userDAO.updateUser(user);
    }

    public void remove(int id) throws SQLException {
        userDAO.deleteUser(id);
    }

    public List<User> searchByCountry(String country) {
        return userDAO.searchByCountry(country);
    }

    public List<User> sortByName() {
        return userDAO.sortByName();
    }
}
