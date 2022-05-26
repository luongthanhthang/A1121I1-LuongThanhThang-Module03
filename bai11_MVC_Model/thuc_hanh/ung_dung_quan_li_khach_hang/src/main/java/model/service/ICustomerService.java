package model.service;

import model.bean.Customer;

import java.util.List;


public interface ICustomerService {
    //        findAll(): Trả về danh sách tất cả khách hàng
    List<Customer> findALl();

    //        save(): Lưu một khách hàng
    void save(Customer customer);

    //        findById(): Tìm một khách hàng theo Id
    Customer findById(int id);

    //        update(): Cập nhật thông tin của một khách hàng
    void update(int id, Customer customer);

    //        remove(): Xoá một khách hàng khỏi danh sách
    void remove(int id);
}
