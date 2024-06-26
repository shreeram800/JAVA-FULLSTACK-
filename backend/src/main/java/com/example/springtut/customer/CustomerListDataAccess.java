package com.example.springtut.customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

  @Repository("list")
public class CustomerListDataAccess implements CustomerDao{

    private static final List<Customer> customers;

    static {
        customers=new ArrayList<>();
        Customer alex= new Customer(1,"alex","jcnsjcndjkc",21, "Male");
        customers.add(alex);

    }
    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream().filter(c ->c.getId().equals(id)).findFirst();
    }

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean existPersonWithEmail(String email) {
        return customers.stream().anyMatch(c-> c.getEmail().equals(email));
    }

    @Override
    public boolean existPersonWithId(Integer id) {
        return  customers.stream().anyMatch(c->c.getId().equals(id));
    }
    @Override
    public void deleteCustomerById(Integer id) {
        customers.removeIf(customer -> id.equals(customer.getId()));
    }

      @Override
      public void updateCustomer(Customer customer) {
          customers.removeIf(c -> c.getId().equals(customer.getId()));
          customers.add(customer);
      }

  }
