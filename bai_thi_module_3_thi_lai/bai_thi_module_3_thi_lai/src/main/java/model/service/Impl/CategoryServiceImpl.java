package model.service.Impl;

import model.bean.Category;
import model.bean.Product;
import model.repository.ICategoryRepository;
import model.repository.Impl.CategoryRepositoryImpl;
import model.service.ICategoryService;
import model.service.IProductService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    ICategoryRepository categoryRepository = new CategoryRepositoryImpl();

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
