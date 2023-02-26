package com.udacity.jdnd.course3.critter.Service;

import com.udacity.jdnd.course3.critter.Entity.Customer;
import com.udacity.jdnd.course3.critter.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){return customerRepository.save(customer);
    }
    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }
    public Customer findOwnerByPet(Long id){
        return customerRepository.findByPetsId(id);
    }
    public Customer findOwnerById(Long id){return customerRepository.findById(id).get();
    }
}
