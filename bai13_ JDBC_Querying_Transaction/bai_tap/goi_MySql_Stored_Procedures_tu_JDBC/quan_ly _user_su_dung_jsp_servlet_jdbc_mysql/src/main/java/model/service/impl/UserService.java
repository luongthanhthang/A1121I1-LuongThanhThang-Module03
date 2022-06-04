package model.service.impl;

import model.bean.User;
import model.repository.IUserRepository;
import model.repository.impl.UserRepository;
import model.service.IUserService;
import utils.Validation;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService implements IUserService {
    IUserRepository userRepository = new UserRepository();


    @Override
    public Map<String, String> insertUser(User user) throws SQLException {
        // cần kiểm tra dự liệu
        // +nếu mà ok => gọi repository để lưu.
        Map<String, String> map = new HashMap<>();

        if(!Validation.checkEmail(user.getEmail())){
            map.put("email", "Email không đúng định dạng");
        }

        // nếu không lỗi thì thêm
        if (map.isEmpty()){
            userRepository.insertUser(user);
        }

        return map;
    }

    @Override
    public User selectUser(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUser() {
        return userRepository.selectAllUser();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userRepository.updateUser(user);
    }

    @Override
    public List<User> searchUser(String country) {
        return userRepository.searchUser(country);
    }

    @Override
    public List<User> sortUser(String sortType) {
        return userRepository.sortUser(sortType);
    }
}
