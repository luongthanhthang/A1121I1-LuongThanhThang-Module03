package model.service;

import model.bean.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAllCustomer();
    List<Customer> searchCustomer(String nameSearch, String emailSearch, String typeSearch);
    boolean insertCustomer(Customer customer);
    boolean deleteCustomer(int id);
    boolean updateCustomer(Customer customer);
    Customer selectCustomer(int id);
}
