package model.service.impl;

import model.bean.Customer;
import model.repository.ICustomerRepository;
import model.repository.impl.CustomerRepositoryImpl;
import model.service.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAllCustomer();
    }

    @Override
    public List<Customer> searchCustomer(String nameSearch, String emailSearch, String typeSearch) {
        return customerRepository.searchCustomer(nameSearch, emailSearch, typeSearch);
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        return customerRepository.insertCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public Customer selectCustomer(int id) {
        return customerRepository.selectCustomer(id);
    }
}
