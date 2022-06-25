package model.repository;

import model.bean.Product;

import java.util.List;
import java.util.Map;

public interface IProductRepository {
    List<Product> findAll();
    boolean insert(Product product);
    boolean delete(Integer id);
    boolean update(Product product);
    Product findById(Integer id);
    List<Product> search(String name);
}
