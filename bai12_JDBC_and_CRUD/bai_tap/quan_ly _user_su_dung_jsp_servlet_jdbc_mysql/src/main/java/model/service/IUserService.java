package model.service;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IUserService {
    Map<String, String> insertUser(User user) throws SQLException;
    User selectUser(int id);
    List<User> selectAllUser();
    boolean deleteUser(int id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    List<User> searchUser(String country);
    List<User> sortUser (String sortType);
}
