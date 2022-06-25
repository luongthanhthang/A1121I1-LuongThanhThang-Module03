package model.repository.Impl;

import model.bean.Category;
import model.bean.Product;
import model.repository.BaseRepository;
import model.repository.ICategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CategoryRepositoryImpl implements ICategoryRepository {

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from category;");) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("category_id");
                String name = resultSet.getString("category_name");
                categoryList.add(new Category(id, name));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryList;
    }
}
