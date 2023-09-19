package com.example.kotlinspringbootjpaflywaysample.service

import com.example.kotlinspringbootjpaflywaysample.entity.Customer
import com.example.kotlinspringbootjpaflywaysample.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService(private val customerRepository: CustomerRepository) {

    fun saveCustomer(customer:Customer) {
        customerRepository.save(customer)
    }

    fun getAllCustomers(): MutableList<Customer> {
        return customerRepository.findAll()
    }

    fun getCustomerById(id:Long): Optional<Customer> {
        return customerRepository.findById(id)
    }

    fun deleteCustomerById(id: Long) {
        customerRepository.deleteById(id)
    }
}