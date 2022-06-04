package model.service;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    boolean insertUser(User user) throws SQLException;
    User selectUser(int id);
    List<User> selectAllUser();
    boolean deleteUser(int id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    List<User> searchUser(String country);
    List<User> sortUser (String sortType);

    User getUserById(int id);
    boolean insertUserStore(User user) throws SQLException;
}
