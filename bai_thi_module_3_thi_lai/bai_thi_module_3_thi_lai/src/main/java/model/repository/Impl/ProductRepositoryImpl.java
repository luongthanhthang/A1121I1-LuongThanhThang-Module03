package model.repository.Impl;

import model.bean.Product;
import model.repository.BaseRepository;
import model.repository.IProductRepository;
import util.Validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductRepositoryImpl implements IProductRepository {
    private static final String SELECT_ALL = "select product_id, product_name, product_price, product_quantity, product_color, category_id from product;";
    private static final String INSERT = "insert into product(product_name, product_price, product_quantity, product_color, product_describe, category_id) values (?,?,?,?,?,?);";
    private static final String DELETE = "delete from product where product_id = ?;";
    private static final String UPDATE = "update product set product_name = ?, product_price = ?, product_quantity = ?, product_color = ?, product_describe = ?, category_id = ?  where product_id = ?;";
    private static final String SELECT_BY_ID = "select * from product where product_id =?";
    private static final String SEARCH = "select * from product where product_name like ?;";


    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                Double price = resultSet.getDouble("product_price");
                Integer quantity = resultSet.getInt("product_quantity");
                String color = resultSet.getString("product_color");
                Integer categoryId = resultSet.getInt("category_id");
                productList.add(new Product(id, name, price, quantity, color, categoryId));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public boolean insert(Product product) {
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement ps = connection.prepareStatement(INSERT)) {
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setString(4, product.getColor());
            ps.setString(5, product.getDescribe());
            ps.setInt(6, product.getCategoryId());
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
    public boolean delete(Integer id) {
        Connection connection = BaseRepository.getConnect();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE);) {
            preparedStatement.setInt(1, id);
            int update = preparedStatement.executeUpdate();
            if (update != 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement ps = connection.prepareStatement(UPDATE);) {

            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setString(4, product.getColor());
            ps.setString(5, product.getDescribe());
            ps.setInt(6, product.getCategoryId());
            ps.setInt(7, product.getId());

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
    public Product findById(Integer id) {
        Product product = null;
        try (Connection connection = BaseRepository.getConnect();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {

            preparedStatement.setInt(1, id);
            // Step 3: Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                String name = resultSet.getString("product_name");
                Double price = resultSet.getDouble("product_price");
                Integer quantity = resultSet.getInt("product_quantity");
                String color = resultSet.getString("product_color");
                Integer categoryId = resultSet.getInt("category_id");
                product = new Product(id, name, price, quantity, color, categoryId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement ps = connection.prepareStatement(SEARCH);
            ps.setString(1, "%" + name + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("product_id");
                String nameProduct = resultSet.getString("product_name");
                Double price = resultSet.getDouble("product_price");
                Integer quantity = resultSet.getInt("product_quantity");
                String color = resultSet.getString("product_color");
                Integer categoryId = resultSet.getInt("category_id");
                productList.add(new Product(id, nameProduct, price, quantity, color, categoryId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }
}
