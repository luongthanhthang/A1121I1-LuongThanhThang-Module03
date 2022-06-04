package model.repository.impl;

import model.bean.User;
import model.repository.BaseRepository;
import model.repository.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {

    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select * from users where id =?";
    private static final String UPDATE_USERS_SQL = "update users set name = ?, email= ?, country =? where id = ?;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String SEARCH_USERS_SQL = "select * from users where country = ?;";
    private static final String SORT_USERS_SQL_NAME = "select * from users order by name ASC;";
    private static final String SORT_USERS_SQL_EMAIL = "select * from users order by email ASC;";
    private static final String SORT_USERS_SQL_COUNTRY = "select * from users order by country ASC;";

    public UserRepository() {
    }

    @Override
    public List<User> selectAllUser() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> userList = new ArrayList<>();
        // Step 1: Thiết lập kết nối
        try (Connection connection = BaseRepository.getConnect();
             // Step 2:Tạo một câu lệnh bằng cách sử dụng đối tượng kết nối
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USERS);) {

            // Step 3: Thực thi truy vấn hoặc cập nhật truy vấn
            ResultSet resultSet = ps.executeQuery();

            // Step 4: Xử lý đối tượng ResultSet
            while (resultSet.next()) {
                // lấy từ database
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id, name, email, country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean insertUser(User user) {
        // try-with-resource statement will auto close the connection.
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            int update = ps.executeUpdate();
            if (update != 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnect();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {

            preparedStatement.setInt(1, id);
            // Step 3: Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }


    @Override
    public boolean updateUser(User user) {
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            int update = statement.executeUpdate();
            if (update != 0) {
                // thêm mới thành công
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // thêm mới thất bại
        return false;
    }


    @Override
    public boolean deleteUser(int id) {
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            int update = statement.executeUpdate();
            if (update != 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> searchUser(String country) {
        List<User> userListSearch = new ArrayList<>();
        User user = null;
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS_SQL);) {
            preparedStatement.setString(1, country);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String countrySql = resultSet.getString("country");
                user = new User(id, name, email, countrySql);
                userListSearch.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userListSearch;
    }

    @Override
    public List<User> sortUser(String sortType) {
        ArrayList<User> userArrayListSort = new ArrayList<>();
        User user = null;
        switch (sortType) {
            case "name":
                try (Connection connection = BaseRepository.getConnect();
                     PreparedStatement preparedStatement = connection.prepareStatement(SORT_USERS_SQL_NAME);) {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        String country = resultSet.getString("country");
                        user = new User(id, name, email, country);
                        userArrayListSort.add(user);
                    }
                    return userArrayListSort;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;

            case "email":
                try (Connection connection = BaseRepository.getConnect();
                     PreparedStatement preparedStatement = connection.prepareStatement(SORT_USERS_SQL_EMAIL);) {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        String country = resultSet.getString("country");
                        user = new User(id, name, email, country);
                        userArrayListSort.add(user);
                    }
                    return userArrayListSort;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            case "country":
                try (Connection connection = BaseRepository.getConnect();
                     PreparedStatement preparedStatement = connection.prepareStatement(SORT_USERS_SQL_COUNTRY);) {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        String country = resultSet.getString("country");
                        user = new User(id, name, email, country);
                        userArrayListSort.add(user);
                    }
                    return userArrayListSort;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }

        return selectAllUser();
    }


//    ++++++++++++xoá++++++++++++
//    private void printSQLException(SQLException ex) {
//        for (Throwable e : ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }
}