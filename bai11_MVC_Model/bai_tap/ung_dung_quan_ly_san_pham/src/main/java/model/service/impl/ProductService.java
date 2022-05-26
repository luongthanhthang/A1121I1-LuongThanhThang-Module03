package model.service.impl;

import model.bean.Product;
import model.repository.IProductRepository;
import model.repository.impl.ProductRepository;
import model.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    // lấy dữ liệu từ repository
    IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }
}
