package model.repository;

import model.bean.Product;

import java.util.List;

//        Hiển thị danh sách sản phẩm
//        Tạo sản phẩm mới
//        Cập nhật thông tin sản phẩm
//        Xoá một sản phẩm
//        Xem chi tiết một sản phẩm
//        Tìm kiếm sản phẩm theo tên
public interface IProductRepository {
    //        Hiển thị danh sách sản phẩm
    List<Product> findAll();

    //        Tạo sản phẩm mới
    void save(Product product);

    //        Cập nhật thông tin sản phẩm
    void update(int id, Product product);

    //        Xoá một sản phẩm
    void remove(int id);

    //        Tìm kiếm sản phẩm theo tên
    Product findByName(String name);

    //        Xem chi tiết một sản phẩm
    Product findById(int id);
}
