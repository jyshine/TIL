package com.example.kotlinspringbootjpaflywaysample.service

import com.example.kotlinspringbootjpaflywaysample.entity.Customer
import com.example.kotlinspringbootjpaflywaysample.repository.CustomerRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CustomerServiceTest @Autowired constructor(
    val customerService: CustomerService
){

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun saveCustomer() {
        val customer = Customer("test","test@test.com")
        customerService.saveCustomer(customer)
    }

    @Test
    fun getAllCustomers() {
    }

    @Test
    fun getCustomerById() {
    }

    @Test
    fun deliteCustomerById() {
    }
}