package model.service.Impl;

import model.bean.Product;
import model.repository.IProductRepository;
import model.repository.Impl.ProductRepositoryImpl;
import model.service.ICategoryService;
import model.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean insert(Product product) {
        return productRepository.insert(product);
    }

    @Override
    public boolean delete(Integer id) {
        return productRepository.delete(id);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.search(name);
    }
}
