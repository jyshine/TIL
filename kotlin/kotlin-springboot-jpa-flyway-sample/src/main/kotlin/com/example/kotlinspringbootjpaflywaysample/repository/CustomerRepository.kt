package com.example.kotlinspringbootjpaflywaysample.repository

import com.example.kotlinspringbootjpaflywaysample.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer,Long> {
}